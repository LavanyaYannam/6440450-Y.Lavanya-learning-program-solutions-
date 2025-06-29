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
   balance NUMBER,
   last_modified DATE
);
/

-- Insert data
INSERT INTO customers VALUES (1, 'John', 40, 10000, NULL);
INSERT INTO customers VALUES (2, 'Mary', 30, 5000, NULL);
COMMIT;
/

PROMPT === Customers Table BEFORE Update ===
SELECT * FROM customers;
/

-- Trigger: Auto-update last_modified
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON customers
FOR EACH ROW
BEGIN
   :NEW.last_modified := SYSDATE;
END;
/

-- Update to trigger the logic
BEGIN
   UPDATE customers SET balance = balance + 500 WHERE customer_id = 1;
   DBMS_OUTPUT.PUT_LINE('✅ Customer updated. Trigger fired to set last_modified.');
END;
/

PROMPT === Customers Table AFTER Update ===
SELECT * FROM customers;
/
