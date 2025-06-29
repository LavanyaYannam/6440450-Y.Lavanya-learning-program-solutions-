-- Drop and recreate accounts table
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE accounts CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE accounts (
   account_id NUMBER PRIMARY KEY,
   customer_name VARCHAR2(100),
   balance NUMBER
);
/

-- Sample data
INSERT INTO accounts VALUES (101, 'Ravi', 8000);
INSERT INTO accounts VALUES (102, 'Meena', 12000);
COMMIT;
/

-- Show before transfer
PROMPT === Accounts Table BEFORE Transfer ===
SELECT * FROM accounts;
/

-- Procedure with error handling
CREATE OR REPLACE PROCEDURE SafeTransferFunds (
   from_acc_id IN NUMBER,
   to_acc_id IN NUMBER,
   amount IN NUMBER
) IS
   from_balance NUMBER;
BEGIN
   SELECT balance INTO from_balance FROM accounts WHERE account_id = from_acc_id;

   IF from_balance < amount THEN
      RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for transfer');
   END IF;

   -- Perform transfer
   UPDATE accounts SET balance = balance - amount WHERE account_id = from_acc_id;
   UPDATE accounts SET balance = balance + amount WHERE account_id = to_acc_id;

   COMMIT;
   DBMS_OUTPUT.PUT_LINE('✅ Transferred ' || amount || ' from ' || from_acc_id || ' to ' || to_acc_id);
EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('❌ Error: ' || SQLERRM);
END;
/

-- Call the procedure
BEGIN
   SafeTransferFunds(101, 102, 3000);
END;
/

-- Show after transfer
PROMPT === Accounts Table AFTER Transfer ===
SELECT * FROM accounts;
/
