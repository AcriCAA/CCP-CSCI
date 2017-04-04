-- Select all rows and attributes (columns) from the 
-- customer table and alias customer as 'c'.

select *  from customer c;


-- select all customers for address labels. Limit attributes to 
-- company name, contact, address and city state and zip create one line for each.

select cust_name addr_line1
	,cust_contact addr_line2
	,cust_address addr_line3
	,concat(cust_city, ', ', cust_state, ' ', cust_zip) addr_line4 
  from customer c;

  
-- Select contact name and email address format as “name”<emailaddress>

select concat('"',cust_contact,'"<',cust_email,'>') 
  from customer c 
 where cust_email is not null;

 
-- select customer name from customer and order date from orders 
-- inner join the required tables 
-- with the where clause.

select c.cust_name name, o.order_date
  from customer c, orders o
 where c.cust_id = o.cust_id; 

 

  
 -- select customer names that have made a purchase using the exists phrase

 select c.cust_name name
  from customer c
 where exists (select 'x' from orders o where c.cust_id = o.cust_id); 

  -- select customer names that have made a purchase using the IN statement
 
 select c.cust_name name
  from customer c
  where c.cust_id IN (select cust_id from orders);  
 
-- select customers names that have not made a purchase using the exists clause

 select c.cust_name name
  from customer c
 where not exists (select 'x' from orders o where c.cust_id = o.cust_id); 

 
 
 
-- select customer name, order date, and total (quantity * item price).  
-- Requires inner joining three 
-- tables.		

		-- First look at all the attributes			
		select *
		  from customer c, orders o, orderitem oi
		 where c.cust_id = o.cust_id
		   and o.order_num = oi.order_num; 

select cust_name, order_date, quantity * item_price total
  from customer c, orders o, orderitem oi
 where c.cust_id = o.cust_id
   and o.order_num = oi.order_num; 

   
-- select customer name, order date, and total (quantity * item price).  
-- Requires inner joining three 
-- tables.	Orders the results by the total greatest to the least.

select cust_name, order_date, quantity * item_price total
  from customer c, orders o, orderitem oi
 where c.cust_id = o.cust_id
   and o.order_num = oi.order_num
  order by total desc;

  
-- select customer name, order date,  total (quantity * item price) 
-- and product name.  Requires inner joining four tables.  
-- Orders the results by the total greatest to the least.

select cust_name, order_date, quantity * item_price total, prod_name
  from customer c, orders o, orderitem oi, product p
 where c.cust_id = o.cust_id
   and o.order_num = oi.order_num
   and oi.prod_id = p.prod_id
  order by total desc;  
  

-- The next select add Vendor Name and the vendor table.

select cust_name, order_date, quantity * item_price total, prod_name, vend_name
  from customer c, orders o, orderitem oi, product p, vendor v
 where c.cust_id = o.cust_id
   and o.order_num = oi.order_num
   and oi.prod_id = p.prod_id
   and p.vend_id = v.vend_id
  order by total desc;    
  
-- This select illustrates that although you are retuning only 
-- two items you still need to follow the 
-- entity relationships. 

select cust_name, vend_name
  from customer c, orders o, orderitem oi, product p, vendor v
 where c.cust_id = o.cust_id
   and o.order_num = oi.order_num
   and oi.prod_id = p.prod_id
   and p.vend_id = v.vend_id;  

   
select DISTINCT cust_name, vend_name
  from customer c, orders o, orderitem oi, product p, vendor v
 where c.cust_id = o.cust_id
   and o.order_num = oi.order_num
   and oi.prod_id = p.prod_id
   and p.vend_id = v.vend_id;     
   
-- select using sum and group by

 select sum(quantity * item_price) total
  from orderitem;
  
select cust_name, sum(quantity * item_price) total
  from customer c, orders o, orderitem oi
 where c.cust_id = o.cust_id
   and o.order_num = oi.order_num
  group by cust_name
  order by total desc;
  
  
select cust_name, sum(quantity * item_price) total
  from customer c, orders o, orderitem oi
 where c.cust_id = o.cust_id
   and o.order_num = oi.order_num
  group by cust_name
  having sum(quantity * item_price) > 150
  order by total desc;  
  
  -- select cust_id from orders and all columns from orderitem

select cust_id, orderitem.*
  from orders, orderitem
 where orders.order_num = orderitem.order_num;
 
 -- using a virtual table (sub query) as a table in a select
 select cust_name, quantity, item_price
   from customer c, (select cust_id, orderitem.* from orders, orderitem
			 			where orders.order_num = orderitem.order_num) o
  where c.cust_id = o.cust_id;
