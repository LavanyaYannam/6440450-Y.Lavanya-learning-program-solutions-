-- Drop and recreate accounts and transactions
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE transactions CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE accounts CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE accounts (
   account_id NUMBER PRIMARY KEY,
   holder_name VARCHAR2(100),
   balance NUMBER
);
/

CREATE TABLE transactions (
   txn_id NUMBER PRIMARY KEY,
   account_id NUMBER,
   txn_type VARCHAR2(20),
   amount NUMBER,
   txn_date DATE
);
/

-- Sample data
INSERT INTO accounts VALUES (301, 'Ravi', 5000);
INSERT INTO accounts VALUES (302, 'Sneha', 2000);
COMMIT;
/

PROMPT === Accounts BEFORE Transactions ===
SELECT * FROM accounts;
/

-- Trigger: Enforce rules
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON transactions
FOR EACH ROW
DECLARE
   acc_balance NUMBER;
BEGIN
   SELECT balance INTO acc_balance FROM accounts WHERE account_id = :NEW.account_id;

   IF :NEW.txn_type = 'withdrawal' AND :NEW.amount > acc_balance THEN
      RAISE_APPLICATION_ERROR(-20001, '❌ Insufficient funds.');
   ELSIF :NEW.txn_type = 'deposit' AND :NEW.amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20002, '❌ Deposit must be positive.');
   END IF;
END;
/

-- Valid and invalid operations
BEGIN
   INSERT INTO transactions VALUES (4001, 301, 'withdrawal', 1000, SYSDATE);
   DBMS_OUTPUT.PUT_LINE('✅ Valid withdrawal inserted.');
EXCEPTION
   WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

BEGIN
   INSERT INTO transactions VALUES (4002, 302, 'withdrawal', 3000, SYSDATE);
   DBMS_OUTPUT.PUT_LINE('❌ Should not insert this!');
EXCEPTION
   WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

BEGIN
   INSERT INTO transactions VALUES (4003, 302, 'deposit', -200, SYSDATE);
   DBMS_OUTPUT.PUT_LINE('❌ Should not insert this!');
EXCEPTION
   WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

BEGIN
   INSERT INTO transactions VALUES (4004, 302, 'deposit', 1000, SYSDATE);
   DBMS_OUTPUT.PUT_LINE('✅ Valid deposit inserted.');
   COMMIT;
END;
/

PROMPT === Transactions AFTER Trigger Execution ===
SELECT * FROM transactions;
/
