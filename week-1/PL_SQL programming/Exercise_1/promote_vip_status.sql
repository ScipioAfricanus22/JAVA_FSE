DECLARE
    -- Cursor to fetch all customers with a balance over $10,000 who aren't already VIP
    CURSOR c_eligible_vip IS
        SELECT CustomerID 
        FROM Customers 
        WHERE Balance > 10000 
          AND (IsVIP IS NULL OR IsVIP <> 'TRUE');
BEGIN
    FOR r_cust IN c_eligible_vip LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = r_cust.CustomerID;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status updates completed successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating VIP status: ' || SQLERRM);
END;
/