-- Drop and recreate tables
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE transactions CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE customers CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE customers (
   customer_id NUMBER PRIMARY KEY,
   name VARCHAR2(100)
);
/

CREATE TABLE transactions (
   txn_id NUMBER PRIMARY KEY,
   customer_id NUMBER,
   amount NUMBER,
   txn_date DATE,
   FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
/

-- Sample data
INSERT INTO customers VALUES (1, 'John');
INSERT INTO customers VALUES (2, 'Mary');

INSERT INTO transactions VALUES (101, 1, 2000, SYSDATE - 10);
INSERT INTO transactions VALUES (102, 2, 1500, SYSDATE - 20);
INSERT INTO transactions VALUES (103, 1, 3000, ADD_MONTHS(SYSDATE, -2));
COMMIT;
/

PROMPT === Transactions This Month ===
SELECT * FROM transactions WHERE TO_CHAR(txn_date, 'MM-YYYY') = TO_CHAR(SYSDATE, 'MM-YYYY');
/

-- Cursor to generate statements
DECLARE
   CURSOR txn_cursor IS
      SELECT c.name, t.amount, TO_CHAR(t.txn_date, 'DD-Mon') AS txn_day
      FROM customers c
      JOIN transactions t ON c.customer_id = t.customer_id
      WHERE TO_CHAR(t.txn_date, 'MM-YYYY') = TO_CHAR(SYSDATE, 'MM-YYYY');
BEGIN
   FOR rec IN txn_cursor LOOP
      DBMS_OUTPUT.PUT_LINE('📄 Statement: ' || rec.name || ' made a transaction of ₹' || rec.amount || ' on ' || rec.txn_day);
   END LOOP;
END;
/
