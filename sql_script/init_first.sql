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

