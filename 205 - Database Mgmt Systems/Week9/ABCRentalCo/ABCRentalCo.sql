drop database ABCRentalCo;

create database ABCRentalCo;

use ABCRentalCo;

Create table Renter
(
    Renter_ID     int auto_increment,
    First_Name   varchar (70),
    Last_Name varchar(70),
    Mid_Init varchar(2),
    Street_Address varchar(20), 
    City varchar(75),
    State varchar(2),
    ZipCode varchar(10),
    Email varchar(75),
    Primary_Phone   varchar (20),
   constraint renter_PK primary key (Renter_ID)
);

Create table Lease
(
    Lease_ID      int auto_increment,
    Begin_Date  date NOT NULL,
    End_Date    date NOT NULL,
    Rental_Amount    int,
  constraint lease_PK primary key (Lease_ID)
);

Create table Property
(
    Property_ID    int auto_increment,
    Street_Address varchar(20), 
    City varchar(75),
    State varchar(2),
    ZipCode varchar(10),
    No_Rooms int,
    Base_Rate Numeric(7,2),
    Property_Type   varchar (20),
   constraint property_PK primary key (Property_ID)
);

Create table Rental
(
   Renter_ID     int,
   Lease_ID      int,
   ActivityDate timestamp default current_timestamp,
 constraint rental_PK primary key (Renter_ID),
 constraint rental_FK1 foreign key(Lease_ID) references Lease (Lease_ID),
 constraint rental_FK2 foreign key(Renter_ID) references Renter (Renter_ID)
);


Create table Booking
(
 
   Lease_ID      int,
   Property_ID    int,
   ActivityDate timestamp default current_timestamp,
 constraint booking_PK primary key (Lease_ID),
 constraint booking_FK1 foreign key(Lease_ID) references Lease (Lease_ID),
 constraint booking_FK2 foreign key(Property_ID) references Property (Property_ID)
);
