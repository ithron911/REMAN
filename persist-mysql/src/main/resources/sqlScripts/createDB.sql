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
    Name VARCHAR(100) NOT NULL,
	RestaurantName VARCHAR(30),
    FoodType VARCHAR(50),
    Price INT,
    PRIMARY KEY ( ID ),
	FOREIGN KEY ( RestaurantName ) REFERENCES Restaurant(Name)
);

CREATE TABLE ATable(
	ID INT NOT NULL AUTO_INCREMENT,
	TableType VARCHAR(50),
	RestaurantName VARCHAR(30),
	isReserved BOOLEAN,
	PRIMARY KEY ( ID ),
	FOREIGN KEY ( RestaurantName ) REFERENCES Restaurant(Name)
);                  

CREATE TABLE Payment(
	ID INT NOT NULL AUTO_INCREMENT,
	PaymentType VARCHAR(30),
	RestaurantName VARCHAR(30),
	PRIMARY KEY ( ID ),
	FOREIGN KEY ( RestaurantName ) REFERENCES Restaurant(Name)
);


CREATE TABLE Reservation(
	Price INT,
    DateBook DATE,
    Comment Varchar(200),
	RestaurantName VARCHAR(30),
	PaymantID INT,
FoodID INT,
		FOREIGN KEY ( RestaurantName ) REFERENCES Restaurant(Name),
	FOREIGN KEY ( FoodID) REFERENCES Food(ID),
	FOREIGN KEY ( PaymantID ) REFERENCES Payment(ID)
                         );					

FOREIGN KEY ( ) REFERENCES table( );