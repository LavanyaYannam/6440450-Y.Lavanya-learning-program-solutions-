-- Drop and recreate tables
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE audit_log CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE transactions CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE transactions (
   txn_id NUMBER PRIMARY KEY,
   account_id NUMBER,
   txn_type VARCHAR2(20),
   amount NUMBER,
   txn_date DATE
);
/

CREATE TABLE audit_log (
   log_id NUMBER GENERATED ALWAYS AS IDENTITY,
   txn_id NUMBER,
   log_message VARCHAR2(255),
   log_time DATE DEFAULT SYSDATE
);
/

-- Trigger to log every insert
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON transactions
FOR EACH ROW
BEGIN
   INSERT INTO audit_log (txn_id, log_message)
   VALUES (:NEW.txn_id, 'Txn ' || :NEW.txn_type || ' of ₹' || :NEW.amount || ' recorded.');
END;
/

-- Insert transactions
BEGIN
   INSERT INTO transactions VALUES (2001, 1, 'deposit', 1000, SYSDATE);
   INSERT INTO transactions VALUES (2002, 1, 'withdrawal', 500, SYSDATE);
   COMMIT;
   DBMS_OUTPUT.PUT_LINE('✅ Transactions inserted. Audit trigger fired.');
END;
/

PROMPT === Transactions Table ===
SELECT * FROM transactions;
/

PROMPT === Audit Log Table ===
SELECT * FROM audit_log;
/
