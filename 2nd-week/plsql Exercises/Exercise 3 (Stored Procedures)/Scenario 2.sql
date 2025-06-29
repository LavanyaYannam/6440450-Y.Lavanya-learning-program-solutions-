-- 1. Create employees table
CREATE TABLE employees (
   emp_id NUMBER PRIMARY KEY,
   name VARCHAR2(100),
   department VARCHAR2(50),
   salary NUMBER
);
/

-- 2. Insert sample data
INSERT INTO employees VALUES (1, 'Sam', 'HR', 30000);
INSERT INTO employees VALUES (2, 'Rita', 'IT', 50000);
INSERT INTO employees VALUES (3, 'Tom', 'HR', 32000);
COMMIT;
/

SELECT * FROM employees;
/
-- 3. Create procedure to update salary with bonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
   dept_name IN VARCHAR2,
   bonus_percent IN NUMBER
) IS
BEGIN
   UPDATE employees
   SET salary = salary + (salary * bonus_percent / 100)
   WHERE department = dept_name;

   COMMIT;
   DBMS_OUTPUT.PUT_LINE('✅ Bonus applied to department: ' || dept_name);
END;
/

-- 4. Call the procedure with test values
BEGIN
   UpdateEmployeeBonus('HR', 10); -- 10% bonus to HR
END;
/

-- 5. Check results
SELECT emp_id, name, department, salary FROM employees;
/
