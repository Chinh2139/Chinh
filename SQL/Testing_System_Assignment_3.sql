DROP DATABASE IF EXISTS Fresher;
CREATE DATABASE Fresher;
USE Fresher;
-- table: 1
CREATE TABLE Department (
Department_ID TINYINT AUTO_INCREMENT,
Department_name VARCHAR(255),
PRIMARY KEY (Department_ID)
);

-- add database in table 1
INSERT INTO Department (Department_name)
VALUE 	('Giám đốc'),
		('Phó giảm đốc'),
        ('Thư Kí'),
        ('Kỹ thuật viên'),
        ('Maketting'),
        ('Sale'),
        ('Nhân sự 1'),
        ('Nhân sự 2'),
        ('Bảo vệ 1'),
        ('Bảo vệ 2');
SELECT * FROM Department;
-- table: 2
CREATE TABLE PositionID (
Position_ID TINYINT AUTO_INCREMENT,
Position_name ENUM ('Dev','Test','Scum master', 'PM', 'Maketting', 'Seller1','Seller2','Seller3','Seller4','Seller5'),
PRIMARY KEY (Position_ID)
);
-- add database table 2
INSERT INTO PositionID (Position_name)
VALUE 	('Dev'),
		('Test'),
        ('Scum master'),
        ('PM'),
        ('Seller1'),
        ('Seller2'),
        ('Seller3'),
        ('Seller4'),
        ('Seller5'),
        ('Maketting');
-- table 3
CREATE TABLE AccountID (
Account_ID INT AUTO_INCREMENT,
Email VARCHAR (255),
User_Name VARCHAR (255),
Department_ID TINYINT,
Position_ID TINYINT,
Create_Date DATE,
PRIMARY KEY (Account_ID),
FOREIGN KEY  (Position_ID) REFERENCES PositionID (Position_ID),
FOREIGN KEY  (Department_ID) REFERENCES Department (Department_ID)
);
-- add database table 3
INSERT INTO AccountID (Email, User_Name,Department_ID,Position_ID, Create_Date )
VALUE 	('antony_ya@yahoo.com', 	'antony',		'1',		'1', 	'2008-10-11'),
		('annabellla@yahoo.com', 	'annaasfblla',	'5',		'2', 	'2008-9-11'),
		('betovaloti@yahoo.com', 	'betoverloti',	'3',		'3', 	'2008-7-16'),
		('vatkahteo@yahoo.com',	 	'fjjj',			'3',		'4', 	'2008-11-15'),
        ('asffteo@yahoo.com', 		'dfdsgd',		'2',		'5', 	'2008-11-15'),
        ('vatasjfho@yahoo.com', 	'wtwww',		'2',		'4', 	'2008-11-15'),
        ('basfsgaggteo@yahoo.com', 	'vatkeo',		'5',		'3', 	'2008-11-15'),
        ('sdffgf@yahoo.com', 		'asffsdg',		'1',		'1',	'2008-11-15'),
        ('asfsdgweg@yahoo.com', 	'wetwasftqt',	'2',		'4',	'2008-11-15'),
        ('afafas@yahoo.com', 		'sdsdasfg',		'3',		'2', 	'2008-11-15'),
		('asfkjbiuasf@yahoo.com', 	'asfbiqwruasf',	'4',		'5', 	'2008-1-18');
-- table 4
CREATE TABLE GroupID (
Group_ID SMALLINT AUTO_INCREMENT,
Group_name VARCHAR (255),
Creator_ID TINYINT,
Create_Date DATE,
PRIMARY KEY (Group_ID)
);
-- add database table 4
INSERT INTO GroupID (Group_ID, Group_name,Creator_ID,Create_Date)
VALUE 	('256', 	'railway60',	'1', 		'2022-12-08'),
		('542', 	'railway61',	'2', 		'2022-12-18'),
        ('552', 	'railway62',	'7', 		'2022-12-11'),
        ('365', 	'railway64',	'6', 		'2018-12-25'),
        ('395', 	'railway65',	'4', 		'2022-12-21'),
        ('375', 	'railway66',	'6', 		'2022-12-25'),
        ('265', 	'railway67',	'8', 		'2018-12-05'),
        ('364', 	'railway68',	'10', 		'2022-12-15'),
        ('195', 	'railway69',	'6', 		'2022-12-29'),
        ('584', 	'railway70',	'3', 		'2022-12-30');
