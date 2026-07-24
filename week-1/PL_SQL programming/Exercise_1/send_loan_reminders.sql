DECLARE
    -- Cursor to fetch loans due in the next 30 days
    CURSOR c_upcoming_loans IS
        SELECT l.LoanID, c.CustomerName, l.DueDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 30
          AND l.Status = 'ACTIVE';
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- LOAN DUE REMINDERS ---');
    
    FOR r_loan IN c_upcoming_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || r_loan.CustomerName || 
                             ', your loan (ID: ' || r_loan.LoanID || 
                             ') is due on ' || TO_CHAR(r_loan.DueDate, 'YYYY-MM-DD') || 
                             '. Please ensure timely payment.');
    END LOOP;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error generating loan reminders: ' || SQLERRM);
END;
/