drop database lekhabathikfactory;
create database lekhabathikfactory;
use lekhabathikfactory;

CREATE TABLE Employee(
	Emp_id VARCHAR(10) NOT NULL,
	Name VARCHAR(200),
	Address VARCHAR(200) ,
	Telephone VARCHAR(10),
	NIC  VARCHAR(15),
	duty VARCHAR(30) check (duty in ('Store','Cutting','Sewing 1 in','Sewing 1 out','Waxing in','Waxing out','Dyeing','DryWashing','Sewing 2','Finishing','Sales')),
	CONSTRAINT PRIMARY KEY (Emp_id)
);

CREATE TABLE Garment(
	Garment_id VARCHAR(10) NOT NULL,
	garment_name VARCHAR(200),
	in_stock INT(10),
	sewing_stipend NUMERIC(10,2) ,
	cutting_stipend NUMERIC(10,2) ,
	CONSTRAINT PRIMARY KEY (Garment_id)
);

CREATE TABLE Customer(
	Cust_id VARCHAR(10) NOT NULL,
	C_Name VARCHAR(200),
	C_Address VARCHAR(200) ,
	C_Telephone VARCHAR(10),
	C_NIC  VARCHAR(15),
	CONSTRAINT PRIMARY KEY (Cust_id)
);

CREATE TABLE Material(
	Mat_id VARCHAR(10) NOT NULL,
	Mat_name VARCHAR(200),
	Mat_type VARCHAR(30) check (Mat_type in('Dye','Wax','Thread','Cloth')),
	in_stock NUMERIC(10,2),
	CONSTRAINT PRIMARY KEY (Mat_id)
);

