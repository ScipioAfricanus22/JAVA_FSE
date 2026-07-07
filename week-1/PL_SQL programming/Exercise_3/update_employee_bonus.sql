CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_DepartmentID IN NUMBER,
    p_BonusPercentage IN NUMBER
) AS
BEGIN
    -- Input validation: ensure bonus percentage is positive
    IF p_BonusPercentage <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Bonus percentage must be greater than 0.');
        RETURN;
    END IF;

    -- Update salary by adding the bonus percentage (e.g., 5% bonus converts to Salary * 1.05)
    UPDATE Employees
    SET Salary = Salary * (1 + (p_BonusPercentage / 100))
    WHERE DepartmentID = p_DepartmentID;
    
    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found or updated in Department ID: ' || p_DepartmentID);
    ELSE
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Successfully updated salaries for ' || SQL%ROWCOUNT || ' employee(s) in department ' || p_DepartmentID);
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonuses: ' || SQLERRM);
END;
/