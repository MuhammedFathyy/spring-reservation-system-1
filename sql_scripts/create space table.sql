CREATE DATABASE IF NOT EXISTS `your_space`;
USE `your_space`;
DROP TABLE IF EXISTS `space`;
CREATE TABLE `space`(
`space_id` int(10) NOT NULL auto_increment,
`adresss` varchar(50) NOT NULL,
`district` varchar(20) NOT NULL,
`rating` float NOT NULL,
`images` varchar (250),
`room_numbers` long NOT NULL,
`description` varchar(100) 	NOT NULL,
`name` varchar(20) NOT NULL,
`contact_No` varchar(13) NOT NULL,
`min_price` double NOT NULL,
`max_price` double NOT NULL,
`min_opening_hours` varchar(10) NOT NULL,
`max_opening_hours` varchar(10) NOT NULL,
`offers_drinks` bool NOT NULL,
`owner` varchar(25) NOT NULL,
`outdoors` bool NOT NULL,
primary key(`spaceid`)
)