create database if not exists testdb;

USE testdb;

create table testdb.operation (
    id integer auto_increment,
    op varchar(10) not null,
    number1 numeric not null,
    number2 numeric not null,
    result numeric not null,
    primary key(id)
);