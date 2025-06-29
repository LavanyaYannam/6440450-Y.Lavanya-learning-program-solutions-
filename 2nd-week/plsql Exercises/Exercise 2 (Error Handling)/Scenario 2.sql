-- Drop and recreate employees table
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE employees CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE employees (
   emp_id NUMBER PRIMARY KEY,
   name VARCHAR2(100),
   department VARCHAR2(50),
   salary NUMBER
);
/

-- Insert data
INSERT INTO employees VALUES (1, 'Sam', 'HR', 30000);
INSERT INTO employees VALUES (2, 'Rita', 'IT', 50000);
COMMIT;
/

-- Show before update
PROMPT === Employees Table BEFORE Update ===
SELECT * FROM employees;
/

-- Procedure with error handling
CREATE OR REPLACE PROCEDURE UpdateSalary (
   emp_id IN NUMBER,
   bonus_percent IN NUMBER
) IS
BEGIN
   UPDATE employees
   SET salary = salary + (salary * bonus_percent / 100)
   WHERE emp_id = emp_id;

   IF SQL%ROWCOUNT = 0 THEN
      RAISE_APPLICATION_ERROR(-20002, 'Employee ID not found');
   END IF;

   COMMIT;
   DBMS_OUTPUT.PUT_LINE('✅ Salary updated for Employee ID ' || emp_id);
EXCEPTION
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('❌ Error: ' || SQLERRM);
END;
/

-- Call procedure (you can test with emp_id = 3 to see error)
BEGIN
   UpdateSalary(1, 10);
END;
/

-- Show after update
PROMPT === Employees Table AFTER Update ===
SELECT * FROM employees;
/
