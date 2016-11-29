SET FOREIGN_KEY_CHECKS=0;

INSERT INTO Restaurant VALUES('Alephant', '1998-02-18', 'fastfood');
INSERT INTO Restaurant VALUES('Balkan Beef', '2000-03-15', 'streetfood');
INSERT INTO Restaurant VALUES('Cabooze', '2014-12-10', 'pub');
INSERT INTO Restaurant VALUES('Cthulhu�s Kitchen', '1970-08-19', 'fastfood');
INSERT INTO Restaurant VALUES('Double Felix', '1980-05-22', 'pizzeria');
INSERT INTO Restaurant VALUES('Escargot', '2011-12-10', 'fastfood');
INSERT INTO Restaurant VALUES('Flange', '2015-09-20', 'pizzeria');
INSERT INTO Restaurant VALUES('Giotto Gelato', '2000-01-01', 'casual');
INSERT INTO Restaurant VALUES('Hey Buddha!', '2013-05-09', 'casual');
INSERT INTO Restaurant VALUES('Isosphere', '2011-10-29', 'streetfood');

INSERT INTO Food VALUES(NULL, 'Giotto Gelato', 'Goulash', 'Soup', 850);
INSERT INTO Food VALUES(NULL, 'Hey Buddha!', 'Tofu Taco', 'Vegetarian', 1000);
INSERT INTO Food VALUES(NULL, 'Isosphere', 'Coca-Cola', 'Drinks', 250);
INSERT INTO Food VALUES(NULL, 'Flange', 'Al Capone', 'Pizza', 1250);
INSERT INTO Food VALUES(NULL, 'Escargot', 'Apple Pie', 'Dessert', 800);
INSERT INTO Food VALUES(NULL, 'Double Felix', 'Bud Spencer', 'Pizza', 1400);
INSERT INTO Food VALUES(NULL, 'Cthulhu�s Kitchen', 'Hamburger', 'Fastfood', 650);
INSERT INTO Food VALUES(NULL, 'Cabooze', 'Pepsi-Cola', 'Drinks', 180);
INSERT INTO Food VALUES(NULL, 'Balkan Beef', 'Beer', 'Drinks', 300);
INSERT INTO Food VALUES(NULL, 'Alephant', 'Brownie', 'Dessert', 700);

INSERT INTO ATable VALUES(NULL, 'Alephant', 'FOUR_SEATER', TRUE);
INSERT INTO ATable VALUES(NULL, 'Balkan Beef', 'TWO_SEATER', FALSE);
INSERT INTO ATable VALUES(NULL, 'Cabooze', 'THREE_SEATER', TRUE);
INSERT INTO ATable VALUES(NULL, 'Cthulhu�s Kitchen', 'FOUR_SEATER', FALSE);
INSERT INTO ATable VALUES(NULL, 'Double Felix', 'FOUR_SEATER', TRUE);
INSERT INTO ATable VALUES(NULL, 'Escargot', 'FOUR_SEATER', FALSE);
INSERT INTO ATable VALUES(NULL, 'Flange', 'FOUR_SEATER', FALSE);
INSERT INTO ATable VALUES(NULL, 'Giotto Gelato', 'FIVE_SEATER', TRUE);
INSERT INTO ATable VALUES(NULL, 'Hey Buddha!', 'SIX_SEATER', FALSE);
INSERT INTO ATable VALUES(NULL, 'Isosphere', 'TWO_SEATER', TRUE);

INSERT INTO Payment VALUES(NULL, 'Alephant', 'withCard');
INSERT INTO Payment VALUES(NULL, 'Balkan Beef', 'inCash');
INSERT INTO Payment VALUES(NULL, 'Cabooze', 'online');
INSERT INTO Payment VALUES(NULL, 'Cthulhu�s Kitchen', 'withCard');
INSERT INTO Payment VALUES(NULL, 'Double Felix', 'coupon');
INSERT INTO Payment VALUES(NULL, 'Escargot', 'withCard');
INSERT INTO Payment VALUES(NULL, 'Flange', 'coupon');
INSERT INTO Payment VALUES(NULL, 'Giotto Gelato', 'withCard');
INSERT INTO Payment VALUES(NULL, 'Hey Buddha!', 'withCard');
INSERT INTO Payment VALUES(NULL, 'Isosphere', 'inCash');

INSERT INTO Reservation VALUES('Alephant', 1, 10, 2000, '2016-10-10', 'Este 8');
INSERT INTO Reservation VALUES('Balkan Beef', 2, 9, 1200, '2016-11-11', '+1 sz�k');
INSERT INTO Reservation VALUES('Cabooze', 3, 8, 1000, '2016-12-12', 'Reggel 6');
INSERT INTO Reservation VALUES('Cthulhu�s Kitchen', 4, 7, 2500, '2016-11-22', '');
INSERT INTO Reservation VALUES('Double Felix', 5, 6, 4000, '2016-10-23', 'Liszt�rz�keny');
INSERT INTO Reservation VALUES('Escargot', 6, 5, 1200, '2016-02-02', '');
INSERT INTO Reservation VALUES('Flange', 7, 4, 1000, '2017-10-05', 'Este 9');
INSERT INTO Reservation VALUES('Giotto Gelato', 8, 1, 2500, '2012-09-10', 'D�l');
INSERT INTO Reservation VALUES('Hey Buddha!', 9, 2, 1300, '2017-02-02', '+2 f�');
INSERT INTO Reservation VALUES('Isosphere', 10, 3, 2500, '2014-05-10', '');