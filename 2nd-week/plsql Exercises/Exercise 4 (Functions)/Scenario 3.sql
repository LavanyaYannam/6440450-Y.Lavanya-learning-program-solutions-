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

-- Insert sample data
INSERT INTO accounts VALUES (101, 'Ravi', 7000);
INSERT INTO accounts VALUES (102, 'Meena', 1500);
COMMIT;
/

-- Show before logic
PROMPT === Accounts Table BEFORE Balance Check ===
SELECT * FROM accounts;
/

-- Create function to check sufficient balance
CREATE OR REPLACE FUNCTION HasSufficientBalance (
   acc_id IN NUMBER,
   required_amount IN NUMBER
) RETURN BOOLEAN IS
   acc_balance NUMBER;
BEGIN
   SELECT balance INTO acc_balance FROM accounts WHERE account_id = acc_id;
   RETURN acc_balance >= required_amount;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      RETURN FALSE;
END;
/

-- Call function and print result
PROMPT === Balance Check Output ===
DECLARE
   result BOOLEAN;
BEGIN
   result := HasSufficientBalance(101, 3000);
   DBMS_OUTPUT.PUT_LINE('Account 101 has sufficient balance? → ' || CASE WHEN result THEN 'YES' ELSE 'NO' END);

   result := HasSufficientBalance(102, 5000);
   DBMS_OUTPUT.PUT_LINE('Account 102 has sufficient balance? → ' || CASE WHEN result THEN 'YES' ELSE 'NO' END);
END;
/

-- Show after logic (table remains unchanged)
PROMPT === Accounts Table AFTER Balance Check ===
SELECT * FROM accounts;
/
