INSERT INTO WFU4.BODY_PARTS (BODY_CODE, BODY_NAME) VALUES ('ARM001', 'Right Arm');
INSERT INTO WFU4.BODY_PARTS (BODY_CODE, BODY_NAME) VALUES ('ARM000', 'Left Arm');
INSERT INTO WFU4.BODY_PARTS (BODY_CODE, BODY_NAME) VALUES ('HRT000', 'Heart');
INSERT INTO WFU4.BODY_PARTS (BODY_CODE, BODY_NAME) VALUES ('HED000', 'Head');
INSERT INTO WFU4.BODY_PARTS (BODY_CODE, BODY_NAME) VALUES ('EYE000', 'Eye');
INSERT INTO WFU4.BODY_PARTS (BODY_CODE, BODY_NAME) VALUES ('CST000', 'Chest');
INSERT INTO WFU4.BODY_PARTS (BODY_CODE, BODY_NAME) VALUES ('ABD000', 'Abdominal');

INSERT INTO WFU4.SYMPTOMS (NAME, SYM_CODE) VALUES ('Physical Exam', 'SYM004');
INSERT INTO WFU4.SYMPTOMS (NAME, SYM_CODE) VALUES ('Pain', 'SYM001');
INSERT INTO WFU4.SYMPTOMS (NAME, SYM_CODE) VALUES ('Lightheadedness', 'SYM005');
INSERT INTO WFU4.SYMPTOMS (NAME, SYM_CODE) VALUES ('Fever', 'SYM003');
INSERT INTO WFU4.SYMPTOMS (NAME, SYM_CODE) VALUES ('Diarrhea', 'SYM002');
INSERT INTO WFU4.SYMPTOMS (NAME, SYM_CODE) VALUES ('Blurred vision', 'SYM006');

INSERT INTO WFU4.SYM_HAS_BODY_PART (SYM_CODE, BODY_CODE) VALUES ('SYM002', 'ABD000');
INSERT INTO WFU4.SYM_HAS_BODY_PART (SYM_CODE, BODY_CODE) VALUES ('SYM005', 'HED000');
INSERT INTO WFU4.SYM_HAS_BODY_PART (SYM_CODE, BODY_CODE) VALUES ('SYM006', 'EYE000');

