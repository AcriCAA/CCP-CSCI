1. Student ID, Student Name, Phone Number for students that live in Newark DE

SELECT snum, First, Last, Phone FROM Student WHERE City = "Newark" AND State = "DE";
 
2. Student ID, Student Name, Phone Number for students with grade point averages greater
than 3.0

SELECT snum, First, Last, Phone FROM Student WHERE GPA > 3.0;
 
3. Student ID, Student Name, Phone Number for students that live in NY and PA

SELECT snum, First, Last, Phone FROM Student WHERE State = "NY" OR State = "PA";
 
4. Student Name, Address, City, State and Zip Code for students that are Female and major
is CIS

SELECT First, Last, Street, City, State, Zip FROM Student WHERE Gender = "F" AND Major = "CIS";

 
5. Student ID, Student Name, Phone Number for students in zip code 19130 that are on
Scholarship

SELECT snum, First, Last, Phone FROM Student WHERE Scholarship AND Zip = "19130";