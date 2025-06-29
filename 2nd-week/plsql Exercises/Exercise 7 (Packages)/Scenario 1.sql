-- Drop and recreate customers table
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE customers CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE customers (
   customer_id NUMBER PRIMARY KEY,
   name VARCHAR2(100),
   age NUMBER,
   balance NUMBER
);
/

-- Package Specification
CREATE OR REPLACE PACKAGE CustomerManagement AS
   PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER, p_balance NUMBER);
   PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER);
   FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
   PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER, p_balance NUMBER) IS
   BEGIN
      INSERT INTO customers VALUES (p_id, p_name, p_age, p_balance);
      DBMS_OUTPUT.PUT_LINE('✅ Customer added: ' || p_name);
   END;

   PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER) IS
   BEGIN
      UPDATE customers SET name = p_name, age = p_age WHERE customer_id = p_id;
      DBMS_OUTPUT.PUT_LINE('✅ Customer updated: ' || p_name);
   END;

   FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
      v_balance NUMBER;
   BEGIN
      SELECT balance INTO v_balance FROM customers WHERE customer_id = p_id;
      RETURN v_balance;
   END;
END CustomerManagement;
/

-- Test Calls
BEGIN
   CustomerManagement.AddCustomer(1, 'Alice', 30, 10000);
   CustomerManagement.UpdateCustomer(1, 'Alice B', 31);
   DBMS_OUTPUT.PUT_LINE('Balance: ₹' || CustomerManagement.GetCustomerBalance(1));
END;
/

-- Check Data
PROMPT === Customers Table ===
SELECT * FROM customers;
/
