 use your_space;
 drop table if exists space;
  create table space (
       space_id integer not null auto_increment,
        address varchar(255),
        contact_no varchar(255),
        description varchar(255),
        district varchar(255),
        offers_drinks bit,
        max_opening_hours varchar(255),
        images varchar(255),
        max_price double precision,
        min_price double precision,
        name varchar(255),
        outdoors bit,
        owner varchar(255),
        rating double precision,
        room_numbers integer,
        min_opening_hours varchar(255),
        primary key (space_id)
    ) engine=InnoDB