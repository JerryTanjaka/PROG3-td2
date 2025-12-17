create database mini_dish_db;

CREATE DATABASE product_management_db;

\c mini_dish_db;

-- Création de l'utilisateur
CREATE USER --creation db
CREATE DATABASE product_management_db;

--connexion au db
\c product_management_db;

-- Création de l'utilisateur
CREATE USER mini_dish_db_manager WITH PASSWORD '123456';


--ajout privièges connection au db
GRANT CONNECT ON DATABASE product_management_db TO product_manager_user;

--ajout privilèges créations table
GRANT CREATE ON DATABASE product_management_db TO product_manager_user;

-- Attribution des privilèges à l'utilisateur
GRANT select,update,delete ON DATABASE mini_dish_db TO mini_dish_db_manager;



