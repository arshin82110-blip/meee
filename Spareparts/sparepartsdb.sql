-- Create Database
CREATE DATABASE IF NOT EXISTS sparepartsdb;

-- Use Database
USE sparepartsdb;

-- Create Table
CREATE TABLE spare_parts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    part_name VARCHAR(100),
    part_number VARCHAR(50),
    price DECIMAL(10,2),
    quantity INT
);

-- Insert Sample Data
INSERT INTO spare_parts (part_name, part_number, price, quantity)
VALUES
('Brake Pad', 'BP101', 1500.00, 10),
('Clutch Plate', 'CP202', 3500.00, 5);

-- Show Data
SELECT * FROM spare_parts;