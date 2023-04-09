create database rental;

use rental;

CREATE TABLE venue(
venue_id VARCHAR(10) PRIMARY KEY NOT NULL,
name VARCHAR(20) NOT NULL
);

CREATE TABLE client(
client_id VARCHAR(20) PRIMARY KEY NOT NULL,
password VARCHAR(20) NOT NULL,
name VARCHAR(5) NOT NULL,
date_time TIMESTAMP DEFAULT current_timestamp
);

CREATE TABLE vehicle(
vehicle_id VARCHAR(10) PRIMARY KEY NOT NULL,
name VARCHAR(20) NOT NULL,
venue_id VARCHAR(10) NOT NULL,
date_time TIMESTAMP DEFAULT current_timestamp,
check_rev INT NOT NULL,
FOREIGN KEY(venue_id) REFERENCES venue(venue_id)
);

CREATE TABLE booking(
vehicle_id VARCHAR(10) NOT NULL, 
client_id VARCHAR(20) NOT NULL,
venue_id VARCHAR(10) NOT NULL,
operation_date TIMESTAMP NOT NULL,
hour INT(4) NOT NULL,
total_payment INT(10) NOT NULL,
regist_date TIMESTAMP DEFAULT current_timestamp,
reservation_number VARCHAR(20) PRIMARY KEY NOT NULL,
FOREIGN KEY(vehicle_id) REFERENCES vehicle(vehicle_id),
FOREIGN KEY(client_id) REFERENCES client(client_id),
FOREIGN KEY(venue_id) REFERENCES venue(venue_id)
);

CREATE TABLE board(
postno VARCHAR(20) NOT NULL PRIMARY KEY,
client_id VARCHAR(20) NOT NULL,
title VARCHAR(40) NOT NULL,
content VARCHAR(1000),
modified_date TIMESTAMP,
date_time TIMESTAMP DEFAULT current_timestamp,
FOREIGN KEY(client_id) REFERENCES client(client_id) 
);
