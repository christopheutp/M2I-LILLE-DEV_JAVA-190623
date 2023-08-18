-- Table Client
CREATE TABLE customer(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    phone VARCHAR(10)
);


-- TAble CompteBancaire
CREATE TABLE bank_account(
    id SERIAL PRIMARY KEY,
    total_amount DECIMAL(15,2) NOT NULL,
    customer_id INT REFERENCES customer(id)
);

-- Table Operation
CREATE TABLE operation(
    id SERIAL PRIMARY KEY,
    amount DECIMAL(15,2) NOT NULL,
    status VARCHAR(10) NOT NULL,
    account_id INT REFERENCES bank_account(id)
);