drop database if exists Fresher;
create database Fresher;
use Fresher;
-- table: 1
create table Department (
Department_ID int auto_increment,
Department_name varchar(255),
primary key (Department_ID)
);
-- add database in table 1
insert into Department (Department_name)
value 	('Giám đốc'),
		('Phó giảm đốc'),
        ('Thư Kí'),
        ('Kỹ thuật viên'),
        ('Maketting'),
        ('Sale'),
        ('Nhân sự'),
        ('Bảo vệ 1'),
        ('Bảo vệ 2');
-- table: 2
create table Position (
Position_ID int auto_increment,
Position_name varchar (255),
primary key (position_ID)
);
-- add database table 2
insert into Position (Position_name)
value 	('Dev'),
		('Test'),
        ('Scum master'),
        ('PM'),
        ('Maketting');
-- table 3
create table AccountID (
Account_ID int auto_increment,
Email varchar (255),
User_name varchar (255),
Department_ID int,
Position_ID int,
Createdate date,
primary key (Account_ID),
foreign key (Position_ID) REFERENCES Position (Position_ID),
foreign key (Department_ID) REFERENCES Department (Department_ID)
);
-- add database table 3
insert into AccountID (Email, User_name,Department_ID,Position_ID, Createdate )
value 	('antony_ya@yahoo.com', 'antony','1','1', '2008-10-11'),
		('annabellla@yahoo.com', 'annabella','5','2', '2008-9-11'),
		('betovaloti@yahoo.com', 'betovaloti','3','3', '2008-7-16'),
		('vatkahteo@yahoo.com', 'vatkahteo','2','4', '2008-11-15'),
		('asfkjbiuasf@yahoo.com', 'asfkjbiuasf','4','5', '2008-1-18');

-- table 4
create table GroupID (
Group_ID int auto_increment,
Group_name varchar (255),
Creator_ID int,
Create_date date,
primary key (Group_ID)
);
-- add database table 4
insert into GroupID (Group_ID, Group_name,Creator_ID,Create_date)
value 	('256', 'railway60','1', '2022-12-08'),
		('542', 'railway61','2', '2022-12-18'),
        ('552', 'railway62','7', '2022-12-11'),
        ('365', 'railway63','6', '2022-12-25'),
        ('584', 'railway64','3', '2022-12-30');
-- table 5
create table Group_account (
Group_ID int,
Account_ID int,
Joindate date,
foreign key (Group_ID) REFERENCES GroupID (Group_ID)
);
-- add database table 5
insert into Group_account (Group_ID, Account_ID,Joindate)
value 	('256', '27572', '2022-12-08'),
		('256', '573757', '2022-12-15'),
        ('256', '78537', '2022-12-16'),
		('542', '75353', '2022-12-18'),
        ('542', '753843', '2022-12-18'),
        ('542', '758553', '2022-12-18'),
        ('552', '42428', '2022-12-11'),
        ('552', '4782428', '2022-12-11'),
        ('552', '4248528', '2022-12-11'),
        ('552', '4285428', '2022-12-11'),
        ('365', '446844', '2022-12-25'),
        ('365', '446854', '2022-12-25'),
        ('365', '4568844', '2022-12-25'),
        ('365', '425844', '2022-12-25'),
        ('365', '447544', '2022-12-25'),
        ('584', '52283', '2022-12-30'),
        ('584', '489283', '2022-12-30'),
        ('584', '443683', '2022-12-30'),
        ('584', '425283', '2022-12-30');
-- table 6
create table Type_question (
Type_ID int auto_increment,
Type_name varchar (255),
primary key (Type_ID)
);
-- add database table 6
insert into Type_question (Type_name)
value 	('Essay'),
		('Multiple-Choice'),
		('unknown');
        
-- table 7
create table CategoryQuestion (
Category_ID int auto_increment,
CategoryName varchar (255),
primary key (Category_ID)
);
-- add database table 7
insert into CategoryQuestion (CategoryName)
value 	('(Java'),
		('NET'),
		('SQL'),
        ('HTML'),
        ('CSS'),
        ('JS'),
        ('PHP'),
        ('C++');
        
-- table 8
create table Question (
Question_ID int auto_increment,
Content varchar(255),
Category_ID int,
Type_ID int,
Creator_ID int,
CreateDate date,
primary key (Question_ID),
foreign key (Category_ID) REFERENCES CategoryQuestion (Category_ID),
foreign key (Type_ID) REFERENCES Type_question (Type_ID)
);
-- add database table 8
insert into Question (Content, Category_ID,Type_ID,Creator_ID,CreateDate)
value 	('SQL dùng làm gì', '1','2','325145','2022-09-09'),
		('database nghĩa là gì', '2','3','352145','2022-09-09'),
        ('html có cần khi tạo website','3','2','385145','2022-09-09'),
        ('css dùng để làm gì','4','1','325845','2022-09-09'),
        ('php có tạo được website','5','2','3535145','2022-09-09'),
        ('JS dùng để làm gì','6','1','328845','2022-09-09'),
        ('tạo website cần những gì','7','2','325845','2022-09-09');
-- table 9
create table Answer (
Answer_ID int auto_increment,
Content varchar(255),
Question_ID int,
IsCorrect enum ('đúng','sai'),
primary key (Answer_ID),
foreign key (Question_ID) REFERENCES Question (Question_ID)
);
-- add database table 9
insert into Answer (Content, Question_ID,IsCorrect)
value 	('dùng để lấy dữ liệu từ cơ sở dữ liệu', '1', 'đúng'),
		('database nghĩa là cơ sở dữ liệu', '2', 'đúng'),
        ('có', '3', 'đúng'),
        ('css dùng khi lấy dữ lệu', '4', 'sai'),
        ('php không tạo được website', '5', 'sai'),
        ('JS dùng để tạo tương tác giữa người dùng và website', '6', 'đúng'),
        ('tạo website gồm domain, host và codeweb', '7', 'đúng');
-- table 10
create table Exam (
Exam_ID int auto_increment,
Code_ID int,
Title varchar(255),
Category_ID int,
Duration varchar(255),
Creator_ID int,
CreateDate date,
primary key (Exam_ID)
);
-- add database table 10
insert into Exam (Code_ID, Title,Category_ID,Duration,Creator_ID,CreateDate)
value 	('257','tiêu đề','1','90 phút','2435','2022-11-29'),
		('157','tiêu đề','5','90 phút','2435','2022-11-29'),
        ('287','tiêu đề','4','60 phút','2435','2022-11-29'),
        ('227','tiêu đề','3','90 phút','2435','2022-11-29'),
        ('657','tiêu đề','2','60 phút','2435','2022-11-29'),
        ('258','tiêu đề','1','90 phút','2435','2022-11-29'),
        ('297','tiêu đề','5','60 phút','2435','2022-11-29'),
        ('253','tiêu đề','1','90 phút','2435','2022-11-29');
-- table 11
create table ExamQuestion (
Exam_ID int,
Question_ID int,
foreign key (Exam_ID) REFERENCES exam (Exam_ID),
foreign key (Question_ID) REFERENCES Question (Question_ID)
);
-- add database table 11
insert into ExamQuestion (Exam_ID, Question_ID)
value 	('1','2'),
		('3','5'),
        ('2','5'),
        ('3','2'),
        ('1','2'),
        ('5','6');
