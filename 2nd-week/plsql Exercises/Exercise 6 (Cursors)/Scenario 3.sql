-- Drop and recreate loans table
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE loans CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE loans (
   loan_id NUMBER PRIMARY KEY,
   customer_id NUMBER,
   interest_rate NUMBER
);
/

-- Sample data
INSERT INTO loans VALUES (301, 1, 10.0);
INSERT INTO loans VALUES (302, 2, 11.5);
INSERT INTO loans VALUES (303, 3, 9.5);
COMMIT;
/

PROMPT === Loans BEFORE Interest Update ===
SELECT * FROM loans;
/

-- Cursor to update interest rates by 0.5%
DECLARE
   CURSOR loan_cursor IS
      SELECT loan_id, interest_rate FROM loans;

   increment CONSTANT NUMBER := 0.5;
BEGIN
   FOR rec IN loan_cursor LOOP
      UPDATE loans
      SET interest_rate = rec.interest_rate + increment
      WHERE loan_id = rec.loan_id;

      DBMS_OUTPUT.PUT_LINE('🔁 Interest updated for Loan ID: ' || rec.loan_id ||
                           ' -> New Rate: ' || (rec.interest_rate + increment));
   END LOOP;

   COMMIT;
END;
/

PROMPT === Loans AFTER Interest Update ===
SELECT * FROM loans;
/
