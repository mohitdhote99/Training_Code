CREATE TABLE shoppingCart
(
id Long
country_code varchar(2),
currency varchar(3),
created DATE,
updated DATE,
PRIMARY KEY (id)
);

CREATE TABLE Products
(
id uuid,
description VARCHAR(100),
category VARCHAR(50),
price double,
created DATE,
updated DATE,
PRIMARY KEY (id)
);