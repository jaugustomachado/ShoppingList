CREATE DATABASE IF NOT EXISTS items_database;

CREATE TABLE IF NOT EXISTS items_database.items (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    item VARCHAR(100) NOT NULL,
    classification VARCHAR(20) NOT NULL,
    CONSTRAINT PRIMARY KEY (id),
    CONSTRAINT UNIQUE_item UNIQUE KEY (item)
    );
    
INSERT INTO `items_database`.`items` ( `item`, `classification`) VALUES ('book', 'book');
INSERT INTO `items_database`.`items` ( `item`, `classification`) VALUES ('chocolate bar', 'food');
INSERT INTO `items_database`.`items` ( `item`, `classification`) VALUES ('imported box of chocolates', 'food');
INSERT INTO `items_database`.`items` ( `item`, `classification`) VALUES ('packet of headache pills', 'medical products');


SELECT * FROM items_database.items;

DROP TABLE items_database.items;
DROP SCHEMA items_database;