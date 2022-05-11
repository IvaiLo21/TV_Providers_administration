DROP DATABASE IF EXISTS TV_Provider_administration;
CREATE DATABASE TV_Provider_administration;
USE TV_Provider_administration;

CREATE TABLE providers (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    
    name_of_provider VARCHAR(255) UNIQUE NOT NULL,
    
    provider_pass INT(8) UNIQUE DEFAULT NULL,
    
    service_cost DOUBLE,
    
    service_contract_number VARCHAR(15) NOT NULL UNIQUE,
    
    service_contract_expiry DATE
);

CREATE TABLE customers (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    
    customer_name VARCHAR(255) UNIQUE NOT NULL,
    
    customer_pass INT(12) UNIQUE DEFAULT NULL,
    
    address VARCHAR(255) DEFAULT NULL
);

CREATE TABLE channel_package (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    
    channel_category ENUM('terrestrial', 'sports', 'sci-fi', 'films', 'music', 'for children', 'others'),
    
    channel_combo INT(7) DEFAULT 0
);

CREATE TABLE channels (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    
    name_of_channel VARCHAR(255) NOT NULL,
    
    channel_cost DOUBLE,
    
    provider_contract_id INT NOT NULL,
    CONSTRAINT FOREIGN KEY (provider_contract_id)
        REFERENCES providers (id),
    
    package_id INT NOT NULL UNIQUE,
    CONSTRAINT FOREIGN KEY (package_id)
        REFERENCES channel_package (id)
);

CREATE TABLE contracts (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    
    customer_contract_package ENUM('1-pack', '2-pack', '3-pack', '4-pack', '5-pack', '6-pack', '7-pack'),
    
    customer_contract_number VARCHAR(15) NOT NULL UNIQUE,
    
    customer_contract_expiry DATE,
        
    customer_contract_id INT NOT NULL ,
    CONSTRAINT FOREIGN KEY (customer_contract_id)
        REFERENCES customers (id),
        
	channel_package_id INT NOT NULL ,
    CONSTRAINT FOREIGN KEY (channel_package_id)
		REFERENCES channel_package (id)
);

CREATE TABLE taxes (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    monthly_paid DOUBLE ,
    
    contract_taxes_id INT NOT NULL,
    CONSTRAINT FOREIGN KEY (contract_taxes_id)
        REFERENCES contracts (id)
);