CREATE TABLE EmpWage(
	Emp_id VARCHAR(10) NOT NULL,
	Month INT(2) ,
	Year INT(4),
	no_of_days INT(2),
	ot_hours INT(4),
	salary NUMERIC(10,2),
	CONSTRAINT PRIMARY KEY (Emp_id,Month,Year),
	CONSTRAINT FOREIGN KEY(Emp_id) REFERENCES Employee(Emp_id)
	ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE EmpSalary(
	Emp_id VARCHAR(10) NOT NULL,
	Month INT(2) ,
	Year INT(4),
	salary NUMERIC(10,2),
	CONSTRAINT PRIMARY KEY (Emp_id,Month,Year),
	CONSTRAINT FOREIGN KEY(Emp_id) REFERENCES Employee(Emp_id)
	ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE Piece_coverage(
	Emp_id VARCHAR(10) NOT NULL,
	Garment_id VARCHAR(10) NOT NULL,
	DateOfWork DATE NOT NULL,
	no_of_pieces INT(4),
	CONSTRAINT PRIMARY KEY (Emp_id,Garment_id,DateOfWork),
	CONSTRAINT FOREIGN KEY(Emp_id) REFERENCES Employee(Emp_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY(Garment_id) REFERENCES Garment(Garment_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE CustomerOrder(
        order_id VARCHAR(10) NOT NULL,
        Cust_id VARCHAR(10) NOT NULL,
	Garment_id VARCHAR(10) NOT NULL,
	DateOfOrder DATE NOT NULL,
	amount INT(10),
	unit_price NUMERIC(10,2),
	CONSTRAINT PRIMARY KEY (order_id,cust_id,garment_id),
	CONSTRAINT FOREIGN KEY(Cust_id) REFERENCES Customer(Cust_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY(Garment_id) REFERENCES Garment(Garment_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Daily_coverage(
	Garment_id VARCHAR(10) NOT NULL,
	DateOfCover DATE NOT NULL,
	no_of_cut INT(4),
	no_of_sewn INT(4),
	no_of_dyed INT(4),
	no_of_washdry INT(4),
	no_of_sewfinish INT(4),
	no_of_finish INT(4),
	CONSTRAINT PRIMARY KEY (Garment_id,DateOfCover),
	CONSTRAINT FOREIGN KEY(Garment_id) REFERENCES Garment(Garment_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE DailyClothUsage(
	Mat_id VARCHAR(10) NOT NULL,
	Garment_id VARCHAR(10) NOT NULL,
	DateOfUse DATE NOT NULL,
	amount NUMERIC(10,2),
	no_of_pieces INT(10),
	CONSTRAINT PRIMARY KEY (Mat_id,Garment_id,DateOfUse),
	CONSTRAINT FOREIGN KEY(Mat_id) REFERENCES Material(Mat_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY(Garment_id) REFERENCES Garment(Garment_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE DailyMaterialUsage(
	Mat_id VARCHAR(10) NOT NULL,
	DateOfUse DATE NOT NULL,
	amount NUMERIC(10,2),
	CONSTRAINT PRIMARY KEY (Mat_id,DateOfUse),
	CONSTRAINT FOREIGN KEY(Mat_id) REFERENCES Material(Mat_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Stock(
        Stock_id VARCHAR(10) NOT NULL,
	Mat_id VARCHAR(10) NOT NULL,
	DateOfBuy DATE NOT NULL,
	amountOfBuy NUMERIC(10,2),
	unit_price NUMERIC(10,2),
	CONSTRAINT PRIMARY KEY (Stock_id),
	CONSTRAINT FOREIGN KEY(Mat_id) REFERENCES Material(Mat_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Expense(
        Expense_id VARCHAR(10) NOT NULL,
        Expense VARCHAR(100) NOT NULL,
        DateOfExp DATE NOT NULL,
        Amount NUMERIC(10,2),
        CONSTRAINT PRIMARY KEY (Expense_id)
); 

create table User (
        username VARCHAR(100) not null,
        password VARCHAR(400) not null,
        power int(1) not null,
        constraint PRIMARY KEY(username)
);

INSERT INTO Material values('M001','Napthol ASBO China','Dye',100);
INSERT INTO Material values('M002','Fast salt black v korea','Dye',50);
INSERT INTO Material values('M003','Fast salt red b japan','Dye',50);
INSERT INTO Material values('M004','Vat violet china','Dye',40);
INSERT INTO Material values('M005','Vat Green B U/D','Dye',40);
INSERT INTO Material values('M006','Fast salt scarlet japan','Dye',30);
INSERT INTO Material values('M007','Vat Brown R U/D','Dye',40);
INSERT INTO Material values('M008','Vat Yellow SRT China','Dye',40);
INSERT INTO Material values('M009','Vat Apple Green','Dye',40);
INSERT INTO Material values('M010','Sodium Hydro Suiphite','Dye',40);
INSERT INTO Material values('M011','C5','Cloth',500);
INSERT INTO Material values('M012','C9','Cloth',400);
INSERT INTO Material values('M013','Viscos','Cloth',200);
INSERT INTO Material values('M014','Voil','Cloth',300);
INSERT INTO Material values('M015','C20','Cloth',150);
INSERT INTO Material values('M016','inch36','Cloth',350);
INSERT INTO Material values('M017','WhiteThread','Thread',1000);
INSERT INTO Material values('M018','BlackThread','Thread',1000);
INSERT INTO Material values('M019','Paraffin','Wax',50);

INSERT INTO Customer values('C001','Gunadasa','Weligama','0712345678','123456676V');
INSERT INTO Customer values('C002','Gunapala','Colombo','0712345678','13445556V');
INSERT INTO Customer values('C003','Gunasena','Matara','0712345678','112333676V');
INSERT INTO Customer values('C004','Amarapala','Galle','0712345678','125666665V');
INSERT INTO Customer values('C005','Siridasa','Deniyaya','0712345678','54333676V');

INSERT INTO Employee values('E001','Gunadasa','Weligama','0712345678','123456676V','Store');
INSERT INTO Employee values('E002','Gunapala','Colombo','0712345678','13445556V','Cutting');
INSERT INTO Employee values('E003','Gunasena','Matara','0712345678','112333676V','Waxing in');
INSERT INTO Employee values('E004','Amarapala','Galle','0712345678','125666665V','Waxing out');
INSERT INTO Employee values('E005','Siridasa','Deniyaya','0712345678','54333676V','DryWashing');

INSERT INTO Garment values('G001','Frock-small',23,10.00,14.00);
INSERT INTO Garment values('G002','Frock-medium',13,12.00,15.00);
INSERT INTO Garment values('G003','Lungi',43,10.00,14.00);
INSERT INTO Garment values('G004','BedSheet',20,15.00,19.00);
INSERT INTO Garment values('G005','Sarong',25,10.00,14.00);
INSERT INTO Garment values('G006','Blouse-small',33,8.00,10.00);

INSERT INTO USER values('Lekha',(select password('1234')),1);
INSERT INTO USER values('Stock',(select password('1234')),2);
INSERT INTO USER values('Production',(select password('1234')),2);
INSERT INTO USER values('Sales',(select password('1234')),2);
INSERT INTO USER values('Salary',(select password('1234')),2);
INSERT INTO USER values('Nimalasena',(select password('1234')),3);
INSERT INTO USER values('Sunila',(select password('1234')),3);
INSERT INTO USER values('Nalaka',(select password('1234')),3);
INSERT INTO USER values('Gayan',(select password('1234')),3);
