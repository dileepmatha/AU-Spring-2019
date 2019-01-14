a)
    CREATE TABLE STUDENT( 
        STUD_ID NUMERIC(10),
        STUD_NAME VARCHAR(100),
        STUD_DEPT VARCHAR(100),                                                                         
        PRIMARY KEY (STUD_ID));

    CREATE TABLE COURSES(
        C_NAME VARCHAR(100),
        C_ID NUMERIC(10),
        C_FEE NUMERIC(10,0),
        PRIMARY KEY(C_ID));

    CREATE TABLE PROF(
        PROF_ID NUMERIC(10),
        PROF_NAME VARCHAR(100),
        C_ID NUMERIC(10),
        FOREIGN KEY (C_ID) REFERENCES COURSES(C_ID),
        PRIMARY KEY(PROF_ID));

    CREATE TABLE STUD_COUR(
        STUD_ID NUMERIC(10),
        C_ID NUMERIC(10),
        FOREIGN KEY (STUD_ID) REFERENCES STUDENT(STUD_ID),
        FOREIGN KEY (C_ID) REFERENCES COURSES(C_ID));

    +---------+-----------+-----------+
    | STUD_ID | STUD_NAME | STUD_DEPT |                                                                
    +---------+-----------+-----------+
    |       1 | DILEEP    | CSE       |
    |       2 | SAMPREETH | ECE       |
    |       3 | REVANTH   | ECE       |
    |       4 | VIHAR     | EEE       |
    |       5 | SAVITH    | EEE       |
    +---------+-----------+-----------+    

    +--------------------+------+-------+                                                              
    | C_NAME             | C_ID | C_FEE |                                                              
    +--------------------+------+-------+                                                              
    | C PROGRAMMING      |  100 |  3000 |                                                              
    | C++ PROGRAMMING    |  200 |  4000 |                                                              
    | PYTHON PROGRAMMING |  300 |  5000 |                                                              
    | JAVA PROGRAMMING   |  400 |  6000 |                                                              
    | R PROGRAMMING      |  500 |  7000 |                                                              
    +--------------------+------+-------+   

    +---------+-----------+------+
    | PROF_ID | PROF_NAME | C_ID |
    +---------+-----------+------+
    |      11 | AADITYA   |  100 |
    |      12 | GOUTHAMI  |  200 |
    |      13 | CHANDRA   |  300 |
    |      14 | ARAVIND   |  400 |
    +---------+-----------+------+

    +---------+------+
    | STUD_ID | C_ID |
    +---------+------+
    |       1 |  100 |
    |       1 |  200 |
    |       1 |  300 |
    |       2 |  300 |
    |       3 |  200 |
    |       3 |  100 |
    |       4 |  200 |
    |       5 |  500 |
    |       5 |  400 |
    +---------+------+
b)
    1)
        SELECT S.STUD_ID, S.STUD_NAME, C.C_ID, C.C_NAME FROM STUDENT S, STUD_COUR T, COURSES C 
        WHERE S.STUD_ID = T.STUD_ID AND T.C_ID = C.C_ID AND S.STUD_ID = 1;
        +---------+-----------+------+--------------------+
        | STUD_ID | STUD_NAME | C_ID | C_NAME             |
        +---------+-----------+------+--------------------+
        |       1 | DILEEP    |  100 | C PROGRAMMING      |
        |       1 | DILEEP    |  200 | C++ PROGRAMMING    |
        |       1 | DILEEP    |  300 | PYTHON PROGRAMMING |
        +---------+-----------+------+--------------------+
    2)
        SELECT C_NAME, PROF_NAME FROM PROF P INNER JOIN COURSES C WHERE P.C_ID = C.C_ID AND
        C.C_ID = (SELECT C_ID FROM STUD_COUR GROUP BY C_ID ORDER BY COUNT(C_ID) DESC LIMIT 1);
        +-----------------+-----------+
        | C_NAME          | PROF_NAME |
        +-----------------+-----------+
        | C++ PROGRAMMING | GOUTHAMI  |
        +-----------------+-----------+

c)
    CREATE DEFINER=`root`@`localhost` PROCEDURE `proc1`(IN id numeric(10))
    BEGIN
        DECLARE prof_id numeric(10);
        DECLARE prof_name varchar(100);
        DECLARE ctlr INT DEFAULT 0;
        DECLARE prof_cur CURSOR FOR (select PROF_ID,PROF_NAME from PROF where C_ID 
        in (select C_ID from STUD_COUR where STUD_ID=id));
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET ctlr = 1;
        open prof_cur;
        ctlr:LOOP
        fetch prof_cur into prof_id,prof_name;
        IF ctlr=1 THEN
                LEAVE ctlr;
            END IF; 
        insert into temp values(prof_id,prof_name);
        END LOOP;  
    END//

    mysql>call proc1(1);
    for STUD_ID=1;

    +---------+-----------+
    | PROF_ID | PROF_NAME |
    +---------+-----------+
    |      11 | AADITYA   | 
    |      12 | GOUTHAMI  |  
    |      13 | CHANDRA   | 
    +---------+-----------+




