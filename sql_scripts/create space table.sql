CREATE DATABASE IF NOT EXISTS `Your_space`;
USE `Your_space`;
DROP TABLE IF EXISTS `space`;
CREATE TABLE `space`(
`spaceid` int(10) NOT NULL auto_increment,
`adresss` varchar(50) NOT NULL,
`district` varchar(20) NOT NULL,
`rating` float NOT NULL,
`images` varbinary(250),
`No_of-rooms` long 	NOT NULL,
`description` varchar(100) 	NOT NULL,
`name` varchar(20) NOT NULL,
`contact_No` varchar(13) NOT NULL,
`price_range_min` double NOT NULL,
`price_range_max` double NOT NULL,
`opening_hours_min` time NOT NULL,
`opening_hours_max` time NOT NULL,
`offers_drinks` bool NOT NULL,
`owner` varchar(25) NOT NULL,
`outdoors` bool NOT NULL,
primary key(`spaceid`)
)