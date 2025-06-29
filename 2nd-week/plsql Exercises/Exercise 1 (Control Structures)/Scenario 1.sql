-- 1. Drop tables if they exist
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE loans CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE customers CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

-- 2. Create Customers Table
CREATE TABLE customers (
   customer_id NUMBER PRIMARY KEY,
   name VARCHAR2(100),
   age NUMBER,
   balance NUMBER,
   isvip VARCHAR2(5)
);
/

-- 3. Create Loans Table
CREATE TABLE loans (
   loan_id NUMBER PRIMARY KEY,
   customer_id NUMBER,
   interest_rate NUMBER,
   due_date DATE,
   FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
/

-- 4. Insert Sample Data
INSERT INTO customers VALUES (1, 'John Doe', 65, 15000, 'FALSE');
INSERT INTO customers VALUES (2, 'Jane Smith', 45, 8000, 'FALSE');
INSERT INTO customers VALUES (3, 'Mary Senior', 70, 11000, 'FALSE');

INSERT INTO loans VALUES (101, 1, 10.5, SYSDATE + 20);
INSERT INTO loans VALUES (102, 2, 9.0, SYSDATE + 40);
INSERT INTO loans VALUES (103, 3, 11.0, SYSDATE + 10);

COMMIT;
/

-- 5. Enable Output Panel
SET SERVEROUTPUT ON;
/

-- 6. Show loans table BEFORE discount
PROMPT === Loans Table BEFORE Discount ===
SELECT loan_id, customer_id, interest_rate, due_date FROM loans;
/

-- 7. PL/SQL Block to Apply 1% Discount for Age > 60
BEGIN
   FOR rec IN (
       SELECT l.loan_id, l.interest_rate
       FROM loans l
       JOIN customers c ON l.customer_id = c.customer_id
       WHERE c.age > 60
   ) LOOP
      UPDATE loans
      SET interest_rate = interest_rate - 1
      WHERE loan_id = rec.loan_id;
   END LOOP;

   COMMIT;
   DBMS_OUTPUT.PUT_LINE('✅ Discount applied to eligible senior customers.');
END;
/

-- 8. Show loans table AFTER discount
PROMPT === Loans Table AFTER Discount ===
SELECT loan_id, customer_id, interest_rate, due_date FROM loans;
/
