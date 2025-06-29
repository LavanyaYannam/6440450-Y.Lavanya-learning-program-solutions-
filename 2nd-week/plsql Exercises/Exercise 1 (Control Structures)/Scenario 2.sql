SELECT customer_id, name, balance, isvip FROM customers;

BEGIN
   FOR rec IN (SELECT customer_id FROM customers WHERE balance > 10000) LOOP
      UPDATE customers
      SET isvip = 'TRUE'
      WHERE customer_id = rec.customer_id;
   END LOOP;
   COMMIT;
   DBMS_OUTPUT.PUT_LINE('VIP status updated for eligible customers.');
END;
/

SELECT customer_id, name, balance, isvip FROM customers;
