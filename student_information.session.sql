CREATE DATABASE 902008004_902007957_902007903_902008592_902007908;

-- @BLOCK
CREATE TABLE roles (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title TEXT UNIQUE,
    module VARCHAR(200) NULL,
    description TEXT NULL
);

-- CRUD
INSERT INTO roles (title, module, description) 
VALUES ('admin', 'admin', 'Administrator');

UPDATE roles 
SET title = 'admin' 
WHERE id = 1;

DELETE FROM roles
WHERE id = 1;

-- @BLOCK
CREATE TABLE administrators (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role_id INTEGER NOT NULL,
    name TEXT UNIQUE,
    email VARCHAR(200) NOT NULL,
    address VARCHAR(200) NOT NULL,
    password TEXT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- CRUD
INSERT INTO administrators (role_id, name, email, address, password)
VALUES (1, 'admin', 'John', 'john@gmail.com', '123456');

UPDATE administrators
SET name = 'admin'
WHERE id = 1;

DELETE FROM administrators
WHERE id = 1;

-- @BLOCK
CREATE TABLE students (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role_id INTEGER NOT NULL,
    name TEXT UNIQUE,
    email VARCHAR(200) NOT NULL,
    address VARCHAR(200) NOT NULL,
    password TEXT NOT NULL,
    mobile_number INTEGER NOT NULL,
    college_id INTEGER NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- CRUD
INSERT INTO students (role_id, name, email, address, password, mobile_number, college_id)
VALUES (1, 'Musa', 'Musa', 'Musa', 'Musa', 'Musa', 'Musa');

UPDATE students
SET name = '',
email = '',
address = '',
password = '',
mobile_number = '',
college_id = ''
WHERE id = 1;

DELETE FROM students
WHERE id = 1;

-- @BLOCK
CREATE TABLE subjects (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    type TEXT UNIQUE,
    description TEXT UNIQUE,
    year INTEGER NOT NULL,
    student_id INTEGER NOT NULL,
    password VARCHAR(200) NOT NULL,
    mobile_number INTEGER,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

-- CRUD
INSERT INTO subjects (type, description, year, student_id, password, mobile_number)
VALUES ('', '', '', '', '', '');

UPDATE subjects
SET type = '',
description = '',
year = '',
student_id = '',
password = '',
mobile_number = ''
WHERE id = 1;

DELETE FROM subjects
WHERE id = 1;

-- @BLOCK
CREATE TABLE classes (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    type TEXT UNIQUE,
    description TEXT UNIQUE,
    classroom TEXT UNIQUE,
    student_id INTEGER NOT NULL,
    password VARCHAR(200) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

-- CRUD
INSERT INTO classes (type, description, classroom, student_id, password)
VALUES ('', '', '', '', '');

UPDATE classes
SET type = '',
description = '',
classroom = '',
student_id = '',
password = ''
WHERE id = 1;

DELETE FROM classes
WHERE id = 1;

-- @BLOCK
CREATE TABLE payments (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    type TEXT UNIQUE,
    description TEXT UNIQUE,
    name TEXT UNIQUE,
    student_id INTEGER NOT NULL,
    amount INTEGER NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

-- CRUD
INSERT INTO payments (type, description, name, student_id, amount)
VALUES ('', '', '', '', '');

UPDATE payments
SET type = '',
description = '',
name = '',
student_id = '',
amount = ''
WHERE id = 1;

DELETE FROM payments
WHERE id = 1;

-- @BLOCK
CREATE TABLE grades (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role_id INTEGER NOT NULL,
    name TEXT UNIQUE,
    description TEXT UNIQUE,
    registration_date VARCHAR(200) NOT NULL,
    student_id INTEGER NOT NULL,
    grade INTEGER NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (student_id) REFERENCES students(id)
);

-- CRUD
INSERT INTO grades (role_id, name, description, registration_date, student_id, grade)
VALUES (1, '', '', '', '', '');

UPDATE grades
SET name = '',
description = '',
registration_date = '',
student_id = '',
grade = ''
WHERE id = 1;

DELETE FROM grades
WHERE id = 1;

-- @BLOCK
CREATE TABLE stationery (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    type TEXT UNIQUE,
    name TEXT UNIQUE,
    student_id INTEGER NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

-- CRUD
INSERT INTO stationery (type, name, student_id)
VALUES ('', '', '');

UPDATE stationery
SET type = '',
name = '',
student_id = ''
WHERE id = 1;

DELETE FROM stationery
WHERE id = 1;

-- Views
CREATE VIEW all_classes
AS SELECT * FROM classes;

CREATE VIEW all_administrators
AS SELECT * FROM administrators;

CREATE VIEW all_students
AS SELECT * FROM students;

-- INNER JOIN
SELECT *
FROM classes
INNER JOIN students
ON classes.student_id = students.id;

SELECT *
FROM grades
INNER JOIN students
ON grades.student_id = students.id;

-- LEFT JOIN
SELECT *
FROM payments
LEFT JOIN students
ON payments.student_id = students.id;

SELECT *
FROM stationery
LEFT JOIN students
ON stationery.student_id = students.id;

-- RIGHT JOIN
SELECT *
FROM subjects
RIGHT OUTER JOIN students
ON subjects.student_id = students.id;

SELECT *
FROM classes
RIGHT OUTER JOIN students
ON classes.student_id = students.id;

-- LEFT OUTER JOIN
SELECT *
FROM subjects
LEFT OUTER JOIN students
ON subjects.student_id = students.id;

SELECT *
FROM classes
LEFT OUTER JOIN students
ON classes.student_id = students.id;


-- CROSS JOIN
SELECT *
FROM grades
CROSS JOIN students;

SELECT *
FROM payments 
CROSS JOIN students;


-- Sub-Queries
SELECT *
FROM students
WHERE id IN (SELECT student_id FROM classes);

SELECT *
FROM students
WHERE id IN (SELECT student_id FROM grades);

SELECT *
FROM students
WHERE id IN (SELECT student_id FROM payments);

-- DISTINCT
SELECT DISTINCT *
FROM students;

-- GROUP BY
SELECT *
FROM students
GROUP BY id;

-- LIMIT
SELECT *
FROM students
LIMIT 10;

-- PROCEDURE
CREATE PROCEDURE get_students_by_id(IN id INTEGER)
BEGIN
    SELECT * FROM students WHERE id = id;
END @

CREATE PROCEDURE get_students_by_name(IN name TEXT)
BEGIN
    SELECT * FROM students WHERE name = name;
END @

CREATE PROCEDURE get_students_by_email(IN email TEXT)
BEGIN
    SELECT * FROM students WHERE email = email;
END @

-- TRIGGER
CREATE TRIGGER insert_student_trigger
AFTER INSERT ON students
FOR EACH ROW
BEGIN
    INSERT INTO grades(role_id, name, description, registration_date, student_id, grade)
    VALUES(2, NEW.name, NEW.name, '', NEW.id, 0);
END @

CREATE TRIGGER insert_subject_trigger
AFTER INSERT ON subjects
FOR EACH ROW
BEGIN
    INSERT INTO grades(role_id, name, description, registration_date, student_id, grade)
    VALUES(3, '', '', '', NEW.student_id, 0);
END @

CREATE TRIGGER insert_class_trigger
AFTER INSERT ON classes
FOR EACH ROW
BEGIN
    INSERT INTO grades(role_id, name, description, registration_date, student_id, grade)
    VALUES(4, '', '', '', NEW.student_id, 0);
END @
