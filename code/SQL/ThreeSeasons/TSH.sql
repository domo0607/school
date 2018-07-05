CREATE DATABASE TSH;
USE TSH;
-- clean database 

DROP TABLE Booking;
DROP TABLE Guest;
DROP TABLE Room;

-- CREATE TABLEs 

CREATE TABLE Room(
    RoomID INT AUTO_INCREMENT
    ,RoomNumber INT 
    ,Floor INT
    ,Cost INT
    ,Occupancy INT
    ,Ensuite BOOL
    ,Minibar BOOL
    ,Jacuzzi BOOL
    ,SeaView BOOL
    ,Honeymoon BOOL
    ,Family BOOL
    ,NumBeds INT
    ,PRIMARY KEY (RoomID)
    
);
CREATE TABLE Guest(
    GuestID INT AUTO_INCREMENT 
    ,Surname VARCHAR(255)
    ,Firstname VARCHAR(255)
    ,DOB DATE 
    ,HouseNum INT
    ,StreetName VARCHAR(255)
    ,Postcode VARCHAR(7)
    ,Mobile INT
    ,Email VARCHAR(225)
    ,Gender VARCHAR(255)
    ,CardNumber BIGINT 
    
    PRIMARY KEY (GuestID)
);

CREATE TABLE Booking(
    BookingID INT AUTO_INCREMENT
    ,RoomID INT
    ,GuestID INT
    ,ETA DATE
    ,ETD DATE
    ,DateBooked DATE
    
    ,PRIMARY KEY (BookingID)
    ,FOREIGN KEY (RoomID) REFERENCES Room(RoomID)
    ,FOREIGN KEY (GuestID) REFERENCES Guest(GuestID)
);

explain Booking;

LOAD DATA LOCAL INFILE '/home/ubuntu/workspace/code/SQL/ThreeSeasons/Room.csv'
INTO TABLE Room
FIELDS TERMINATED BY ''
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

LOAD DATA LOCAL INFILE '/home/ubuntu/workspace/code/SQL/ThreeSeasons/Guest.csv'
INTO TABLE Guest
FIELDS TERMINATED BY ''
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

LOAD DATA LOCAL INFILE '/home/ubuntu/workspace/code/SQL/ThreeSeasons/Booking.csv'
INTO TABLE Booking
FIELDS TERMINATED BY ''
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;


