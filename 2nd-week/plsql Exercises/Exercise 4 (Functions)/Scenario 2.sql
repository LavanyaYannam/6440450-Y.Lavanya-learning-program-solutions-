-- Create function to calculate EMI
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
   principal IN NUMBER,
   annual_rate IN NUMBER,
   duration_years IN NUMBER
) RETURN NUMBER IS
   r NUMBER;
   n NUMBER;
   emi NUMBER;
BEGIN
   r := annual_rate / (12 * 100); -- monthly rate
   n := duration_years * 12;

   IF r = 0 THEN
      emi := principal / n;
   ELSE
      emi := principal * r * POWER(1 + r, n) / (POWER(1 + r, n) - 1);
   END IF;

   RETURN ROUND(emi, 2);
END;
/

-- Call function and print EMI results
PROMPT === Monthly Installment Calculation Output ===
BEGIN
   DBMS_OUTPUT.PUT_LINE('EMI for ₹5L @8% for 5 years: ₹' || CalculateMonthlyInstallment(500000, 8, 5));
   DBMS_OUTPUT.PUT_LINE('EMI for ₹3L @10% for 3 years: ₹' || CalculateMonthlyInstallment(300000, 10, 3));
END;
/
