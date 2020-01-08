--Sometimes, we want to create multiple schemas to separate or
--group certain tables, sequences, etc. together.
create schema super_pets;

--In order to switch to that schema so that we may begin working
--on it, we must:
set search_path to super_pets;