-- table 5
CREATE TABLE Group_account (
Group_ID SMALLINT,
Account_ID INT,
Joindate DATE,
FOREIGN KEY  (Group_ID) REFERENCES GroupID (Group_ID)
);
-- add database table 5
INSERT INTO Group_account (Group_ID, Account_ID,Joindate)
VALUE 	('256', 		'27572', 			'2022-12-08'),
		('256', 		'573757', 			'2022-12-15'),
        ('256', 		'78537', 			'2022-12-16'),
		('542', 		'75353', 			'2022-12-18'),
        ('542', 		'753843', 			'2022-12-18'),
        ('542', 		'758553', 			'2022-12-18'),
        ('552', 		'42428', 			'2022-12-11'),
        ('552', 		'4782428',			'2022-12-11'),
        ('552', 		'4248528',			'2022-12-11'),
        ('552', 		'4285428', 			'2022-12-11'),
        ('365', 		'446844', 			'2022-12-25'),
        ('365', 		'446854',			'2022-12-25'),
        ('365', 		'4568844', 			'2022-12-25'),
        ('365', 		'425844', 			'2022-12-25'),
        ('365', 		'447544', 			'2022-12-25'),
        ('584', 		'52283', 			'2022-12-30'),
        ('584', 		'489283', 			'2022-12-30'),
        ('584', 		'443683', 			'2022-12-30'),
        ('584', 		'425283', 			'2022-12-30');
-- table 6
CREATE TABLE Type_Question (
Type_ID INT AUTO_INCREMENT,
Type_Name VARCHAR (255),
PRIMARY KEY (Type_ID)
);
-- add database table 6
INSERT INTO Type_Question (Type_Name)
VALUE 	('Essay'),
		('Multiple-Choice'),
        ('unknown 1'),
        ('unknown 2'),
        ('unknown 3'),
        ('unknown 4'),
        ('unknown 5'),
        ('unknown 6'),
        ('unknown 7'),
		('unknown 8');
        
-- table 7
CREATE TABLE CategoryQuestion (
Category_ID TINYINT AUTO_INCREMENT,
Category_Name VARCHAR (255),
PRIMARY KEY (Category_ID)
);
-- add database table 7
INSERT INTO CategoryQuestion (Category_Name)
VALUE 	('(Java'),
		('NET'),
		('SQL'),
        ('HTML'),
        ('CSS'),
        ('JS'),
        ('PHP'),
        ('Java'),
        ('PHP 2'),
        ('C++');
        
-- table 8
CREATE TABLE Question (
Question_ID TINYINT AUTO_INCREMENT,
Content VARCHAR(255),
Category_ID TINYINT,
Type_ID INT,
Creator_ID INT,
Create_Date DATE,
PRIMARY KEY (Question_ID),
FOREIGN KEY  (Category_ID) REFERENCES CategoryQuestion (Category_ID),
FOREIGN KEY (Type_ID) REFERENCES Type_Question (Type_ID)
);
-- add database table 8
INSERT INTO Question (Content, Category_ID,Type_ID,Creator_ID,Create_Date)
VALUE 	('SQL dùng làm gì', 				'1',	'1',	'325145',	'2022-09-09'),
		('database nghĩa là gì', 			'2',	'2',	'352145',	'2022-09-09'),
        ('html có cần khi tạo website',		'3',	'3',	'385145',	'2022-09-09'),
        ('css dùng để làm gì',				'4',	'4',	'325845',	'2022-09-09'),
        ('php có tạo được website',			'5',	'5',	'3535145',	'2022-09-09'),
        ('content 2',						'6',	'6',	'328845',	'2022-09-09'),
        ('content 4',						'7',	'7',	'328845',	'2022-09-09'),
        ('content 3',						'8',	'8',	'328845',	'2022-09-09'),
        ('JS dùng để làm gì',				'9',	'9',	'328845',	'2022-09-09'),
        ('tạo website cần những gì',		'10',	'10',	'325845',	'2022-09-09');
-- table 9
CREATE TABLE Answer (
Answer_ID INT AUTO_INCREMENT,
Content VARCHAR(255),
Question_ID TINYINT,
IsCorrect ENUM ('đúng','sai'),
PRIMARY KEY (Answer_ID),
FOREIGN KEY (Question_ID) REFERENCES Question (Question_ID)
);
-- add database table 9
INSERT INTO Answer (Content, Question_ID,IsCorrect)
VALUE	('dùng để lấy dữ liệu từ cơ sở dữ liệu', 							'1', 			'đúng'),
		('database nghĩa là cơ sở dữ liệu', 								'2', 			'đúng'),
        ('có', 																'3', 			'đúng'),
        ('css dùng khi lấy dữ lệu', 										'4', 			'sai'),
        ('php không tạo được website', 										'5', 			'sai'),
        ('php không tạo được website', 										'6', 			'đúng'),
        ('php tạo được website', 											'7', 			'sai'),
        ('php không tạo được website', 										'8', 			'sai'),
        ('JS dùng để tạo tương tác giữa người dùng và website', 			'9', 			'đúng'),
        ('tạo website gồm domain, host và codeweb', 						'10',			'đúng');
