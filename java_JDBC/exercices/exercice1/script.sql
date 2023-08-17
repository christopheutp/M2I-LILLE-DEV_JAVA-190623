-- Creation de la table student en BDD PostgreSQL



CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    date_degree DATE,
    class_number INT
);