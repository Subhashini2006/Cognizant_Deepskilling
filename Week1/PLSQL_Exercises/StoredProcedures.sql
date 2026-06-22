SET SERVEROUTPUT ON;

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE SavingsAccounts';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/


CREATE TABLE SavingsAccounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Balance NUMBER
);

CREATE TABLE Employees (
    EmpID NUMBER PRIMARY KEY,
    EmpName VARCHAR2(50),
    Department VARCHAR2(30),
    Salary NUMBER
);

INSERT INTO SavingsAccounts VALUES (1, 'Ravi', 10000);
INSERT INTO SavingsAccounts VALUES (2, 'Arun', 20000);
INSERT INTO SavingsAccounts VALUES (3, 'Priya', 15000);

INSERT INTO Employees VALUES (1, 'Kumar', 'IT', 30000);
INSERT INTO Employees VALUES (2, 'Meena', 'HR', 25000);
INSERT INTO Employees VALUES (3, 'John', 'IT', 40000);

COMMIT;


CREATE OR REPLACE PROCEDURE ApplyMonthlyInterest AS
BEGIN
    UPDATE SavingsAccounts
    SET Balance = Balance + (Balance * 0.01);

    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% successfully credited to savings accounts.');
END;
/


CREATE OR REPLACE PROCEDURE GiveDepartmentBonus (
    p_dept IN VARCHAR2,
    p_percent IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE Department = p_dept;

    DBMS_OUTPUT.PUT_LINE('Bonus updated for department: ' || p_dept);
END;
/

CREATE OR REPLACE PROCEDURE FundTransfer (
    p_source_acc IN NUMBER,
    p_target_acc IN NUMBER,
    p_amount     IN NUMBER
) AS
    v_current_balance SavingsAccounts.Balance%TYPE;
BEGIN
    
    SELECT Balance
    INTO v_current_balance
    FROM SavingsAccounts
    WHERE AccountID = p_source_acc
    FOR UPDATE NOWAIT;

    IF v_current_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Transaction declined: insufficient funds.');
    ELSE
        UPDATE SavingsAccounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_source_acc;

        UPDATE SavingsAccounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_target_acc;

        DBMS_OUTPUT.PUT_LINE('Fund transfer completed successfully.');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Invalid source account provided.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error occurred during transaction.');
END;
/



BEGIN
    ApplyMonthlyInterest;
END;
/

BEGIN
    GiveDepartmentBonus('IT', 10);
END;
/

BEGIN
    FundTransfer(1, 2, 5000);
END;
/

SELECT * FROM SavingsAccounts;
SELECT * FROM Employees;