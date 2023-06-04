INSERT INTO STUDENT (NAME, LAST_NAME, JMBAG, ECTS, BIRTH_DATE)
VALUES
    ('John', 'Doe', '1234567890', 120, '1990-05-15'),
    ('Jane', 'Smith', '0987654321', 90, '1992-12-03'),
    ('Alice', 'Johnson', '5432109876', 150, '1995-08-21');

INSERT INTO COURSE (NAME, ECTS)
VALUES
    ('Course 1', 6),
    ('Course 2', 4);

INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID)
SELECT
    s.ID AS STUDENT_ID,
    c.ID AS COURSE_ID
FROM
    STUDENT s
        JOIN COURSE c ON c.NAME IN ('Course 1', 'Course 2')
WHERE
        s.JMBAG = '1234567890';