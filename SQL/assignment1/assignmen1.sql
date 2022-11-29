create database if not exists fresher_Training_management;
use fresher_Training_management;
create table if not exists Trainee (
TraineeID int not null auto_increment,
Full_name varchar (250),
Birth_name date,
gender varchar (10),
ET_IQ int,
ET_Gmath int,
ET_english int,
Training_class int,
Evalution_note varchar (250),
primary key (TraineeID)
);
alter table Trainee
modify column VTI_account int not null,
add unique (VTI_account);