-- table 10
CREATE TABLE Exam (
Exam_ID TINYINT AUTO_INCREMENT,
Code_ID SMALLINT,
Title VARCHAR(255),
Category_ID INT,
Duration VARCHAR(255),
Creator_ID SMALLINT,
CreateDate DATE,
PRIMARY KEY (Exam_ID)
);
-- add database table 10
INSERT INTO Exam (Code_ID, Title,Category_ID,Duration,Creator_ID,CreateDate)
VALUE 	('257',		'tiêu đề',		'1',	'90',	'2435',		'2022-11-29'),
		('157',		'tiêu đề',		'5',	'90',	'2135',		'2022-11-29'),
        ('287',		'tiêu đề',		'4',	'60',	'2485',		'2017-11-29'),
        ('227',		'tiêu đề',		'3',	'90',	'2435',		'2022-11-29'),
        ('657',		'tiêu đề',		'2',	'60',	'2435',		'2015-11-29'),
        ('258',		'tiêu đề',		'1',	'90',	'2435',		'2022-11-29'),
        ('298',		'tiêu đề',		'8',	'60',	'2485',		'2022-11-29'),
        ('217',		'tiêu đề',		'9',	'60',	'2445',		'2022-11-29'),
        ('253',		'tiêu đề',		'1',	'90',	'2435',		'2022-11-29');
-- table 11
CREATE TABLE ExamQuestion (
Exam_ID TINYINT,
Question_ID TINYINT,
FOREIGN KEY (Exam_ID) REFERENCES exam (Exam_ID),
FOREIGN KEY (Question_ID) REFERENCES Question (Question_ID)
);
-- add database table 11
INSERT INTO ExamQuestion (Exam_ID, Question_ID)
VALUE 	('1',		'2'),
		('3',		'5'),
        ('2',		'5'),
        ('3',		'4'),
        ('5',		'5'),
        ('7',		'3'),
        ('9',		'8'),
        ('8',		'9'),
        ('2',		'2'),
        ('1',		'3'),
        ('5',		'6');
-- ==========================Lấy dữ liệu================================
SELECT Account_ID, User_name,Email FROM AccountID;
SELECT * FROM AccountID
WHERE Department_ID = 2;

SELECT * FROM PositionID WHERE Position_ID = 1;
SELECT * FROM AccountID WHERE Department_ID = 2 AND Position_ID = 1;

SELECT * FROM AccountID WHERE Department_ID IN (1,2,3,4,5);
-- giống với 
SELECT * FROM AccountID WHERE Department_ID BETWEEN 1 AND 5;


-- ================================="Testing_System_Assignment_3"==================
-- Question 2:
SELECT * FROM Department;

-- Question 3:
SELECT AccountID FROM Department 
WHERE Department_name = 'Sale';

-- Question 4:
SELECT * FROM fresher.accountid 
WHERE length(User_Name) =(SELECT max(length(User_Name)) FROM fresher.accountid);
-- Question 5:
SELECT * FROM fresher.accountid 
WHERE length(User_Name) =(SELECT max((User_Name)) FROM fresher.accountid) 
AND Department_ID = 3;

-- Question 6:

SELECT Group_Name FROM GroupID 
WHERE Create_date <='2019-12-20';

-- Question 7:
SELECT Question_ID FROM Question 
WHERE Question_ID >= 4;

-- Question 8:
SELECT Code_ID FROM Exam 
WHERE Duration >= 60 AND CreateDate <='2019-12-20';

-- Question 9:
SELECT * FROM  fresher.groupid 
ORDER BY Create_Date DESC
LIMIT 5;
-- Question 10:

SELECT count('nhân viên') FROM Department 
WHERE Department_ID =2;

-- Question 11:
SELECT User_Name FROM fresher.accountid 
WHERE User_Name LIKE 'D%o';

-- Question 12:
DELETE FROM fresher.exam 
WHERE CreateDate < '2019-12-20';

-- Question 13:
DELETE FROM fresher.question 
WHERE Content LIKE 'câu hỏi%';

-- Question 14:
UPDATE 	fresher.accountid
SET 	User_Name = 'Nguyễn Bá Lộc',
		Email = 'loc.nguyenba@vti.com.vn'
 WHERE Account_ID = 5;       

-- Question 15:
UPDATE fresher.accountid
SET Account_ID = 5
WHERE Group_ID = 195;







