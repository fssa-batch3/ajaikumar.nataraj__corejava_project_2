-- Create the 'rishi_agri_market' database if it doesn't exist and switch to it
-- CREATE DATABASE IF NOT EXISTS rishi_agri_market;


SELECT * FROM project.countries;

-- CREATE SCHEMA IF NOT EXISTS rishi_agri_market;
USE rishi_agri_market;
CREATE TABLE IF NOT EXISTS user (
    id BIGINT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone_number BIGINT NOT NULL,
    district VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    address TEXT,
    dob DATE,
    pincode INT,
    gender VARCHAR(10),
    is_deleted BOOLEAN,
    is_seller BOOLEAN
);
-- Insert INTO user (email, username, password, phone_number, pincode, address, is_seller, id)
-- Values ('johndoe@gmail.com', 'John Doe', 'JohnDoe@123!', '9876543210', '678910', '10/5, ')
-- Retrieve all records from 'user' table
SELECT * FROM user;


CREATE TABLE IF NOT EXISTS seller (
    id BIGINT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    land_address TEXT,
    land_type VARCHAR(10),
	FOREIGN KEY (id) REFERENCES user(id)
);
-- Retrieve all records from 'seller' table
SELECT * FROM seller;


CREATE TABLE IF NOT EXISTS product_details (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    quantity INT NOT NULL,
    description TEXT,
    url VARCHAR(255),
    district VARCHAR(255),
    type VARCHAR(255),
    city VARCHAR(255),
    seller_id BIGINT,
    pincode INT,
    upload_date DATE,
    FOREIGN KEY (seller_id) REFERENCES seller(id)
);
-- Retrieve all records from 'product_details' table
SELECT * FROM product_details;





