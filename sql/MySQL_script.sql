create database usersdb;
DROP TABLE IF EXISTS test.users;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `PHONE` varchar(20) NOT NULL,
  `FAX` varchar(20) DEFAULT NULL,
  `ADD1` varchar(20) NOT NULL,
  `ADD2` varchar(20) DEFAULT NULL,
  `ADD3` varchar(20) DEFAULT NULL,
  `CARDNO` varchar(20) DEFAULT NULL,
  `CARDEXPDT` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS test.items;CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(15) DEFAULT NULL,
  `category` varchar(15) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `saleprice` double DEFAULT NULL,
  `tax` mediumtext,
  `discount` mediumtext,
  `brandname` varchar(15) DEFAULT NULL,
  `catalog` varchar(15) DEFAULT NULL,
  `remarks` varchar(15) DEFAULT NULL,
  `updatedby` varchar(15) DEFAULT NULL,
  `updatedone` varchar(15) DEFAULT NULL,
  `discontinued` varchar(15) DEFAULT NULL,
  `reasondiscont` varchar(15) DEFAULT NULL,
  `image` blob,
  `companyname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

DROP PROCEDURE IF EXISTS test.GetAllItems;
CREATE PROCEDURE test.`GetAllItems`()
BEGIN
   SELECT * FROM items ;
   END;

DROP PROCEDURE IF EXISTS test.GetAllUsers;
CREATE PROCEDURE test.`GetAllUsers`()
BEGIN
   SELECT * FROM users ;
   END;

DROP PROCEDURE IF EXISTS test.GetItemByCode;
CREATE PROCEDURE test.`GetItemByCode`(cd varchar(20))
BEGIN
   SELECT * FROM items where code = cd;
   END;

DROP PROCEDURE IF EXISTS test.GetItemByID;
CREATE PROCEDURE test.`GetItemByID`(itemid int)
BEGIN
   SELECT * FROM items where id = itemid;
   END;

DROP PROCEDURE IF EXISTS test.GetItemByName;
CREATE PROCEDURE test.`GetItemByName`(itemname varchar(20))
BEGIN
   SELECT * FROM items where name LIKE CONCAT('%',itemname,'%');
   END;

DROP PROCEDURE IF EXISTS test.GetStocks;
CREATE PROCEDURE test.`GetStocks`(int_stockcode varchar(20))
BEGIN
   SELECT * FROM stock where stock_code = int_stockcode;
   END;

DROP PROCEDURE IF EXISTS test.GetUserByID;
CREATE PROCEDURE test.`GetUserByID`(userid int)
BEGIN
   SELECT * FROM users where user_id = userid;
   END;

DROP PROCEDURE IF EXISTS test.GetUserByName;
CREATE PROCEDURE test.`GetUserByName`(usrname varchar(20))
BEGIN
   SELECT * FROM users where username LIKE CONCAT('%',usrname,'%');
   END;

