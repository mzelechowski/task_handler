# CREATE DATABASE taskshandler;
DROP TABLE if exists tasks;
CREATE TABLE if not exists tasks (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL,
                       start_date DATETIME,
                       end_date DATETIME,
                       breaklength DOUBLE,
                       completed BOOLEAN NOT NULL,
                       again BOOLEAN
);

insert into tasks(name, breaklength, start_date, end_date, completed, again)
values ('podnoszenie ciężarów co 1h', '60', NUll, NULL, false, true),
                ('Szklanka wody co 1h', '60', NUll, NULL, false, true),
                ('Witaminy', '60', NUll, NULL, false, true),
                ('15m 4 English', '240', NUll, NULL, false, true);
