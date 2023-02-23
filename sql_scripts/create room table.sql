   drop table if exists room;
   create table room (
       room_id integer not null auto_increment,
        activity varchar(255),
        image varchar(255),
        name varchar(255),
        number integer,
        price float,
        type varchar(255),
        space_id integer,
        primary key (room_id),
        foreign key(space_id) REFERENCES space(space_id) on delete cascade
    ) engine=InnoDB