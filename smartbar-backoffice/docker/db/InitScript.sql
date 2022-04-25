-- Creating categories

create table categories(
    id bigint not null primary key,
    name varchar(30) not null unique
);

insert into categories values (1, 'Dishes with meat');
insert into categories values (2, 'Dishes without meat');
insert into categories values (3, 'Starter');
insert into categories values (4, 'Breakfast');
insert into categories values (5, 'Softdrinks');
insert into categories values (6, 'Beer');
insert into categories values (7, 'Wine');
insert into categories values (8, 'Cocktails');