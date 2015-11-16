create database usersdb;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1

DROP TABLE IF EXISTS test.items;
CREATE TABLE `items` (  `id` int(11) NOT NULL,
`code` varchar(15) NOT NULL ,
`category` varchar(15) NOT NULL ,
`name` varchar(15) NOT NULL ,
`price` double NOT NULL ,
`stock` int NOT NULL ,
`saleprice` double NOT NULL ,
`tax` long NOT NULL ,
`discount` long NOT NULL ,
`brandname` varchar(15) NOT NULL ,
`companyname` varchar(15) NOT NULL ,
`catalog` varchar(15) NOT NULL ,
`remarks` varchar(15) NOT NULL ,
`updatedby` varchar(15) NOT NULL ,
`updatedone` varchar(15) NOT NULL ,
`discontinued` varchar(15) NOT NULL ,
`reasondiscont` varchar(15) NOT NULL,
PRIMARY KEY (`id`)
)


