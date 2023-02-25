DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
                           `book_id` int NOT NULL AUTO_INCREMENT,
                           `start_time` time NOT NULL,
                           `end_time` time NOT NULL,
                           `date` date NOT NULL,
                           `user_id` int NOT NULL,
                           PRIMARY KEY (`book_id`),
                           FOREIGN KEY (`user_id`) REFERENCES user(`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;