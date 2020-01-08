/*
 * PL/pgSQL stands for procedural language / postgres sequential
 * query language. It is essentially a "coding" language within
 * SQL (Structured Query Language) which allows you to write
 * functions and stored procedures.
 * 
 * Technically speaking, postgres doesn't have "stored procedures"
 * in the way in which we typically think of them. That said, there
 * is still a "procedure" keyword that is used within postgres.
 * 
 * Functions Vs. Stored Procedures:
 * 
 * Functions return a value, can be used in expressions/within
 * other functions and do NOT allow for transaction control.
 * 
 * Stored Procedures do not return a value, can't be used within
 * expressions, and allow for transaction control.
 */

--Let's first make our own sequences. A sequence creates a sequence
--which we can use to, for instance, keep a count. It essentially
--returns a value, that value being whatever the next value in the
--sequence happens to be. NOTE: The serial data type is just a
--convenient abstraction over a sequence.

drop sequence mySequence;
create sequence mySequence
increment by 1 --specifies how much we want to increment by
minvalue 0
maxvalue 5
start with 0001;

create table dummyTable(
dummyId numeric,
dummyName varchar);

select * from dummyTable;
insert into dummyTable values(nextval('mySequence'), 'dfksljs');

--Let's create a function now! So much fun! This function will
--take no arguments.
create or replace function increment_dummyId()
--We will return a trigger, so we'll specify that here
returns trigger as
--We must return our trigger as a string, so we will wrap it in
--dollar quotes ($$that's money$$)
$$
begin
	new.dummyId = nextval('mySequence');
	--For inserts and updates, the return type should be "new"
	return new;
end;
$$
--We must specify that this function is written in pl/pgsql:
language 'plpgsql';

--Now let's create a trigger. We will invoke the function we just
--wrote inside of it to get the trigger that it returns.

create trigger dummyId_trigger
before insert on dummyTable
for each row
execute procedure increment_dummyId();

select * from dummyTable;

insert into dummyTable values(null, 'fdjlsjf');