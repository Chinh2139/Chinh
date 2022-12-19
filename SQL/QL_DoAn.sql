-- Tạo DB
DROP DATABASE IF EXISTS QL_DoAn;
CREATE DATABASE QL_DoAn;
USE QL_DoAn;

-- Tạo bảng Giảng viên
DROP TABLE IF EXISTS `GiangVien`;
CREATE TABLE  `GiangVien`(
	Id_GV TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Ten_GV VARCHAR(50) NOT NULL,
    Tuoi TINYINT NOT NULL,
    HocVi CHAR(20) NOT NULL
);

-- Tạo bảng Sinh viên
DROP TABLE IF EXISTS `SinhVien`;
CREATE TABLE `SinhVien` (
	Id_SV SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Tên_SV VARCHAR(50) NOT NULL,
	NamSinh DATETIME NOT NULL,
    QueQuan VARCHAR(50) NOT NULL
);

-- Tạo bảng Đề tài
DROP TABLE IF EXISTS `DeTai`;
CREATE TABLE `DeTai` (
	Id_DeTai SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Ten_DeTai VARCHAR(50) NOT NULL
);

-- Tạo bảng hướng dẫn
DROP TABLE IF EXISTS `HuongDan`;
CREATE TABLE `HuongDan` (
	Id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Id_SV SMALLINT UNSIGNED NOT NULL,
    Id_DeTai SMALLINT UNSIGNED NOT NULL,
    Id_GV TINYINT UNSIGNED NOT NULL,
	Diem TINYINT UNSIGNED NOT NULL,

    CONSTRAINT FK_Huongdan_Sinhvien FOREIGN KEY (Id_SV) REFERENCES `SinhVien`(Id_SV),
	CONSTRAINT FK_Huongdan_Detai FOREIGN KEY (Id_DeTai) REFERENCES `DeTai`(Id_DeTai),
	CONSTRAINT FK_Huongdan_Giangvien FOREIGN KEY (Id_GV) REFERENCES `GiangVien`(Id_GV)
);

-- Insert dữ liệu
-- Insert dữ liệu bảng Giảng viên
SELECT * FROM ql_doan.giangvien;
INSERT INTO `giangvien` (`Ten_GV`, 			`Tuoi`, 		`HocVi`) 
VALUES 					('GiangVien 1', 	'40',			 'GS'),
						('GiangVien 2', 	'45',			 'Ts'),
                        ('GiangVien 3', 	'46',			 'PGS'),
						('GiangVien 4', 	'60',			 'Ts'),
                        ('GiangVien 5', 	'35',			 'Ths'),
                        ('GiangVien 6', 	'48',			 'Ths'),
                        ('GiangVien 7', 	'56',			 'GS'),
                        ('GiangVien 8', 	'61',			 'Ths'),
                        ('GiangVien 9', 	'59',			 'PGS'),
                        ('GiangVien 10', 	'38',			 'PGS');
                        
-- Insert dữ liệu bảng Sinh viên
SELECT * FROM ql_doan.sinhvien;
INSERT INTO `ql_doan`.`sinhvien` (`Tên_SV`, 			`NamSinh`, 				`QueQuan`)
 VALUES 						 ('SinhVien 1',		 '1998-11-11 00:00:00',		 'ND'),
								 ('SinhVien 2',		 '1999-02-22 00:00:00',		 'HN'),
                                 ('SinhVien 3',		 '1997-01-01 00:00:00',		 'HN'),
                                 ('SinhVien 4',		 '1999-01-12 00:00:00',		 'TH'),
                                 ('SinhVien 5',		 '1998-03-30 00:00:00',		 'ND'),
                                 ('SinhVien 6',		 '1999-03-14 00:00:00',		 'HN'),
                                 ('SinhVien 7',		 '1997-03-01 00:00:00',		 'TH'),
                                 ('SinhVien 8',		 '1996-11-22 00:00:00',		 'QN'),
                                 ('SinhVien 9',		 '1997-12-07 00:00:00',		 'BG'),
                                 ('SinhVien 10',	 '1997-07-01 00:00:00',		 'LS');                             

-- Insert dữ liệu bảng Đề tài
SELECT * FROM ql_doan.detai;
INSERT INTO `ql_doan`.`detai` (`Ten_DeTai`	) 
VALUES						  ('DeTai 1'	),
							  ('DeTai 2'	),
                              ('DeTai 3'	),
                              ('DeTai 4'	),
                              ('DeTai 5'	),
                              ('DeTai 6'	),
                              ('DeTai 7'	),
                              ('DeTai 8'	),
                              ('DeTai 9'	),
							  ('DeTai 10'	);

-- Insert dữ liệu bảng Hướng dẫn
SELECT * FROM ql_doan.huongdan;
INSERT INTO `ql_doan`.`huongdan` (`Id_SV`,		 `Id_DeTai`, 	`Id_GV`, 	`Diem`	)
 VALUES							 (	'1', 			'1', 			'1', 	 '8'	),
								 (	'2', 			'3', 			'2', 	 '9'	),
                                 (	'3', 			'4', 			'1', 	 '8'	),
                                 (	'4', 			'6', 			'3', 	 '6'	),
                                 (	'5', 			'8', 			'3', 	 '7'	),
                                 (	'6', 			'2', 			'4', 	 '9'	),
                                 (	'7', 			'7', 			'6', 	 '6'	),
                                 (	'8', 			'6', 			'5', 	 '8'	);
                                 
                                 
-- Questions 2:
-- a
SELECT * FROM ql_doan.huongdan H
LEFT JOIN ql_doan.detai DT ON H.Id_DeTai = DT.Id_DeTai
WHERE H.Id_DeTai IS NULL;
-- b
SELECT * FROM ql_doan.detai DT
INNER JOIN ql_doan.sinhvien SV ON DT.Id_DeTai = SV.Id_SV
WHERE Ten_DeTai = 'DeTai 6';
                                 
 -- Questions 3:
CREATE VIEW SinhVienInfo AS
SELECT Id_SV,Tên_SV,Ten_DeTai FROM ql_doan.detai DT
INNER JOIN ql_doan.sinhvien SV ON DT.Id_DeTai = SV.Id_SV;
SELECT * FROM SinhVienInfo;

-- Questions 4:

CREATE TRIGGER



