--Let's start with some basic DDL. Note that we are working on the public
--schema that Postgres provides by default.

--This is how we drop a table.
drop table super_pet;
--This is how we create a table.
--Now let's return to this table and add some constraints. How about
--a primary key and a foreign key?
create table super_pet(
super_pet_id serial primary key,
super_pet_name varchar,
super_pet_color varchar,
super_pet_power varchar,
super_pet_age integer,
super_pet_owner_id integer references super_owner(super_owner_id)
);

drop table super_owner cascade; --If I wish to drop this table, I must use
--the "cascade" keyword because another table has records which
--depend on records in this table, which means that dropping this
--table would affect the referential integrity of my data.
create table super_owner(
super_owner_id serial primary key,
super_owner_name varchar,
super_home_id integer,
constraint super_home_fk foreign key (super_home_id) references super_home(super_home_id)
);

drop table super_home cascade;
create table super_home(
super_home_id serial,
super_home_town varchar,
--Let's create our constraints in a different way this time:
constraint super_home_pk primary key (super_home_id)
);

--If we want to alter our table, we must use the alter command:
alter table super_pet add column "super_pet_owner" varchar;

--Let's try our hand at some basic DML. Let's add records to a table.
insert into super_pet values(default, 'Krypto', 'White', 'Being the dog version of Superman', 4576, 1);
insert into super_pet values(default, 'Garfield', 'Orange', 'Being a sassy cat', 8, 2);
insert into super_pet values(default, 'Scooby Doo', 'Brown', 'Being a talking dog', 10, 3);
insert into super_pet values(default, 'Wonder Kitty', 'Black', 'Being the imaginary cat of Wonder Woman', 45533, 1);
insert into super_pet values(default, 'Tomcat', 'Clear', 'Being a very awesome server', 20, 3);

insert into super_owner values(default, 'Greatman');
insert into super_owner values(default, 'Curious Woman');
insert into super_owner values(default, 'Bat Guy');
insert into super_owner values(default, 'Lime Lantern');
insert into super_owner values(default, 'Alien Man');
insert into super_owner values(default, 'Jester');

--Now let's update some records:
--NOTE: Don't EVER forget your where clause.
update super_pet set super_pet_power = 'Being a sassy, orange cat' where super_pet_id = 2;

--Now let's delete a record:
delete from super_pet where super_pet_id = 2;

--This is a simple select statement. It is our DQL (but really DML).
select * from super_pet;
--You can also select specific columns.
select super_pet_name, super_pet_age from super_pet;

--Let's give our transaction control language a try:
commit;

--If we want to create a savepoint, we will have to manually begin our
--our transaction.
begin transaction;
savepoint beforeMyShenanigans;

--If I ever wish to roll back to this savepoint, I simply:
rollback to beforeMyShenanigans;

--Let's work with some scalar and aggregate functions! 

--Scalar functions allow us to mutate the data in a column (but
--not permanently).

select upper(super_pet_name) from super_pet;
select lower(super_pet_name), upper(super_pet_color) from super_pet;
select concat(super_pet_name, ' is a good boy') from super_pet;
select cos(super_pet_age) from super_pet;
select cot(super_pet_age) from super_pet;

--Aggregate functions allow us to take data from multiple rows and
--return a single value.

select sum(super_pet_age) from super_pet;
select avg(super_pet_age) from super_pet;
select stddev(super_pet_age) from super_pet;

--We can use aliases to refer to columns. This simply simplifies
--our queries by allowing us to use "nicknames" for our columns.

select super_pet_name as spn, super_pet_age as spa from super_pet;

--Sometimes, we want to see our records in a specific order. When
--we want this, we can use "order by".

select * from super_pet order by super_pet_age asc;
select * from super_pet order by super_pet_age desc;

--GROUP BY is used with aggregate functions. When using group by,
--we will get aggregate data -- but instead of just one value,
--we will get an aggregated value per each unique value in the
--column that we have grouped by.

--HAVING is used in conjunction with group by. It is "where" for
--group by -- functionally, that is.
select avg(super_pet_age), super_pet_owner_id from super_pet group by super_pet_owner_id having super_pet_owner_id > 1;


--We can also use "LIKE" if we want to take advantage of pattern
--matching:

select * from super_pet where super_pet_name like 'G%f%d';