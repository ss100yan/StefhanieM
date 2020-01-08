select * from super_pet;
select * from super_owner;
select * from super_home;
select * from super_dwelling;

--Let's play around with some joins and set operators.

--inner join
select * from super_pet 
inner join super_owner 
on super_pet_owner_id = super_owner_id;

--full join
select * from super_pet
full join super_owner
on super_pet_owner_id = super_owner_id;

--left join

select * from super_pet
left join super_owner 
on super_pet_owner_id = super_owner_id;

--right join

select * from super_pet
right join super_owner
on super_pet_owner_id = super_owner_id;

--cross join (blegh)
select * from super_pet cross join super_owner;

--Let's play around with our set operators:

select * from super_home;
select * from super_dwelling;

--union

(select * from super_home) union (select * from super_dwelling);

--union all

(select * from super_home) union all (select * from super_dwelling);

--intersect

(select * from super_home) intersect (select * from super_dwelling);

--except

(select * from super_home) except (select * from super_dwelling);







insert into super_home values(default, 'Ballet Town');
insert into super_home values(default, 'Superb Home');
insert into super_home values(default, 'Bell Air');

insert into super_dwelling values(default, 'Ballet Town');
insert into super_dwelling values(default, 'Superb Home');
insert into super_dwelling values(default, 'Bell Air');
insert into super_dwelling values(default, 'Dantes Inferno');
insert into super_dwelling values(default, 'Faustus');
