CREATE OR REPLACE PROCEDURE TransferFunds (
    p_SourceAccountID IN NUMBER,
    p_DestAccountID   IN NUMBER,
    p_Amount          IN NUMBER
) AS
    v_SourceBalance NUMBER;
BEGIN
    -- 1. Validate that the transfer amount is positive
    IF p_Amount <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Transaction Rejected: Transfer amount must be greater than zero.');
        RETURN;
    END IF;

    -- 2. Fetch current balance of the source account
    SELECT Balance INTO v_SourceBalance
    FROM Accounts
    WHERE AccountID = p_SourceAccountID;

    -- 3. Check for sufficient funds
    IF v_SourceBalance < p_Amount THEN
        DBMS_OUTPUT.PUT_LINE('Transaction Rejected: Insufficient funds in Source Account ' || p_SourceAccountID);
        RETURN;
    END IF;

    -- 4. Deduct money from the source account
    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_SourceAccountID;

    -- 5. Add money to the destination account
    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_DestAccountID;

    -- 6. Commit the entire transaction atomically
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transaction Success: Transferred $' || p_Amount || ' from Account ' || p_SourceAccountID || ' to Account ' || p_DestAccountID);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: One or both Account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Failed due to an unexpected error: ' || SQLERRM);
END;
/