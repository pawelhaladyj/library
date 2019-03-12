create TABLE IF NOT EXISTS `reader`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(70) NOT NULL,
  `age` int(3) DEFAULT 0,
  PRIMARY KEY (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create TABLE IF NOT EXISTS `contacts`(
  `reader_id` bigint(20) NOT NULL,
  `contacts` varchar(255) DEFAULT NULL
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create TABLE IF NOT EXISTS `book`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `isbn` varchar(30) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create TABLE IF NOT EXISTS `library`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code_name` varchar(9) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create TABLE IF NOT EXISTS `department`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code_name` varchar(9) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create TABLE IF NOT EXISTS `employee`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(70) NOT NULL,
  `employee_role` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create TABLE IF NOT EXISTS `location`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `library_id` bigint(20) NOT NULL,
  `department_id` bigint(20) NOT NULL,
  `row` varchar(20) DEFAULT NULL,
  `book_case` varchar(20) DEFAULT NULL,
  `shelf` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`library_id`) REFERENCES library (`id`),
  FOREIGN KEY (`department_id`) REFERENCES department (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create TABLE IF NOT EXISTS `books_store`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) NOT NULL,
  `library_number` varchar(50) NOT NULL,
  `amount` int(6) DEFAULT 0,
  `location_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`book_id`) REFERENCES book (`id`),
  FOREIGN KEY (`location_id`) REFERENCES location (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create TABLE IF NOT EXISTS `books_assignment`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) NOT NULL,
  `reader_id` bigint(20) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  `rent_date` date NOT NULL,
  `return_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`book_id`) REFERENCES book (`id`),
  FOREIGN KEY (`reader_id`) REFERENCES reader (`id`),
  FOREIGN KEY (`employee_id`) REFERENCES employee (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;
