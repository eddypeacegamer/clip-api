DROP TABLE user;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `name` varchar(200) NOT NULL,
  `create_ts` timestamp NULL DEFAULT NULL,
  `last_ts` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_user_name` (`name`)
);
