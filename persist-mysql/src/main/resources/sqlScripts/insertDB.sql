SET FOREIGN_KEY_CHECKS=0;

INSERT INTO Restaurant VALUES('Alephant', '1998-02-18', 0);
INSERT INTO Restaurant VALUES('Balkan Beef', '2000-03-15', 1);
INSERT INTO Restaurant VALUES('Cabooze', '2014-12-10', 2);
INSERT INTO Restaurant VALUES('Cthulhu�s Kitchen', '1970-08-19', 3);
INSERT INTO Restaurant VALUES('Double Felix', '1980-05-22', 4);
INSERT INTO Restaurant VALUES('Escargot', '2011-12-10', 0);
INSERT INTO Restaurant VALUES('Flange', '2015-09-20', 1);
INSERT INTO Restaurant VALUES('Giotto Gelato', '2000-01-01', 2);
INSERT INTO Restaurant VALUES('Hey Buddha!', '2013-05-09', 3);
INSERT INTO Restaurant VALUES('Isosphere', '2011-10-29', 4);

INSERT INTO Food VALUES(1, 'Goulash', 1, 850, 1, '');
INSERT INTO Food VALUES(2, 'Tofu Taco', 9, 1000, 1, '');
INSERT INTO Food VALUES(3, 'Coca-Cola', 10, 250, 1, '');
INSERT INTO Food VALUES(4, 'Al Capone', 4, 1250, 1, '');
INSERT INTO Food VALUES(5, 'Apple Pie', 3, 800, 1, '');
INSERT INTO Food VALUES(6, 'Bud Spencer', 4, 1400, 1, '');
INSERT INTO Food VALUES(7, 'Hamburger', 5, 650, 1, '');
INSERT INTO Food VALUES(8, 'Pepsi-Cola', 10, 180, 1, '');
INSERT INTO Food VALUES(9, 'Beer', 10, 300, 1, '');
INSERT INTO Food VALUES(10, 'Brownie', 3, 700, 1, '');

INSERT INTO FoodSelling VALUES(1,1,'Alephant');
INSERT INTO FoodSelling VALUES(2,2,'Balkan Beef');
INSERT INTO FoodSelling VALUES(3,3,'Cabooze');
INSERT INTO FoodSelling VALUES(4,4,'Cabooze');
INSERT INTO FoodSelling VALUES(5,5,'Cabooze');
INSERT INTO FoodSelling VALUES(6,6,'Alephant');
INSERT INTO FoodSelling VALUES(7,7,'Isosphere');
INSERT INTO FoodSelling VALUES(8,8,'Isosphere');
INSERT INTO FoodSelling VALUES(9,9,'Isosphere');
INSERT INTO FoodSelling VALUES(10,10,'Alephant');

INSERT INTO ATable VALUES(1, 'Alephant', 'FOUR_SEATER', TRUE);
INSERT INTO ATable VALUES(2, 'Balkan Beef', 'TWO_SEATER', FALSE);
INSERT INTO ATable VALUES(3, 'Cabooze', 'THREE_SEATER', TRUE);
INSERT INTO ATable VALUES(4, 'Cthulhu�s Kitchen', 'FOUR_SEATER', FALSE);
INSERT INTO ATable VALUES(5, 'Double Felix', 'FOUR_SEATER', TRUE);
INSERT INTO ATable VALUES(6, 'Escargot', 'FOUR_SEATER', FALSE);
INSERT INTO ATable VALUES(7, 'Flange', 'FOUR_SEATER', FALSE);
INSERT INTO ATable VALUES(8, 'Giotto Gelato', 'FIVE_SEATER', TRUE);
INSERT INTO ATable VALUES(9, 'Isosphere', 'SIX_SEATER', FALSE);
INSERT INTO ATable VALUES(10, 'Isosphere', 'TWO_SEATER', TRUE);

INSERT INTO Payment VALUES(1, 'Alephant', 0);
INSERT INTO Payment VALUES(2, 'Balkan Beef', 1);
INSERT INTO Payment VALUES(3, 'Cabooze', 2);
INSERT INTO Payment VALUES(4, 'Cthulhu�s Kitchen',3);
INSERT INTO Payment VALUES(5, 'Double Felix', 0);
INSERT INTO Payment VALUES(6, 'Escargot', 1);
INSERT INTO Payment VALUES(7, 'Flange', 2);
INSERT INTO Payment VALUES(8, 'Giotto Gelato', 3);
INSERT INTO Payment VALUES(9, 'Isosphere', 0);
INSERT INTO Payment VALUES(10, 'Isosphere', 1);

INSERT INTO Reservation VALUES(1, 'Alephant', 1, 2000, 0, '2016-10-10', 'Este 8');
INSERT INTO Reservation VALUES(2, 'Balkan Beef', 2, 1200, 1, '2016-11-11', '+1 sz�k');
INSERT INTO Reservation VALUES(3, 'Cabooze', 3, 1000, 2, '2016-12-12', 'Reggel 6');
INSERT INTO Reservation VALUES(4, 'Cthulhu�s Kitchen', 4, 2500, 3, '2016-11-22', '');
INSERT INTO Reservation VALUES(5, 'Double Felix', 5, 4000, 0, '2016-10-23', 'Liszt�rz�keny');
INSERT INTO Reservation VALUES(6, 'Escargot', 6, 1200, 1, '2016-02-02', '');
INSERT INTO Reservation VALUES(7, 'Flange', 7, 1000, 2, '2017-10-05', 'Este 9');
INSERT INTO Reservation VALUES(8, 'Giotto Gelato', 8, 2500, 3, '2012-09-10', 'D�l');
INSERT INTO Reservation VALUES(9, 'Isosphere', 9, 1300, 0, '2017-02-02', '+2 f�');
INSERT INTO Reservation VALUES(10, 'Isosphere', 10, 2500, 1, '2014-05-10', '');

INSERT INTO OrderedFood VALUES(1,1,1);
INSERT INTO OrderedFood VALUES(2,1,2);
INSERT INTO OrderedFood VALUES(3,1,3);
INSERT INTO OrderedFood VALUES(4,2,3);
INSERT INTO OrderedFood VALUES(5,3,3);
INSERT INTO OrderedFood VALUES(6,4,4);
INSERT INTO OrderedFood VALUES(7,4,2);
INSERT INTO OrderedFood VALUES(8,4,1);

INSERT INTO Feedback VALUES(1, 0, '2011-05-10', 'alma');
INSERT INTO Feedback VALUES(2, 1, '2012-05-10', 'korte');
INSERT INTO Feedback VALUES(3, 2, '2013-05-10', 'szilva');
INSERT INTO Feedback VALUES(4, 3, '2014-05-10', 'eper');
INSERT INTO Feedback VALUES(5, 4, '2015-05-10', '');