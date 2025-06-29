-- Drop and recreate customers table with DOB
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE customers CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE customers (
   customer_id NUMBER PRIMARY KEY,
   name VARCHAR2(100),
   dob DATE
);
/

-- Insert sample data
INSERT INTO customers VALUES (1, 'John', TO_DATE('1990-06-15', 'YYYY-MM-DD'));
INSERT INTO customers VALUES (2, 'Rita', TO_DATE('2005-08-25', 'YYYY-MM-DD'));
COMMIT;
/

-- Show before logic
PROMPT === Customers Table BEFORE Age Calculation ===
SELECT * FROM customers;
/

-- Create function to calculate age
CREATE OR REPLACE FUNCTION CalculateAge (dob IN DATE)
RETURN NUMBER IS
   years NUMBER;
BEGIN
   years := TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12);
   RETURN years;
END;
/

-- Call the function and print results
PROMPT === Age Calculation Output ===
BEGIN
   DBMS_OUTPUT.PUT_LINE('Age of John: ' || CalculateAge(TO_DATE('1990-06-15', 'YYYY-MM-DD')));
   DBMS_OUTPUT.PUT_LINE('Age of Rita: ' || CalculateAge(TO_DATE('2005-08-25', 'YYYY-MM-DD')));
END;
/
