create table instructor_detail(
    id int not null auto_increment, 
    youtube_channel varchar(45) not null,
    hobbies varchar(45) default null,
    primary key (id)
);

create table instructor (
	id int not null auto_increment,
    name varchar(45) not null,
    email varchar(45) not null,
    instructor_detail_id int default null,
    constraint fk_instructor foreign key (instructor_detail_id) references instructor_detail(id),
    primary key(id)
);

CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `instructor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_title` (`title`),
  KEY `fk_istructor` (`instructor_id`),
  CONSTRAINT `fk_istructor` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
