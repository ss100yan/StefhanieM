--Thus far, we've been USING our database admin TO perform our
--DDL AND DML. You should never, however, use this USER AS they
--have the most PRIVILEGES/power AND can therefore do a considerable
--amount OF damage IF yo were TO make a mistake. The preferred METHOD
--OF performing DDL AND DML IS TO CREATE a USER WITH fewer PRIVILEGES.

--So let's CREATE a USER:
--Note that this user by default starts with no privileges, which
--means that you must assign each privilege.
CREATE USER littleJimmy WITH password 'password';

--I'll now drop littleJimmy as a user:
--Note that in order to drop this user, he must have NO privileges.
drop user littleJimmy;

--You can grant all privileges to a user (so little Jimmy becomes
--Big Jimmy):

grant all privileges on database demodb to littleJimmy;

--Now let's revoke those privileges (as this is bad practice):

revoke all privileges on database demodb from littleJimmy;

--The best practice is to be explicit about which privileges you
--grant to a user:
--This actually allows littleJimmy to perform DDL on our schema.
grant create on schema public to littleJimmy;
--This grants littleJimmy the power to perform DML on the tables
--on the public schema.
grant update, insert, select, delete on all tables in schema public to littleJimmy;
