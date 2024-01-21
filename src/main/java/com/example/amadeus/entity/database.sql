CREATE TABLE airport (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         city VARCHAR(255)
);
CREATE TABLE flight (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        departure_airport_id BIGINT,
                        arrival_airport_id BIGINT,
                        departure_date_time DATETIME,
                        return_date_time DATETIME,
                        price DOUBLE,
                        FOREIGN KEY (departure_airport_id) REFERENCES airport (id),
                        FOREIGN KEY (arrival_airport_id) REFERENCES airport (id)
);