CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    -- Cursor to fetch all active savings accounts
    CURSOR c_savings_accounts IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'SAVINGS' 
          AND Status = 'ACTIVE';
          
    v_interest_amount NUMBER;
BEGIN
    FOR r_acc IN c_savings_accounts LOOP
        -- Calculate 1% interest of the current balance
        v_interest_amount := r_acc.Balance * 0.01;
        
        -- Update the account balance
        UPDATE Accounts
        SET Balance = Balance + v_interest_amount
        WHERE AccountID = r_acc.AccountID;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully for all active savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END;
/