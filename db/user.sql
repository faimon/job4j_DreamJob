CREATE TABLE users (
    id serial primary key,
    name TEXT,
    email TEXT UNIQUE,
    password TEXT
);