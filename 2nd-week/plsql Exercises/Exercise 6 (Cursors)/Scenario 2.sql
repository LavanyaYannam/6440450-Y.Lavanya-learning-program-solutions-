-- Drop and recreate accounts table
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE accounts CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE accounts (
   account_id NUMBER PRIMARY KEY,
   holder_name VARCHAR2(100),
   balance NUMBER
);
/

-- Sample data
INSERT INTO accounts VALUES (201, 'Ravi', 5000);
INSERT INTO accounts VALUES (202, 'Sneha', 3000);
INSERT INTO accounts VALUES (203, 'Kiran', 7000);
COMMIT;
/

PROMPT === Accounts BEFORE Annual Fee ===
SELECT * FROM accounts;
/

-- Cursor to deduct annual fee
DECLARE
   CURSOR acc_cursor IS
      SELECT account_id FROM accounts;

   fee CONSTANT NUMBER := 500;
BEGIN
   FOR rec IN acc_cursor LOOP
      UPDATE accounts
      SET balance = balance - fee
      WHERE account_id = rec.account_id;

      DBMS_OUTPUT.PUT_LINE('💸 Annual fee of ₹' || fee || ' deducted from Account ID: ' || rec.account_id);
   END LOOP;

   COMMIT;
END;
/

PROMPT === Accounts AFTER Annual Fee ===
SELECT * FROM accounts;
/
