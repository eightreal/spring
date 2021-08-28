show databases ;
use spring_learn;
create table  IF NOT EXISTS user
(
    name     varchar(100) not null,
    password varchar(40)  not null,
    phone    varchar(11)  not null,
    primary key(phone),
    constraint user_phone_uindex
        unique (phone)
)

charset = utf8;