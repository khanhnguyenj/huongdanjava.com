CREATE DATABASE IF NOT EXISTS example;

USE example;

CREATE TABLE account ( id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(45) NOT NULL, amount DECIMAL );

INSERT INTO account set name='A', amount=30;
INSERT INTO account set name='B', amount=20;