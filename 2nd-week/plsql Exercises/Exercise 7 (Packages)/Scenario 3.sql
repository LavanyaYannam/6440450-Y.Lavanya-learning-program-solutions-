-- Drop and recreate accounts table
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE accounts CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE accounts (
   account_id NUMBER PRIMARY KEY,
   customer_id NUMBER,
   balance NUMBER
);
/

-- Package Specification
CREATE OR REPLACE PACKAGE AccountOperations AS
   PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_balance NUMBER);
   PROCEDURE CloseAccount(p_acc_id NUMBER);
   FUNCTION TotalBalance(p_cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY AccountOperations AS
   PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_balance NUMBER) IS
   BEGIN
      INSERT INTO accounts VALUES (p_acc_id, p_cust_id, p_balance);
      DBMS_OUTPUT.PUT_LINE('✅ Account Opened: ' || p_acc_id);
   END;

   PROCEDURE CloseAccount(p_acc_id NUMBER) IS
   BEGIN
      DELETE FROM accounts WHERE account_id = p_acc_id;
      DBMS_OUTPUT.PUT_LINE('✅ Account Closed: ' || p_acc_id);
   END;

   FUNCTION TotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
      v_total NUMBER := 0;
   BEGIN
      SELECT SUM(balance) INTO v_total FROM accounts WHERE customer_id = p_cust_id;
      RETURN NVL(v_total, 0);
   END;
END AccountOperations;
/

-- Test Calls
BEGIN
   AccountOperations.OpenAccount(501, 1, 7000);
   AccountOperations.OpenAccount(502, 1, 3000);
   DBMS_OUTPUT.PUT_LINE('Total Balance: ₹' || AccountOperations.TotalBalance(1));
   AccountOperations.CloseAccount(502);
END;
/

-- Check Data
PROMPT === Accounts Table ===
SELECT * FROM accounts;
/
