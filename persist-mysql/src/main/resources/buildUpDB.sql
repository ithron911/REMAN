CREATE DATABASE REMAN;

CREATE USER REMAN_DEVELOPER@'localhost' IDENTIFIED BY 'RemanPass123';
GRANT ALL PRIVILEGES ON REMAN.* TO 'REMAN_DEVELOPER'@'localhost';

USE REMAN;

CREATE TABLE COUNTY(
ID INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(200) NOT NULL
);

CREATE TABLE REASON(
ID INT PRIMARY KEY AUTO_INCREMENT,
Reason VARCHAR(200) NOT NULL
);

CREATE TABLE RESTAURANT(
ID INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(200) NOT NULL,
County_ID INT NOT NULL,
FOREIGN KEY (County_ID) REFERENCES COUNTY(ID)
);

CREATE TABLE RESTAURANT_REASON(
ID INT PRIMARY KEY AUTO_INCREMENT,
Restaurant_ID INT NOT NULL,
Reason_ID INT NOT NULL,
FOREIGN KEY (Restaurant_ID) REFERENCES RESTAURANT(ID),
FOREIGN KEY (Reason_ID) REFERENCES REASON(ID)
);

CREATE TABLE RESTAURANT_TABLE(
ID INT PRIMARY KEY AUTO_INCREMENT,
Restaurant_ID INT NOT NULL,
Chair_Number INT NOT NULL,
IS_RESERVED BOOLEAN NOT NULL,
FOREIGN KEY (Restaurant_ID) REFERENCES RESTAURANT(ID)
);

CREATE TABLE FOOD_TYPE(
ID INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(200) NOT NULL
);

CREATE TABLE FOOD(
ID INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(200) NOT NULL,
Price INT NOT NULL,
FOOD_TYPE_ID INT NOT NULL,
FOREIGN KEY (FOOD_TYPE_ID) REFERENCES FOOD_TYPE(ID)
);

CREATE TABLE RESTAURANT_FOOD(
ID INT PRIMARY KEY AUTO_INCREMENT,
Restaurant_ID INT NOT NULL,
Food_ID INT NOT NULL,
FOREIGN KEY (Restaurant_ID) REFERENCES RESTAURANT(ID),
FOREIGN KEY (Food_ID) REFERENCES FOOD(ID)
);

CREATE TABLE RESERVATION(
ID INT PRIMARY KEY AUTO_INCREMENT,
Reservation_Date Date NOT NUll,
Name VARCHAR(100) NOT NULL,
Phone_Number VARCHAR(50),
Email VARCHAR(100)
);

CREATE TABLE RESERVATION_PLACES(
ID INT PRIMARY KEY AUTO_INCREMENT,
Reservation_ID INT NOT NULL,
Restaurant_Table_ID INT NOT NULL,
FOREIGN KEY (Reservation_ID) REFERENCES RESERVATION(ID),
FOREIGN KEY (Restaurant_Table_ID) REFERENCES RESTAURANT_TABLE(ID)
);