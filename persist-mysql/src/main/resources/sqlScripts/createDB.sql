CREATE DATABASE REMAN;
USE REMAN;

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON REMAN.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;

CREATE TABLE Restaurant(
	Name VARCHAR(30) NOT NULL,
	Founding VARCHAR(30),
	Type VARCHAR(30),
	PRIMARY KEY ( Name )
)

CREATE TABLE Food(
	ID INT NOT NULL AUTO_INCREMENT,
	RestaurantName VARCHAR(30),
    Name VARCHAR(100) NOT NULL,
    FoodType VARCHAR(50),
    Price INT,
    PRIMARY KEY ( ID ),
	FOREIGN KEY ( RestaurantName ) REFERENCES Restaurant(Name)
);

CREATE TABLE ATable(
	ID INT NOT NULL AUTO_INCREMENT,
	RestaurantName VARCHAR(30),
	TableType VARCHAR(50),
	isReserved BOOLEAN,
	PRIMARY KEY ( ID ),
	FOREIGN KEY ( RestaurantName ) REFERENCES Restaurant(Name)
);                  

CREATE TABLE Payment(
	ID INT NOT NULL AUTO_INCREMENT,
	RestaurantName VARCHAR(30),
	PaymentType VARCHAR(30),
	PRIMARY KEY ( ID ),
	FOREIGN KEY ( RestaurantName ) REFERENCES Restaurant(Name)
);


CREATE TABLE Reservation(
	RestaurantName VARCHAR(30),
	PaymantID INT,
	FoodID INT,
	Price INT,
    DateBook DATE,
    Comment Varchar(200),
	FOREIGN KEY ( RestaurantName ) REFERENCES Restaurant(Name),
	FOREIGN KEY ( FoodID) REFERENCES Food(ID),
	FOREIGN KEY ( PaymantID ) REFERENCES Payment(ID)
);					