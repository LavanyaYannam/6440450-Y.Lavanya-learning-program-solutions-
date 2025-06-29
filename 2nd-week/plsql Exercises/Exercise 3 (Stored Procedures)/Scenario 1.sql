-- 1. Create savings_accounts table
CREATE TABLE savings_accounts (
   account_id NUMBER PRIMARY KEY,
   customer_name VARCHAR2(100),
   balance NUMBER
);
/

-- 2. Insert sample data
INSERT INTO savings_accounts VALUES (1, 'John', 10000);
INSERT INTO savings_accounts VALUES (2, 'Alice', 5000);
INSERT INTO savings_accounts VALUES (3, 'Bob', 2000);
COMMIT;
/

-- 3. Create stored procedure
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
   FOR acc IN (SELECT account_id, balance FROM savings_accounts) LOOP
      UPDATE savings_accounts
      SET balance = balance + (balance * 0.01)
      WHERE account_id = acc.account_id;
   END LOOP;

   COMMIT;
   DBMS_OUTPUT.PUT_LINE('✅ Monthly interest processed for all savings accounts.');
END;
/

-- 4. Call the procedure
BEGIN
   ProcessMonthlyInterest;
END;
/

-- 5. Check results
SELECT * FROM savings_accounts;
/
