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

INSERT INTO Food VALUES(NULL, 'Giotto Gelato', 'Goulash', 1, 850, 1, '');
INSERT INTO Food VALUES(NULL, 'Hey Buddha!', 'Tofu Taco', 9, 1000, 1, '');
INSERT INTO Food VALUES(NULL, 'Isosphere', 'Coca-Cola', 10, 250, 1, '');
INSERT INTO Food VALUES(NULL, 'Flange', 'Al Capone', 4, 1250, 1, '');
INSERT INTO Food VALUES(NULL, 'Escargot', 'Apple Pie', 3, 800, 1, '');
INSERT INTO Food VALUES(NULL, 'Double Felix', 'Bud Spencer', 4, 1400, 1, '');
INSERT INTO Food VALUES(NULL, 'Cthulhu�s Kitchen', 'Hamburger', 5, 650, 1, '');
INSERT INTO Food VALUES(NULL, 'Cabooze', 'Pepsi-Cola', 10, 180, 1, '');
INSERT INTO Food VALUES(NULL, 'Balkan Beef', 'Beer', 10, 300, 1, '');
INSERT INTO Food VALUES(NULL, 'Alephant', 'Brownie', 3, 700, 1, '');

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

INSERT INTO Payment VALUES(NULL, 'Alephant', 0);
INSERT INTO Payment VALUES(NULL, 'Balkan Beef', 1);
INSERT INTO Payment VALUES(NULL, 'Cabooze', 2);
INSERT INTO Payment VALUES(NULL, 'Cthulhu�s Kitchen',3);
INSERT INTO Payment VALUES(NULL, 'Double Felix', 0);
INSERT INTO Payment VALUES(NULL, 'Escargot', 1);
INSERT INTO Payment VALUES(NULL, 'Flange', 2);
INSERT INTO Payment VALUES(NULL, 'Giotto Gelato', 3);
INSERT INTO Payment VALUES(NULL, 'Hey Buddha!', 0);
INSERT INTO Payment VALUES(NULL, 'Isosphere', 1);

INSERT INTO Reservation VALUES(NULL, 'Alephant', 1, 10, 2000, 0, '2016-10-10', 'Este 8');
INSERT INTO Reservation VALUES(NULL, 'Balkan Beef', 2, 9, 1200, 1, '2016-11-11', '+1 sz�k');
INSERT INTO Reservation VALUES(NULL, 'Cabooze', 3, 8, 1000, 2, '2016-12-12', 'Reggel 6');
INSERT INTO Reservation VALUES(NULL, 'Cthulhu�s Kitchen', 4, 7, 2500, 3, '2016-11-22', '');
INSERT INTO Reservation VALUES(NULL, 'Double Felix', 5, 6, 4000, 0, '2016-10-23', 'Liszt�rz�keny');
INSERT INTO Reservation VALUES(NULL, 'Escargot', 6, 5, 1200, 1, '2016-02-02', '');
INSERT INTO Reservation VALUES(NULL, 'Flange', 7, 4, 1000, 2, '2017-10-05', 'Este 9');
INSERT INTO Reservation VALUES(NULL, 'Giotto Gelato', 8, 1, 2500, 3, '2012-09-10', 'D�l');
INSERT INTO Reservation VALUES(NULL, 'Hey Buddha!', 9, 2, 1300, 0, '2017-02-02', '+2 f�');
INSERT INTO Reservation VALUES(NULL, 'Isosphere', 10, 3, 2500, 1, '2014-05-10', '');