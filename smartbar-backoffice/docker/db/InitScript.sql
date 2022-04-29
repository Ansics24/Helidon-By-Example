-- Creating a sequence
create sequence smartbar_sequence increment 50 minvalue 100 start 100;

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

-- Creating articles

create table articles (
    id bigint not null primary key,
    name varchar(30) not null,
    price numeric not null,
    category_id bigint not null
);

alter table articles add constraint categories_fkc foreign key (category_id) references categories;

insert into articles values (10, 'Cola', 2.5, 5);
insert into articles values (11, 'Fanta', 2.5, 5);
insert into articles values (12, 'Vegetarian pasta', 5.0, 2);
insert into articles values (13, 'Pizza margharita', 4.5, 2);
insert into articles values (14, 'White russian', 4.5, 8);
insert into articles values (15, 'Pina colada', 4.5, 8);