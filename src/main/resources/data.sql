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
                            insurance_id INT NOT NULL);

INSERT INTO INSURANCE (insured_sum, start_date, end_date,
                       reality_type, build_year, square)
                       VALUES (20, sysdate(), sysdate(), 'дом', 2015, 30);

INSERT INTO CONTRACT (date, insurance_id) VALUES (sysdate(), 1);