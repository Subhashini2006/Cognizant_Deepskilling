Drop Table customers;
Drop Table loans;
CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    age NUMBER,
    balance NUMBER,
    isvip VARCHAR2(5) DEFAULT 'FALSE'
);
CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    interest_rate NUMBER,
    due_date DATE
);
INSERT INTO customers VALUES (1, 'Arun', 65, 15000, 'FALSE');
INSERT INTO customers VALUES (2, 'Meena', 45, 9000, 'FALSE');
INSERT INTO customers VALUES (3, 'Kiran', 70, 20000, 'FALSE');
INSERT INTO customers VALUES (4, 'Divya', 30, 12000, 'FALSE');
INSERT INTO loans VALUES (101, 1, 10, SYSDATE + 10);
INSERT INTO loans VALUES (102, 2, 12, SYSDATE + 40);
INSERT INTO loans VALUES (103, 3, 9, SYSDATE + 5);
INSERT INTO loans VALUES (104, 4, 11, SYSDATE + 20);
COMMIT;

SET SERVEROUTPUT ON;

DECLARE
    CURSOR c1 IS 
        SELECT customer_id 
        FROM customers
        WHERE age > 60;
BEGIN
    FOR rec IN c1 LOOP
        UPDATE loans
        SET interest_rate = interest_rate - 1
        WHERE customer_id = rec.customer_id;
    END LOOP;

    COMMIT;
END;
/

SET SERVEROUTPUT ON;

UPDATE customers
SET isvip = 'TRUE'
WHERE balance > 10000;

COMMIT;
/

SET SERVEROUTPUT ON;
DECLARE
    CURSOR c3 IS
        SELECT c.name, l.loan_id, l.due_date
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN c3 LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || rec.name ||
            ', your loan ' || rec.loan_id ||
            ' is due on ' || rec.due_date
        );
    END LOOP;
END;
/
SELECT * FROM customers;
SELECT * FROM loans;

select c.name,c.age,l.loan_id,l.interest_rate From customers c
Join loans l
on c.customer_id=l.customer_id;