INSERT INTO WFU4.PATIENTS (PATIENT_ID, FIRST_NAME, LAST_NAME, DOB, PHONE, ADDRESS_COUNTRY, ADDRESS_STATE, ADDRESS_CITY, ADDRESS_STREET, ADDRESS_ZIP, PRIORITY_STATUS, TREATMENT_TIME) VALUES (1, 'John', 'Smith', TO_DATE('1990-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '9007004567', 'USA', 'North Carolina', 'Raleigh', 'Avent Ferry Road', 27606, null, null);
INSERT INTO WFU4.PATIENTS (PATIENT_ID, FIRST_NAME, LAST_NAME, DOB, PHONE, ADDRESS_COUNTRY, ADDRESS_STATE, ADDRESS_CITY, ADDRESS_STREET, ADDRESS_ZIP, PRIORITY_STATUS, TREATMENT_TIME) VALUES (2, 'Jane', 'Doe', TO_DATE('2000-02-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '9192453245', 'USA', 'New York', 'New York', 'Lexington Road', 10022, null, null);
INSERT INTO WFU4.PATIENTS (PATIENT_ID, FIRST_NAME, LAST_NAME, DOB, PHONE, ADDRESS_COUNTRY, ADDRESS_STATE, ADDRESS_CITY, ADDRESS_STREET, ADDRESS_ZIP, PRIORITY_STATUS, TREATMENT_TIME) VALUES (3, 'Rock', 'Star', TO_DATE('1970-08-31 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '5403127893', 'USA', 'California', 'Mountain View', 'Amphitheatre Parkway', 94043, null, null);
INSERT INTO WFU4.PATIENTS (PATIENT_ID, FIRST_NAME, LAST_NAME, DOB, PHONE, ADDRESS_COUNTRY, ADDRESS_STATE, ADDRESS_CITY, ADDRESS_STREET, ADDRESS_ZIP, PRIORITY_STATUS, TREATMENT_TIME) VALUES (4, 'Sheldon', 'Cooper', TO_DATE('1984-05-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '6184628437', 'USA', 'California', 'Santa Cruz', '2500 Sacramento, Apt903', 90021, null, null);

INSERT INTO WFU4.MEDICAL_FACILITIES (FACILITY_ID, NAME, CLASSIFICATION, ADDRESS, CAPACITY) VALUES (1000, 'Wolf Hospital', '03', '2650 Wolf Village Way Box 7220 Raleigh, NC 27695', '300');
INSERT INTO WFU4.MEDICAL_FACILITIES (FACILITY_ID, NAME, CLASSIFICATION, ADDRESS, CAPACITY) VALUES (1001, 'California Health Care', '02', '2500 Sacramento, Santa Cruz, CA - 90021', '150');
INSERT INTO WFU4.MEDICAL_FACILITIES (FACILITY_ID, NAME, CLASSIFICATION, ADDRESS, CAPACITY) VALUES (1002, 'Suny Medical Center', '01', '489 First Avenue, New York, New York - 10001', '10');

INSERT INTO WFU4.SERVICES (SERVICE_CODE, NAME) VALUES ('SER01', 'Emergency');
INSERT INTO WFU4.SERVICES (SERVICE_CODE, NAME) VALUES ('SGP01', 'General practice');
INSERT INTO WFU4.SERVICES (SERVICE_CODE, NAME) VALUES ('VIS01', 'Vision');

INSERT INTO WFU4.SERVICE_DEPTS (DEPT_CODE, NAME, IS_MEDICAL) VALUES ('ER000', 'Emergency room', '1');
INSERT INTO WFU4.SERVICE_DEPTS (DEPT_CODE, NAME, IS_MEDICAL) VALUES ('GP000', 'General practice department', '1');
INSERT INTO WFU4.SERVICE_DEPTS (DEPT_CODE, NAME, IS_MEDICAL) VALUES ('GP001', 'General practice department', '1');
INSERT INTO WFU4.SERVICE_DEPTS (DEPT_CODE, NAME, IS_MEDICAL) VALUES ('OP000', 'Optometry', '1');
INSERT INTO WFU4.SERVICE_DEPTS (DEPT_CODE, NAME, IS_MEDICAL) VALUES ('SE000', 'Security', '1');
INSERT INTO WFU4.SERVICE_DEPTS (DEPT_CODE, NAME, IS_MEDICAL) VALUES ('ER001', 'Examine', '1');
INSERT INTO WFU4.SERVICE_DEPTS (DEPT_CODE, NAME, IS_MEDICAL) VALUES ('SEC000', 'Charge room', '0');

INSERT INTO WFU4.STAFFS (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, IS_MEDICAL, DOB, HIRE_DATE, PRIMARY_DEPT_CODE) VALUES (89001, 'Medical', 'Robot', '1', TO_DATE('1989-04-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-06-21 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'OP000');
INSERT INTO WFU4.STAFFS (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, IS_MEDICAL, DOB, HIRE_DATE, PRIMARY_DEPT_CODE) VALUES (93001, 'Musical', 'Robot', '1', TO_DATE('1993-01-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-08-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'ER000');
INSERT INTO WFU4.STAFFS (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, IS_MEDICAL, DOB, HIRE_DATE, PRIMARY_DEPT_CODE) VALUES (67001, 'Muscular', 'Rob', '1', TO_DATE('1967-12-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('1983-10-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'GP000');
INSERT INTO WFU4.STAFFS (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, IS_MEDICAL, DOB, HIRE_DATE, PRIMARY_DEPT_CODE) VALUES (88001, 'Mechanical', 'Roboto', '1', TO_DATE('1988-05-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-06-21 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'GP000');
INSERT INTO WFU4.STAFFS (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, IS_MEDICAL, DOB, HIRE_DATE, PRIMARY_DEPT_CODE) VALUES (91001, 'Millennium', 'Roberten', '1', TO_DATE('1991-06-28 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'GP001');
INSERT INTO WFU4.STAFFS (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, IS_MEDICAL, DOB, HIRE_DATE, PRIMARY_DEPT_CODE) VALUES (66001, 'Missionary', 'Robinson', '1', TO_DATE('1966-07-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('1993-10-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'ER000');
INSERT INTO WFU4.STAFFS (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, IS_MEDICAL, DOB, HIRE_DATE, PRIMARY_DEPT_CODE) VALUES (67002, 'Massaging', 'Robin', '1', TO_DATE('1967-12-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('1990-12-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'ER001');
INSERT INTO WFU4.STAFFS (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, IS_MEDICAL, DOB, HIRE_DATE, PRIMARY_DEPT_CODE) VALUES (89002, 'Miscellaneous', 'Robotor', '0', TO_DATE('1989-04-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2014-08-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'SEC000');
INSERT INTO WFU4.STAFFS (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, IS_MEDICAL, DOB, HIRE_DATE, PRIMARY_DEPT_CODE) VALUES (93002, 'Musician', 'Root', '0', TO_DATE('1993-01-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-10-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'SEC000');

INSERT INTO WFU4.STAFF_SECO_WORKS_DEPT (EMPLOYEE_ID, DEPT_CODE) VALUES (88001, 'OP000');

