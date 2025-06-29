-- 1. Create accounts table
CREATE TABLE accounts (
   account_id NUMBER PRIMARY KEY,
   customer_name VARCHAR2(100),
   balance NUMBER
);
/

-- 2. Insert sample data
INSERT INTO accounts VALUES (101, 'Ravi', 8000);
INSERT INTO accounts VALUES (102, 'Meena', 12000);
COMMIT;
/

-- 3. Create transfer procedure
CREATE OR REPLACE PROCEDURE TransferFunds (
   from_acc_id IN NUMBER,
   to_acc_id IN NUMBER,
   amount IN NUMBER
) IS
   from_balance NUMBER;
BEGIN
   -- Get balance of source account
   SELECT balance INTO from_balance FROM accounts WHERE account_id = from_acc_id;

   -- Check for sufficient funds
   IF from_balance < amount THEN
      DBMS_OUTPUT.PUT_LINE('❌ Insufficient balance for transfer.');
   ELSE
      -- Perform transfer
      UPDATE accounts
      SET balance = balance - amount
      WHERE account_id = from_acc_id;

      UPDATE accounts
      SET balance = balance + amount
      WHERE account_id = to_acc_id;

      COMMIT;
      DBMS_OUTPUT.PUT_LINE('✅ Transferred ' || amount || ' from Account ' || from_acc_id || ' to Account ' || to_acc_id);
   END IF;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('❌ One of the accounts does not exist.');
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('❌ Error: ' || SQLERRM);
END;
/

-- 4. Call the procedure
BEGIN
   TransferFunds(101, 102, 2000);
END;
/

-- 5. Check account balances
SELECT * FROM accounts;
/
