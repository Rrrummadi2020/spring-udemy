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

-- custom table authority
create table members(
	user_id varchar(40) not null,
    pw varchar(68) not null,
    primary key(user_id)
);

alter table members add column active tinyint not null;

create table roles (
		user_id varchar(40) not null,
        role varchar(40) not null,
        constraint username_k1 unique(user_id,role),
        foreign key (user_id) references members(user_id)
    );

insert into members values('mememployee','{noop}testemp',1),('memmanager','{noop}testman',1),('memadmin','{noop}testadm',1);

insert into roles values('mememployee','ROLE_EMPLOYEE'),('memmanager','ROLE_MANAGER'),('memadmin','ROLE_ADMIN');

SELECT user_id, pw,active FROM members WHERE user_id='memadmin';

SELECT user_id,role FROM roles WHERE user_id='memadmin';