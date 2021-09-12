CREATE SCHEMA TEST;

DROP TABLE IF EXISTS insurance;

CREATE TABLE insurance (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          insured_sum INT NOT NULL,
                          start_date date NOT NULL,
                          end_date date NOT NULL,
                          reality_type varchar(20) NOT NULL,
                          build_year varchar(4) NOT NULL,
                          square varchar(20) NOT NULL,
                          calc_date date DEFAULT NULL,
                          premium varchar(20) DEFAULT NULL);

DROP TABLE IF EXISTS contract;

CREATE TABLE contract (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            number INT AUTO_INCREMENT NOT NULL,
                            date date NOT NULL,
                            insurance_id INT NOT NULL,
                            client_id INT NOT NULL,
                            address_id INT NOT NULL);

CREATE TABLE client (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          first_name varchar(20) NOT NULL,
                          second_name varchar(20) NOT NULL,
                          last_name varchar(20) NOT NULL,
                          birth_date date NOT NULL,
                          pasport_series INT NOT NULL,
                          pasport_number INT NOT NULL);

CREATE TABLE realty_address (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        address varchar(200) NOT NULL);

INSERT INTO INSURANCE (insured_sum, start_date, end_date,
                       reality_type, build_year, square)
                       VALUES (20, sysdate(), sysdate(), 'дом', 2015, 30);

INSERT INTO CLIENT (first_name, last_name, second_name, birth_date, pasport_number, pasport_series)
VALUES ('fr','fr','fr', sysdate(), 12313, 2015);

INSERT INTO CONTRACT (date, insurance_id) VALUES (sysdate(), 1);