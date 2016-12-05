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

INSERT INTO Food VALUES(1, 'Giotto Gelato', 'Goulash', 1, 850, 1, '');
INSERT INTO Food VALUES(2, 'Hey Buddha!', 'Tofu Taco', 9, 1000, 1, '');
INSERT INTO Food VALUES(3, 'Isosphere', 'Coca-Cola', 10, 250, 1, '');
INSERT INTO Food VALUES(4, 'Flange', 'Al Capone', 4, 1250, 1, '');
INSERT INTO Food VALUES(5, 'Escargot', 'Apple Pie', 3, 800, 1, '');
INSERT INTO Food VALUES(6, 'Double Felix', 'Bud Spencer', 4, 1400, 1, '');
INSERT INTO Food VALUES(7, 'Cthulhu�s Kitchen', 'Hamburger', 5, 650, 1, '');
INSERT INTO Food VALUES(7, 'Cabooze', 'Pepsi-Cola', 10, 180, 1, '');
INSERT INTO Food VALUES(9, 'Balkan Beef', 'Beer', 10, 300, 1, '');
INSERT INTO Food VALUES(10, 'Alephant', 'Brownie', 3, 700, 1, '');

INSERT INTO ATable VALUES(1, 'Alephant', 'FOUR_SEATER', TRUE);
INSERT INTO ATable VALUES(2, 'Balkan Beef', 'TWO_SEATER', FALSE);
INSERT INTO ATable VALUES(3, 'Cabooze', 'THREE_SEATER', TRUE);
INSERT INTO ATable VALUES(4, 'Cthulhu�s Kitchen', 'FOUR_SEATER', FALSE);
INSERT INTO ATable VALUES(5, 'Double Felix', 'FOUR_SEATER', TRUE);
INSERT INTO ATable VALUES(6, 'Escargot', 'FOUR_SEATER', FALSE);
INSERT INTO ATable VALUES(7, 'Flange', 'FOUR_SEATER', FALSE);
INSERT INTO ATable VALUES(8, 'Giotto Gelato', 'FIVE_SEATER', TRUE);
INSERT INTO ATable VALUES(9, 'Hey Buddha!', 'SIX_SEATER', FALSE);
INSERT INTO ATable VALUES(10, 'Isosphere', 'TWO_SEATER', TRUE);

INSERT INTO Payment VALUES(1, 'Alephant', 0);
INSERT INTO Payment VALUES(2, 'Balkan Beef', 1);
INSERT INTO Payment VALUES(3, 'Cabooze', 2);
INSERT INTO Payment VALUES(4, 'Cthulhu�s Kitchen',3);
INSERT INTO Payment VALUES(5, 'Double Felix', 0);
INSERT INTO Payment VALUES(6, 'Escargot', 1);
INSERT INTO Payment VALUES(7, 'Flange', 2);
INSERT INTO Payment VALUES(8, 'Giotto Gelato', 3);
INSERT INTO Payment VALUES(9, 'Hey Buddha!', 0);
INSERT INTO Payment VALUES(10, 'Isosphere', 1);

INSERT INTO Reservation VALUES(1, 'Alephant', 1, 10, 2000, 0, '2016-10-10', 'Este 8');
INSERT INTO Reservation VALUES(2, 'Balkan Beef', 2, 9, 1200, 1, '2016-11-11', '+1 sz�k');
INSERT INTO Reservation VALUES(3, 'Cabooze', 3, 8, 1000, 2, '2016-12-12', 'Reggel 6');
INSERT INTO Reservation VALUES(4, 'Cthulhu�s Kitchen', 4, 7, 2500, 3, '2016-11-22', '');
INSERT INTO Reservation VALUES(5, 'Double Felix', 5, 6, 4000, 0, '2016-10-23', 'Liszt�rz�keny');
INSERT INTO Reservation VALUES(6, 'Escargot', 6, 5, 1200, 1, '2016-02-02', '');
INSERT INTO Reservation VALUES(7, 'Flange', 7, 4, 1000, 2, '2017-10-05', 'Este 9');
INSERT INTO Reservation VALUES(8, 'Giotto Gelato', 8, 1, 2500, 3, '2012-09-10', 'D�l');
INSERT INTO Reservation VALUES(9, 'Hey Buddha!', 9, 2, 1300, 0, '2017-02-02', '+2 f�');
INSERT INTO Reservation VALUES(10, 'Isosphere', 10, 3, 2500, 1, '2014-05-10', '');