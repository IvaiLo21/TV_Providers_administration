DROP DATABASE IF EXISTS TV_Provider_administration;
CREATE DATABASE TV_Provider_administration;
USE TV_Provider_administration;

CREATE TABLE providers (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name_of_provider VARCHAR(255) NOT NULL,
    service_cost DOUBLE,
    contract_number VARCHAR(12) NOT NULL UNIQUE,
    contract_expiry DATE NOT NULL
);

CREATE TABLE customers (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);

CREATE TABLE channels (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name_of_channel VARCHAR(255) NOT NULL,
    channel_cost DOUBLE
);

CREATE TABLE channel_package (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    channel_category ENUM('terrestrial', 'sports', 'sci-fi', 'films', 'music', 'for children', 'others'),
    channel_package_cost DOUBLE,
    
    channel_package_id INT NOT NULL UNIQUE,
    CONSTRAINT FOREIGN KEY (channel_package_id)
        REFERENCES channels (id),
        
   UNIQUE KEY (channel_package_id , channel_category , channel_package_cost)
);

CREATE TABLE contracts (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    contract_package INT(7) NOT NULL default 0,
    
    provider_contract INT NOT NULL,
    CONSTRAINT FOREIGN KEY (provider_contract)
        REFERENCES providers (id),
        
    customer_contract INT NOT NULL,
    CONSTRAINT FOREIGN KEY (customer_contract)
        REFERENCES customers (id),
        
    channel_contract INT NOT NULL,
    CONSTRAINT FOREIGN KEY (channel_contract)
        REFERENCES channels (id)
);

CREATE TABLE taxes (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    monthly_paid DOUBLE,
    
    customer_taxes INT NOT NULL,
    CONSTRAINT FOREIGN KEY (customer_taxes)
        REFERENCES customers (id),
        
    UNIQUE KEY (monthly_paid , customer_taxes)
);