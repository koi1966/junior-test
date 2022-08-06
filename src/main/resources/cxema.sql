CREATE TABLE TBL_EMPLOYEES (
                               id INT AUTO_INCREMENT  PRIMARY KEY,
                               first_name VARCHAR(250) NOT NULL,
                               last_name VARCHAR(250) NOT NULL,
                               email VARCHAR(250) DEFAULT NULL
);
create table if not exists article2
(
    id      bigint generated by default as identity
    primary key,
    color   varchar(255),
    text    varchar(255),
    user_id bigint not null
    constraint fk15yy37u1qw43hjduyhs3bgomr
    references users
    );

create table if not exists users
(
    id         bigint generated by default as identity
    primary key,
    age        integer not null,
    name       varchar(255),
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255),
    role       varchar(255),
    status     varchar(255)
    );