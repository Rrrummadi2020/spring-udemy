drop table if exists employee;

CREATE TABLE `employee` (
  `id` int NOT NULL,
  `first_name` varchar(200) DEFAULT NULL,
  `last_name` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP table if exists users;

CREATE TABLE users (
username varchar(40) not null,
password varchar(68) not null,
enabled tinyint not null,
primary key (username)
);


DROP table if exists authorities;

create table authorities (
	username varchar(40) not null,
    authority varchar(40) not null,
    unique key username_k1  (username,authority),
    constraint userautho_fbk1 foreign key (username) references users(username)
);


insert into users values('rama','{noop}testram',1),('renuka','{noop}testren',1),('rajeshwari','{noop}testraj',1);

insert into authorities values('rama','ROLE_EMPLOYEE'),('renuka','ROLE_MANAGER'),('rajeshwari','ROLE_ADMIN');

