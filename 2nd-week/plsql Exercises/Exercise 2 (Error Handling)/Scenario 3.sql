-- Drop and recreate customers table
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE customers CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE customers (
   customer_id NUMBER PRIMARY KEY,
   name VARCHAR2(100),
   age NUMBER,
   balance NUMBER
);
/

-- Insert sample data
INSERT INTO customers VALUES (1, 'John', 45, 8000);
COMMIT;
/

-- Show before insertion
PROMPT === Customers Table BEFORE Insertion ===
SELECT * FROM customers;
/

-- Create procedure with detailed exception handling
CREATE OR REPLACE PROCEDURE AddNewCustomer (
   cid IN NUMBER,
   cname IN VARCHAR2,
   cage IN NUMBER,
   cbalance IN NUMBER
) IS
BEGIN
   INSERT INTO customers VALUES (cid, cname, cage, cbalance);
   COMMIT;
   DBMS_OUTPUT.PUT_LINE('✅ Customer inserted: ' || cname);
EXCEPTION
   WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('❌ Error: Duplicate entry - Customer ID ' || cid || ' already exists.');
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('❌ General Error: ' || SQLERRM);
END;
/

-- Call with duplicate ID to show exception
PROMPT === Attempt to Insert Duplicate Customer ===
BEGIN
   AddNewCustomer(1, 'John', 50, 10000);
END;
/

-- Call with new valid ID
PROMPT === Attempt to Insert Valid Customer ===
BEGIN
   AddNewCustomer(2, 'Mary', 30, 12000);
END;
/

-- Show after all insertions
PROMPT === Customers Table AFTER Insertion Attempts ===
SELECT * FROM customers;
/
