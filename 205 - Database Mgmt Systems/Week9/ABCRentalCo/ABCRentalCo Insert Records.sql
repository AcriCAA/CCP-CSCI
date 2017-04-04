
insert into Renter (First_Name, Last_Name, Mid_Init, Street_Address, City, State, ZipCode, Email, Primary_Phone) values ('Mister', 'Smithy', 'A', '123 Main Street','Philadelphia', 'PA', '11231','a@b.com', '555.555.5555');
insert into Renter (First_Name, Last_Name, Mid_Init, Street_Address, City, State, ZipCode, Email, Primary_Phone) values ('Mister', 'Smithe', 'B', '124 Main Street','Philadelphia', 'PA', '11231','a@c.com', '555.555.5556');
insert into Renter (First_Name, Last_Name, Mid_Init, Street_Address, City, State, ZipCode, Email, Primary_Phone) values ('Misses', 'Smithy', 'C', '125 Main Street','Philadelphia', 'PA', '11231','a@d.com', '555.555.5557');
insert into Renter (First_Name, Last_Name, Mid_Init, Street_Address, City, State, ZipCode, Email, Primary_Phone) values ('Mister', 'Smitha', 'D', '126 Main Street','Philadelphia', 'PA', '11231','a@e.com', '555.555.5558');
insert into Renter (First_Name, Last_Name, Mid_Init, Street_Address, City, State, ZipCode, Email, Primary_Phone) values ('Mister', 'Smithi', 'E', '127 Main Street','Philadelphia', 'PA', '11231','a@f.com', '555.555.5559');

insert into Lease (Begin_Date,End_Date,Rental_Amount) values ('2014-11-22','2015-11-22',1000);
insert into Lease (Begin_Date,End_Date,Rental_Amount) values ('2015-11-22','2016-11-22',1002);
insert into Lease (Begin_Date,End_Date,Rental_Amount) values ('2014-11-23','2015-11-25',1003);
insert into Lease (Begin_Date,End_Date,Rental_Amount) values ('2011-11-22','2016-11-22',1004);
insert into Lease (Begin_Date,End_Date,Rental_Amount) values ('2011-11-22','2013-11-22',1005);

insert into Property (Street_Address, City, State, ZipCode, No_Rooms, Base_Rate, Property_Type) values ('123 Main Street','Philadelphia', 'PA', '11231',1, 100.40, 'Standard');
insert into Property (Street_Address, City, State, ZipCode, No_Rooms, Base_Rate, Property_Type) values ('121 Main Street','Philadelphia', 'PA', '11231',1, 101.40, 'Standardish');
insert into Property (Street_Address, City, State, ZipCode, No_Rooms, Base_Rate, Property_Type) values ('125 Main Street','Philadelphia', 'PA', '11231',5, 122.40, 'Deluxe');
insert into Property (Street_Address, City, State, ZipCode, No_Rooms, Base_Rate, Property_Type) values ('15 Main Street','Philadelphia', 'PA', '11231',3, 122.40, 'Deluxe');
insert into Property (Street_Address, City, State, ZipCode, No_Rooms, Base_Rate, Property_Type) values ('12 Main Street','Philadelphia', 'PA', '11231',2, 1.40, 'Gross');


insert into Rental (Renter_ID,Lease_ID) values (1,1);
insert into Rental (Renter_ID,Lease_ID) values (2,2);
insert into Rental (Renter_ID,Lease_ID) values (3,3);
insert into Rental (Renter_ID,Lease_ID) values (4,4);
insert into Rental (Renter_ID,Lease_ID) values (5,5);



insert into Booking (Lease_ID, Property_ID) values (1,1);
insert into Booking (Lease_ID, Property_ID) values (2,2);
insert into Booking (Lease_ID, Property_ID) values (3,3);
insert into Booking (Lease_ID, Property_ID) values (4,4);
insert into Booking (Lease_ID, Property_ID) values (5,5);	
