drop table accounts;
drop table transactions;
drop sequence seq_Transactions;
drop trigger transidtrigger;

  CREATE TABLE "TESTDB"."ACCOUNTS" 
   (	"ACCOUNTNO" NUMBER(*,0), 
	"ACCOUNTNAME" VARCHAR2(50 BYTE), 
	"STARTINGBALANCE" NUMBER(18,2), 
	"BIRTHDATE" DATE
   );
   
  CREATE TABLE "TESTDB"."TRANSACTIONS" 
   (	"TRANSID" NUMBER(*,0), 
	"ACCOUNTNO" NUMBER(*,0), 
	"AMOUNT" NUMBER(18,2), 
	"TRANSTYPE" NUMBER(*,0), 
	"TRANSDATE" DATE
   );
   
   
create sequence seq_Transactions
minvalue 1
start with 1
INCREMENT by 1
cache 10;
   
Insert into TESTDB.ACCOUNTS (ACCOUNTNO,ACCOUNTNAME,STARTINGBALANCE,BIRTHDATE) values (1003,'Carmen Sandiego',1000,to_date('04-JUL-90','DD-MON-RR'));
Insert into TESTDB.ACCOUNTS (ACCOUNTNO,ACCOUNTNAME,STARTINGBALANCE,BIRTHDATE) values (3213,'Wally',1000,to_date('03-JUN-99','DD-MON-RR'));
Insert into TESTDB.ACCOUNTS (ACCOUNTNO,ACCOUNTNAME,STARTINGBALANCE,BIRTHDATE) values (4213,'Roofus',5,to_date('10-JUL-07','DD-MON-RR'));
Insert into TESTDB.ACCOUNTS (ACCOUNTNO,ACCOUNTNAME,STARTINGBALANCE,BIRTHDATE) values (4221,'Gallant',5,to_date('11-JUL-07','DD-MON-RR'));
Insert into TESTDB.ACCOUNTS (ACCOUNTNO,ACCOUNTNAME,STARTINGBALANCE,BIRTHDATE) values (8934,'Min Mei',10000,to_date('01-JAN-78','DD-MON-RR'));
Insert into TESTDB.ACCOUNTS (ACCOUNTNO,ACCOUNTNAME,STARTINGBALANCE,BIRTHDATE) values (1001,'Pikachu',1,to_date('26-MAY-97','DD-MON-RR'));
Insert into TESTDB.ACCOUNTS (ACCOUNTNO,ACCOUNTNAME,STARTINGBALANCE,BIRTHDATE) values (7779,'Littlefoot',-5,to_date('01-JAN-01','DD-MON-RR'));
Insert into TESTDB.ACCOUNTS (ACCOUNTNO,ACCOUNTNAME,STARTINGBALANCE,BIRTHDATE) values (8675,'Kora, Legend Of',200,to_date('02-JAN-50','DD-MON-RR'));
Insert into TESTDB.ACCOUNTS (ACCOUNTNO,ACCOUNTNAME,STARTINGBALANCE,BIRTHDATE) values (6660,'Walter White',10000000,to_date('13-NOV-60','DD-MON-RR'));

Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (3,1003,475.42,2,to_date('06-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (4,8675,326.01,4,to_date('09-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (5,6660,782.99,2,to_date('03-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (6,6666,30.49,1,to_date('03-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (7,4123,450.44,3,to_date('15-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (8,8675,181.1,2,to_date('10-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (9,3213,374.94,3,to_date('08-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (10,6660,803.28,4,to_date('09-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (11,6660,327.57,4,to_date('13-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (12,8934,945.44,1,to_date('07-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (13,8934,882.77,4,to_date('14-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (14,3213,986.78,3,to_date('13-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (15,7779,365.47,2,to_date('15-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (16,6660,131.83,3,to_date('14-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (17,1001,92.36,3,to_date('05-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (18,8675,998.53,4,to_date('14-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (19,4123,970.23,2,to_date('02-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (20,3213,227.03,4,to_date('05-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (21,7779,309.87,1,to_date('14-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (22,6660,31.99,4,to_date('14-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (23,6660,20.29,3,to_date('05-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (24,8675,324.04,1,to_date('13-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (25,8675,602.54,1,to_date('15-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (26,4123,818.15,2,to_date('06-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (27,3213,103.86,2,to_date('14-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (28,4221,116.8,1,to_date('10-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (29,7779,460.33,2,to_date('05-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (30,1003,270.47,2,to_date('06-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (31,3213,420.25,2,to_date('08-AUG-15','DD-MON-RR'));
Insert into TESTDB.TRANSACTIONS (TRANSID,ACCOUNTNO,AMOUNT,TRANSTYPE,TRANSDATE) values (32,8675,485.43,1,to_date('13-AUG-15','DD-MON-RR'));



CREATE OR REPLACE TRIGGER "TESTDB"."TRANSIDTRIGGER" 
BEFORE INSERT ON Transactions 
FOR EACH ROW

BEGIN
  SELECT seq_Transactions.nextval
  INTO   :new.TransID
  FROM   dual;
END;
/
ALTER TRIGGER "TESTDB"."TRANSIDTRIGGER" ENABLE;