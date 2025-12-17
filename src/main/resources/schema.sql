create type category_type as enum ('VEGETABLE','ANIMAL','MARINE','DAIRY','OTHER');
create type dish_type as enum ();

create table  Ingredient (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price numeric(10,2) NOT NULL,
    category category_type NOT NULL,
    id_dish INT,
    constraint fk_dish foreign key id_dish references Dish(id);
);
create table Dish (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type dish_type NOT NULL
);