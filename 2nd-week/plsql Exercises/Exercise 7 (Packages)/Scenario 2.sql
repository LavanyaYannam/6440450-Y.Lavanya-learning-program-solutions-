-- Drop and recreate employees table
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE employees CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE employees (
   emp_id NUMBER PRIMARY KEY,
   name VARCHAR2(100),
   department VARCHAR2(50),
   salary NUMBER
);
/

-- Package Specification
CREATE OR REPLACE PACKAGE EmployeeManagement AS
   PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_dept VARCHAR2, p_salary NUMBER);
   PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2, p_salary NUMBER);
   FUNCTION AnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
   PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_dept VARCHAR2, p_salary NUMBER) IS
   BEGIN
      INSERT INTO employees VALUES (p_id, p_name, p_dept, p_salary);
      DBMS_OUTPUT.PUT_LINE('✅ Hired: ' || p_name);
   END;

   PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2, p_salary NUMBER) IS
   BEGIN
      UPDATE employees SET name = p_name, salary = p_salary WHERE emp_id = p_id;
      DBMS_OUTPUT.PUT_LINE('✅ Updated Employee: ' || p_name);
   END;

   FUNCTION AnnualSalary(p_id NUMBER) RETURN NUMBER IS
      v_salary NUMBER;
   BEGIN
      SELECT salary INTO v_salary FROM employees WHERE emp_id = p_id;
      RETURN v_salary * 12;
   END;
END EmployeeManagement;
/

-- Test Calls
BEGIN
   EmployeeManagement.HireEmployee(101, 'Bob', 'IT', 45000);
   EmployeeManagement.UpdateEmployee(101, 'Bob M', 46000);
   DBMS_OUTPUT.PUT_LINE('Annual Salary: ₹' || EmployeeManagement.AnnualSalary(101));
END;
/

-- Check Data
PROMPT === Employees Table ===
SELECT * FROM employees;
/
