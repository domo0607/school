use TopTrumps;
CREATE DATABASE IF NOT EXISTS TopTrumps;
-- clean database

DROP TABLE characters;

CREATE TABLE characters (
    CharacterId INT AUTO_INCREMENT NOT NULL UNIQUE,
    Firstname VARCHAR(255),
    Surname VARCHAR(255),
    CharacterName VARCHAR(255),
    Side VARCHAR(255),
    DebutYear INT,
    Appearances INT,
    SpecialPowers INT,
    Cunning INT,
    Strength INT,
    Technology INT,
    
    PRIMARY KEY (CharacterId)
    
);
    
-- import the file characters.csv into the characters entity
LOAD DATA LOCAL INFILE '/home/ubuntu/workspace/code/SQL/TopTrumps/characters.csv'
INTO TABLE characters
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

EXPLAIN characters;

SELECT * FROM characters
WHERE  CharacterName LIKE '%g%';

SELECT * FROM characters
ORDER BY DebutYear, Strength desc;


