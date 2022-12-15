DROP DATABASE IF EXISTS fresher;
CREATE DATABASE fresher;
USE fresher;
DROP TABLE IF EXISTS TraineeID;
CREATE TABLE TraineeID(
Trainee_ID INT AUTO_INCREMENT PRIMARY KEY,
Full_Name VARCHAR (255) NOT NULL,
Birth_Date DATE NOT NULL,
Gender ENUM ('Male', 'Female', 'unknown'),
ET_IQ INTEGER (20),
ET_Gmath INTEGER (20),
ET_English INTEGER (50),
Training_Class INT NOT NULL,
Evaluation_Notes VARCHAR(255) NOT NULL);

INSERT INTO TraineeID (Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes)
VALUE 	('Full_Name1',	'1994-11-9',	'Male',		'18',	'12',	'19',	'001', 'tạch'),
		('Full_Name2',	'1998-10-9',	'Female',	'9',	'14',	'25',	'002', 'tạch'),
        ('Full_Name3',	'1994-01-9',	'Female',	'13',	'18',	'31',	'001', 'đạt'),
        ('Full_Name4',	'1996-09-9',	'unknown',	'17',	'11',	'25',	'001', 'tạch'),
        ('Full_Name5',	'1992-09-25',	'Female',	'16',	'19',	'36',	'003', 'đạt'),
        ('Full_Name6',	'1993-12-19',	'Male',		'10',	'13',	'42',	'003', 'đạt'),
        ('Full_Name7',	'1999-08-29',	'Female',	'12',	'19',	'45',	'002', 'đạt'),
        ('Full_Name8',	'2000-08-20',	'Male',		'15',	'15',	'26',	'003', 'tạch'),
        ('Full_Name9',	'1998-01-1',	'Female',	'14',	'14',	'38',	'002', 'đạt'),
        ('Full_Name10',	'1996-06-9',	'unknown',	'17',	'16',	'37',	'001', 'đạt');
        
-------------------- bài tập-------------------------------------

-- Question 2:
WITH cte_thangsinh AS (SELECT Birth_Date, Full_Name AS Ten  FROM (SELECT * FROM fresher.traineeid
WHERE Evaluation_Notes = 'đạt') AS A)
SELECT DISTINCT Birth_Date FROM cte_thangsinh
GROUP BY Birth_Date;

        
-- Question 3:

SELECT * FROM fresher.traineeid
WHERE length(Full_Name) = (SELECT max(length(Full_Name)) FROM fresher.traineeid);

-- Question 4:

WITH Gomcolumn AS (SELECT Full_Name, ET_IQ AS Tổng FROM fresher.traineeid
UNION ALL
SELECT Full_Name, ET_Gmath FROM fresher.traineeid)
SELECT Full_Name, sum(Tổng) FROM Gomcolumn
GROUP BY Full_Name
HAVING sum(Tổng) >= 20;


-- Question 5:
DELETE FROM fresher.traineeid
WHERE Trainee_ID = 3;

-- Question 6:
UPDATE TraineeID
SET Training_Class = 2
WHERE Trainee_ID = 5;




        