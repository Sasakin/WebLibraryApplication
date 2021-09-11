CREATE SCHEMA TEST;

DROP TABLE IF EXISTS contract;

CREATE TABLE contract (
                            id INT AUTO_INCREMENT  PRIMARY KEY,
                            number int(11) NOT NULL,
                            date date DEFAULT NULL);

INSERT INTO CONTRACT (NUMBER, DATE) VALUES (1, sysdate());