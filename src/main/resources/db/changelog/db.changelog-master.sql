--liquibase formatted sql

--changeset aha:1
create table u_principal (
    id int primary key,
    username varchar(50),
    passwd varchar(50)
);
--rollback drop table u_principal;

--changeset aha:2
insert into u_principal(id, username, passwd) values (1, 'aha', '{noop}aha');
insert into u_principal(id, username, passwd) values (2, 'admin', '{noop}admin');

--changeset aha:3
create table u_role (
    id int primary key,
    user_id int,
    name varchar(50)
);
--rollback drop table u_role;

--changeset aha:4
insert into u_role(id, user_id, name) values (1, 1, 'ROLE_USER');
insert into u_role(id, user_id, name) values (2, 2, 'ROLE_DEVELOPERS');
insert into u_role(id, user_id, name) values (3, 2, 'ROLE_ADMIN');
