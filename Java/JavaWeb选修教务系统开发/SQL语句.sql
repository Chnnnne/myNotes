DROP TABLE Teachers;
DROP TABLE Departments;
DROP TABLE Courses;
DROP TABLE Students;
DROP TABLE Teaches;
DROP TABLE SC;
DROP TABLE Users;
DROP TABLE SB;
DROP TABLE Books;
DROP TABLE choosecourses;





CREATE TABLE Users(
	U_username VARCHAR(32) PRIMARY KEY,
	U_password VARCHAR(32) NOT NULL 
);

CREATE TABLE Students(
	Username VARCHAR(32) NOT NULL UNIQUE, 
	Sno CHAR(9) PRIMARY KEY,		
	Sname VARCHAR(20),
	Sex VARCHAR(2) CHECK (Sex='男'OR Sex='女'),
	Birthday DATE,
	Enrollyear CHAR(4),				
	Speciality VARCHAR(20)
);

CREATE TABLE Courses(
	Cno CHAR(5) PRIMARY KEY,		
	Cname VARCHAR(20) NOT NULL,
	Credit INT
);

CREATE TABLE SC(
	Sno CHAR(9),
	Cno CHAR(5),
	Grade INT CHECK(Grade>=0 AND Grade<=100),
	PRIMARY KEY(Sno,Cno),
	FOREIGN KEY(Sno) REFERENCES Students(Sno),
	FOREIGN KEY(Cno) REFERENCES Courses(Cno)
	
);

CREATE TABLE Departments(
	Dno CHAR(4) PRIMARY KEY,		
	Dname VARCHAR(20)
);

CREATE TABLE Teachers(
	Username VARCHAR(32) NOT NULL UNIQUE, 
	Tno CHAR(7) PRIMARY KEY,
	Tname VARCHAR(20) NOT NULL,
	Sex CHAR(2) CHECK(Sex='男'OR Sex='女'),
	Birthday DATE,
	Title VARCHAR(20),
	Dno CHAR(4),
	FOREIGN KEY(Dno) REFERENCES Departments(Dno)
);



CREATE TABLE Teaches(
Tno CHAR(7),
Cno CHAR(5),
TCscore INT,
PRIMARY KEY(Tno,Cno),
FOREIGN KEY(Tno) REFERENCES Teachers (Tno),
FOREIGN KEY(Cno) REFERENCES Courses (Cno)
);

CREATE TABLE ChooseCourses(
	Sno CHAR(9),		
	Courses VARCHAR(40),
	PRIMARY KEY(Sno,Courses)

);

CREATE TABLE Books(
Bno CHAR(9) PRIMARY KEY,
Bname VARCHAR(32),
Prize FLOAT,
Author VARCHAR(32),
Press VARCHAR(32)
);


CREATE TABLE SB(
 Sno CHAR(9),
 Bno CHAR(9),
 Num INT,
 PRIMARY KEY(Sno,Bno),
 FOREIGN KEY (Sno) REFERENCES Students(Sno),
 FOREIGN KEY (Bno) REFERENCES Books(Bno)
);



INSERT INTO Users VALUES
			('wangchen',123),
			('xiaoming',123),
			('xiaohua',123),
			('xiaohong',123),
			('xiaoxue',123),
			('lilaoshi',123),
			('zhouyuanzhang',123);

DELETE FROM Students;
INSERT INTO Students VALUES
			('wangchen','201801001','王晨','男','2000-4-29','2018','软件工程'),
			('xiaoming','201801002','小明','男','2002-4-01','2018','计算机科学与技术'),
			('xiaohua','201801003','小华','男','2001-11-29','2018','软件工程'),
			('xiaohong','201801004','小红','女','2000-3-18','2018','土木工程'),
			('xiaozhao','201801005','小赵','女','2000-4-29','2018','马克思主义'),
			('xiaohuang','201801006','小黄','男','2000-4-29','2018','软件工程'),
			('xiaosun','201801007','小孙','女','2000-4-29','2018','软件工程'),
			('xiaozhu','201801008','小周','男','2000-3-29','2018','马克思主义'),
			('xiaohei','201801009','小嘿','男','2000-3-29','2018','马克思主义'),
			('xiaoli','201801010','小李','男','2000-2-29','2018','软件工程'),
			('xiaori','201801011','小日','男','2000-1-29','2018','软件工程'),
			('xiaobai','201801012','小白','男','2000-1-29','2018','软件工程')
			;

DELETE FROM Courses;
INSERT INTO Courses VALUES('00001','数据库',3),
			('00002','计算机原理',4),
			('00003','JAVA',3),
			('00004','算法设计',3),
			('00005','选修-JavaWeb',2),
			('00006','选修-数据库设计',2),
			('00007','选修-软件环境与工具',2);
DELETE FROM SC;			
INSERT INTO SC VALUES
		('201801001','00001',100),
		('201801001','00002',80),
		('201801001','00003',65),
		('201801001','00004',90),
		('201801002','00001',85),
		('201801002','00002',32),
		('201801003','00001',64),
		('201801004','00001',53),
		('201801007','00001',49),
		('201801008','00001',95),
		('201801010','00001',75),
		('201801006','00002',93),
		('201801007','00002',85),
		('201801008','00002',79)
		;
		
INSERT INTO Departments VALUES
			('0001','信息工程学院'),
			('0002','商学院');
			
INSERT INTO Teachers VALUES
			('lilaoshi','0000001','李老师','男','1975-02-15','副教授','0001'),
			('zhouyuanzhang','0000002','周老师','男','1975-02-15','院长','0001');
DELETE FROM Teaches;
INSERT INTO Teaches VALUES
			('0000001','00001',90),
			('0000001','00002',85),
			('0000001','00003',99),
			('0000002','00002',99);
DELETE FROM books;
INSERT INTO books VALUES
	('000000001','人间失格',25.3,'太宰治', '东京小孩子出版社'),
	('000000002','高等数学',39.9,'路遥', '东京小孩子出版社'),
	('000000003','概率论',39.9,'路遥', '东京小孩子出版社'),
	('000000004','线性代数',39.9,'路遥', '东京小孩子出版社'),
	('000000005','大学英语',28.0,'陈明', '东京小孩子出版社'),
	('000000006','操作系统',68.6,'美斯塔夫里阿诺斯', '东京小孩子出版社'),
	('000000007','编译原理',29.9,'陈火旺', '东京小孩子出版社'),
	('000000008','汇编语言',30.5,'禹岩', '东京小孩子出版社'); 
	
DELETE FROM sb;
INSERT INTO sb VALUES
	('201801001','000000001',10),
	('201801001','000000002',20);


CREATE NONCLUSTERED INDEX testindex  ON Students (Birthday DESC) 
DROP INDEX testindex ON Students;