CREATE TABLE Restaurant(
	Name VARCHAR(30) NOT NULL,
	Founding DATE,
	Type INT,
	PRIMARY KEY ( Name )
);

CREATE TABLE Food(
	ID INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    FoodType INT,
    Price INT,
    currency INT,
    description VARCHAR(100),
    PRIMARY KEY ( ID )
);

CREATE TABLE FoodSelling(
	foodId INT,
	restaurantId VARCHAR(30),
	primary key (foodId,restaurantId),
	foreign key (foodId) REFERENCES Food(ID),
	foreign key (restaurantId) REFERENCES Restaurant(Name)
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
	PaymentType INT,
	PRIMARY KEY ( ID ),
	FOREIGN KEY ( RestaurantName ) REFERENCES Restaurant(Name)
);


CREATE TABLE Reservation(
    ID INT NOT NULL AUTO_INCREMENT,
	RestaurantName VARCHAR(30),
	PaymentID INT,
	Price INT,
	Currency INT,
	DateBook DATE,
	Comment Varchar(200),
	PRIMARY KEY ( ID ),
	FOREIGN KEY ( RestaurantName ) REFERENCES Restaurant(Name),
	FOREIGN KEY ( PaymentID ) REFERENCES Payment(ID)
);

CREATE TABLE OrderedFood(
	reservationId INT,
	foodId INT,
	primary key (foodId,reservationId),
	foreign key (foodId) REFERENCES Food(ID),
	foreign key (reservationId) REFERENCES Reservation(ID)
);
