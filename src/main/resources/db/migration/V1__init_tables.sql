drop table if exists book;
create table book(
    id bigint auto_increment primary key,
    book_name varchar(255) not null
);

create table course(
    id bigint auto_increment primary key,
    name varchar(255) not null,
    department varchar(255) not null
);

create table student(
    id bigint auto_increment primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) not null,
    age int not null
);



