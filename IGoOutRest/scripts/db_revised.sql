CREATE DATABASE IF NOT EXISTS `igoout` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `igoout`;

CREATE TABLE IF NOT EXISTS `comments` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `event_id` INT(10) NOT NULL,
  `user_id` INT(10) NOT NULL,
  `username` VARCHAR(32) NOT NULL,
  `date` DATETIME NOT NULL,
  `comment` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci  AUTO_INCREMENT=11 ;

INSERT INTO `comments` (`id`, `event_id`, `user_id`, `username`, `date`, `comment`) VALUES
(1, 1, 1, 'pero', '2013-08-16 16:03:00', 'Ludilo brale!!!!!'),
(2, 2, 2, 'muka', '2013-08-17 16:03:01', 'Ajmoooooooooooooooo'),
(3, 3, 3, 'ana', '2013-08-18 16:03:02', 'aj ma biži ća!'),
(4, 4, 4, 'bogdan', '2013-08-19 16:03:03', 'Dolazim odma sada odma!'),
(5, 5, 5, 'cero', '2013-08-20 16:03:04', 'Vidimo se tranu ;)'),
(6, 6, 6, 'dino', '2013-08-21 16:03:05', 'Šećer u ruku'),
(7, 7, 7, 'emre', '2013-08-16 16:03:06', 'Mućki provokator'),
(8, 8, 8, 'fico', '2013-08-17 16:03:07', 'Šveps, dolazi??'),
(9, 9, 9, 'gabor', '2013-08-18 16:03:08', 'Majko moja'),
(10, 10, 10, 'haso', '2013-08-19 16:03:09', 'Ma ja ba!');

CREATE TABLE IF NOT EXISTS `events` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `location_id` INT(10) NOT NULL,
  `interests` VARCHAR(255)  NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `start_time` DATETIME NOT NULL,
  `summary` VARCHAR(255) NOT NULL,
  `website` TEXT NOT NULL,
  `picture_url` TEXT  NOT NULL,
  `rating` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=11 ;

INSERT INTO `events` (`id`, `location_id`, `interests`, `name`, `start_time`, `summary`, `website`, `picture_url`, `rating`) VALUES
(1, 1, 'Comedy', 'Stand up u Trendu!', '2013-08-15 20:00:00', 'Stand up u Trendu!', 'https://www.facebook.com', '', 3.33333),
(2, 2, 'Festival', 'Festival u Poeziji', '2013-08-15 21:00:00', 'Festival u Poeziji', 'https://www.facebook.com', '', 3),
(3, 3, 'Happy Hour', 'Happy hour u Vertigu', '2013-08-15 22:00:00', 'Happy hour u Vertigu', 'https://www.facebook.com', '', 2.66667),
(4, 4, 'Free', 'Free hrana u Hemingwayu', '2013-08-15 18:00:00', 'Free hrana u Hemingwayu', 'https://www.facebook.com', '', 2.33333),
(5, 5, 'DJ', 'DJ Krmak u Kavkazu!', '2013-08-15 20:00:00', 'DJ Krmak u Kavkazu!', 'https://www.facebook.com', '', 3.66667),
(6, 6, 'Foam party', 'Pjena party u Cyber Funk cafeu', '2013-08-15 22:00:00', 'Pjena party u Cyber Funk cafeu', 'https://www.facebook.com', '', 3.33333),
(7, 7, 'Striptease', 'Striptease u Lemonu!', '2013-08-15 21:00:00', 'Striptease u Lemonu!', 'https://www.facebook.com', '', 3),
(8, 8, 'Hostesses', 'Hostese u Cosmopolitanu', '2013-08-15 23:00:00', 'Hostese u Cosmopolitanu', 'https://www.facebook.com', '', 2.66667),
(9, 9, 'Live Music', 'Živa svirka u Charlie-u', '2013-08-15 21:00:00', 'Živa svirka u Charlie-u', 'https://www.facebook.com', '', 2.33333),
(10, 10, 'Concert', 'Koncert grupe Duo u Fantasy-u', '2013-08-15 22:00:00', 'Koncert grupe Duo u Fantasy-u', 'https://www.facebook.com', '', 3);


