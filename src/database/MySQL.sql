/**
 * Author:  neury
 * Created: 8 may 2024
 */

CREATE SCHEMA `database` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE `demo` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `lastname` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
)