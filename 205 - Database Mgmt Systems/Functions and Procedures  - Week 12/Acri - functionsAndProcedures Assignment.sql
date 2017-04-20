-- Change the delimiter to create a stored function (counts rooms by house id)

delimiter |
create function f_add20 (numIn int)
      returns int
  begin
   declare num int;
   select numIn + 20 into num; 
   return num;
  end |
delimiter ;

-- Use the function created above 
select f_add20(1) from dual;


-- Create a stored procedure to return the count of rooms by House_Id

delimiter //
create procedure 
  p_add2Numbers ( in numberOne int, in numberTwo int, out numberOut int)
begin
select numberOne + numberTwo
  into numberOut; 
end //
delimiter ;

-- run the stored procedure and store the results in variable @crooms
call p_add2Numbers (1,3,@mySum);
select @mySum;