CREATE TABLE IF NOT EXISTS `locations` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32)  NOT NULL,
  `type` VARCHAR(16)  NOT NULL,
  `address` VARCHAR(32)  NOT NULL,
  `latitude` FLOAT(10,6) NOT NULL,
  `longitude` FLOAT(10,6) NOT NULL,
  `phone` VARCHAR(64)  NOT NULL,
  `hours` VARCHAR(255)  NOT NULL,
  `summary` VARCHAR(32)  NOT NULL,
  `website` TEXT  NOT NULL,
  `picture_url` TEXT  NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`,`name`,`address`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=11 ;

INSERT INTO `locations` (`id`, `name`, `type`, `address`, `latitude`, `longitude`, `phone`, `hours`, `summary`, `website`, `picture_url`) VALUES
(1, 'Caffe bar Trend', 'Cafe', 'Špansko 2, Zagreb', 45.801266, 15.897694, '', '', '', '', 'trend.jpg'),
(2, 'Caffe Bar Poezija', 'Bar', 'Gustava Krkleca 3, Zagreb', 45.801594, 15.903956, '', '', '', '', 'poezija.jpg'),
(3, 'Vertigo bar', 'Bar', 'Zagrebacka avenija 100, Zagreb', 45.797256, 15.900417, '(3851) 204-1812', 'Mon - Thu: 10:00 am - 2:00 am\nFri - Sat: 10:00 am - 4:00 am\nSun: 10:00 am - 2:00 am', '', 'http://www.vertigo-bar.com', 'vertigo.jpg'),
(4, 'Hemingway lounge bar', 'Lounge Bar', 'Tuškanac 1, Zagreb', 45.815422, 15.969365, '(3851) 483-4958', '', '', 'http://www.hemingway.hr', 'hemingway.jpg'),
(5, 'Kazališna kavana Kavkaz', 'Cafe', 'Gajeva ulica 9, Zagreb', 45.811611, 15.976213, '', '', '', '', 'kavkaz.jpg'),
(6, 'Cyber Funk cafe', 'Bar', 'Masarykova 26, Zagreb', 45.811607, 15.976213, '', '', 'Walk-Ins Welcome\nGood For Kids\nT', 'http://www.cyberfunkcafe.com', 'cyber.jpg'),
(7, 'Lemon', 'Nightclub', 'Ljudevita Gaja 10, Zagreb', 45.811611, 15.976213, '(3859) 856-2192', 'Mon - Thu: 8:00 am - 2:00 am\nFri: 8:00 am - 5:00 am\nSat: 9:00 am - 5:00 am\nSun: 10:00 am - 12:00 am', 'Coffee\nDrinks', 'http://www.lemon.hr', 'lemon.jpg'),
(8, 'Cosmopolitan Caffe&Wine bar', 'Wine Bar', 'Bogovićeva 1, Zagreb', 45.810459, 15.971525, '', 'Mon - Sun: 8:00 am - 12:00 am', '', '', 'cosmopolitan.jpg'),
(9, 'Charlie', 'Cafe', 'Ljudevita Gaja 4, Zagreb', 45.812119, 15.976020, '', '', '', '', 'charlie.jpg'),
(10, 'Posh Fantasy Bar II', 'Nightclub', 'Teslina 7, Zagreb', 45.811810, 15.976256, '', '', '', '', 'posh.jpg');

CREATE TABLE IF NOT EXISTS `ratings` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `event_id` INT(10) NOT NULL,
  `user_id` INT(10) NOT NULL,
  `username` VARCHAR(32) NOT NULL,
  `rating` INT(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=30 ;

INSERT INTO `ratings` (`id`, `event_id`, `user_id`, `username`, `rating`) VALUES
(1, 1, 1, 'pero', 1),
(2, 2, 2, 'muka', 2),
(3, 3, 3, 'ana', 3),
(4, 4, 4, 'bogdan', 4),
(5, 5, 5, 'cero', 5),
(6, 6, 6, 'dino', 1),
(7, 7, 7, 'emre', 2),
(8, 8, 8, 'fico', 3),
(9, 9, 9, 'gabor', 4),
(10, 10, 10, 'haso', 5),
(11, 10, 1, 'pero', 1),
(12, 9, 2, 'muka', 2),
(13, 8, 3, 'ana', 3),
(14, 7, 4, 'bogdan', 4),
(15, 6, 5, 'cero', 5),
(16, 5, 6, 'dino', 1),
(17, 4, 7, 'emre', 2),
(18, 3, 8, 'fico', 3),
(19, 2, 9, 'gabor', 4),
(20, 1, 10, 'haso', 5),
(21, 9, 1, 'pero', 1),
(22, 8, 2, 'muka', 2),
(23, 7, 3, 'ana', 3),
(24, 6, 4, 'bogdan', 4),
(25, 5, 5, 'cero', 5),
(26, 4, 6, 'dino', 1),
(27, 3, 7, 'emre', 2),
(28, 2, 8, 'fico', 3),
(29, 1, 9, 'gabor', 4);

CREATE TABLE IF NOT EXISTS `users` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32)  NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=11 ;


INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'pero', 'peric'),
(2, 'muka', 'mukic'),
(3, 'ana', 'anic'),
(4, 'bogdan', 'bogdanovic'),
(5, 'cero', 'ceric'),
(6, 'dino', 'dinic'),
(7, 'emre', 'emric'),
(8, 'fico', 'fukic'),
(9, 'gabor', 'gabric'),
(10, 'haso', 'hasic');

CREATE TABLE IF NOT EXISTS `interests` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(32)  NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ;


INSERT INTO `interests` (`id`, `name`) VALUES
(1, 'Comedy'),
(2, 'Concert'),
(3, 'Dancers'),
(4, 'DJ'),
(5, 'Festival'),
(6, 'Foam party'),
(7, 'Food'),
(8, 'Free'),
(9, 'Happy Hour'),
(10, 'Hostesses'),
(11, 'Live Music'),
(12, 'Striptease');

CREATE TABLE IF NOT EXISTS `location_interests` (
  `location_id` INT(20) NOT NULL ,
 `interest_id` INT(20) NOT NULL,
  PRIMARY KEY (`location_id`, `interest_id`)
) ENGINE=INNODB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ;

INSERT INTO `location_interests` (`location_id`, `interest_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12);