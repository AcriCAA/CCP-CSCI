-- select customer name from customer and order date from orders 
-- inner join the required tables 
-- with the inner join clause.

 select c.cust_name name, o.order_date
  from customer c inner 
  join orders o on c.cust_id = o.cust_id; 

 select c.cust_name name, o.order_date
  from customer c inner 
  join orders o using (cust_id); 

 select c.cust_name name, o.order_date
  from customer c  
  left join orders o on c.cust_id = o.cust_id; 
  
  select vend_name, prod_name
     from product right join vendor using (vend_id);  
  
 -- select customer name from customer and order date from orders 
 -- inner join the required tables 
 -- with the natural join clause.  Assumes liked named field are related across tables.

  select c.cust_name name, o.order_date
    from customer c 
      natural join orders o;
  
 -- select customer names that have made a purchase using the exists phrase

 select c.cust_name name
  from customer c
 where exists (select 'x' from orders o where c.cust_id = o.cust_id); 
 
-- select customers names that have not made a purchase using the exists clause

 select c.cust_name name
  from customer c
 where not exists (select 'x' from orders o where c.cust_id = o.cust_id); 
  
-- select customer name, order date,  total (quantity * item price) 
-- and product name.  Requires inner joining four tables.  
-- Orders the results by the total greatest to the least.

select cust_name, order_date, quantity * item_price total, prod_name
  from customer c natural join  orders o natural join orderitem oi natural join product p
  order by total desc;  

 -- Same as the select above except it uses natural joins

select distinct cust_name, vend_name
  from customer 
   natural join orders 
   natural join orderitem 
   natural join product 
   natural join vendor   
 order by cust_name;    

