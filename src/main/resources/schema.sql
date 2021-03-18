DROP TABLE IF EXISTS user;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT UNIQUE,
  `name` varchar(200) NOT NULL,
  `create_ts` timestamp NULL DEFAULT NULL,
  `last_ts` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,2) NOT NULL,
  `id_user` int(11) NOT NULL,
  `card_data` varchar(45) NOT NULL,
  `disbursed` tinyint(1) NOT NULL DEFAULT '0',
  `create_ts` timestamp NULL DEFAULT NULL,
  `last_ts` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);
