DECLARE
    -- Cursor to find customers older than 60 and their active loans
    CURSOR c_senior_loans IS
        SELECT l.LoanID, l.InterestRate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE MONTHS_BETWEEN(SYSDATE, c.DateOfBirth) / 12 > 60
          AND l.Status = 'ACTIVE';
BEGIN
    FOR r_loan IN c_senior_loans LOOP
        -- Apply a 1% discount (subtracting 1 from the rate, e.g., 5.5% becomes 4.5%)
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = r_loan.LoanID;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest rate discounts applied successfully to senior citizens.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurring during discount application: ' || SQLERRM);
END;
/