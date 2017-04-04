#Update - Write a SQL Update to change customer 10011.  New Name is ‘ Technology Inc.’, New Address is ‘111 Franklin St, Philadelphia, PA 19130’

SELECT Cust_name name FROM customer WHERE Cust_id = '10011'; 

UPDATE customer 
SET Cust_name = 'Technology Inc.', 
Cust_address = '111 Franklin St.', 
Cust_city = 'Philadelphia', 
Cust_State = 'PA', 
Cust_zip = '19130' 
WHERE Cust_id = '10011'; 

SELECT * FROM customer WHERE Cust_id = '10011'; 


# DELETE Write a SQL Delete to remove customer 10010.

SELECT * FROM customer WHERE Cust_id = '10011';

DELETE FROM customer WHERE Cust_id = '10011';

SELECT * FROM customer WHERE Cust_id = '10011';


# MAX, MIN, Average - Write 3 SQL statements to find the highest (MAX), Lowest (MIN) and Average (AVG) price from the product table.

SELECT max(Prod_price) FROM product; 

SELECT min(Prod_price) FROM product; 

SELECT avg(Prod_price) FROM product; 

# Rewrite 3 above to use 1 SQL statement with labels for each attribute 

SELECT max(Prod_price) 'Price High', min(Prod_price) 'Price Low', avg(Prod_price) 'Average' FROM product;


# List vendor name,  product name, product price and product description

SELECT vend_name, Prod_name, Prod_price, Prod_desc
FROM vendor, product;

# List Customer name, order date, quantity, item price and product name.  Sort the list by order date.

SELECT Cust_name, order_date, quantity, item_price, Prod_name
FROM customer, orders, orderitem, product
order by order_date desc;

# List Vendor Name of Vendors that don’t have products.

SELECT v.Vend_id 'Vendor ID'
FROM vendor v 
WHERE not exists (select 'x' from product p where v.Vend_id = p.Vend_id);


# List Vendor Name, Product Name and Price. Sort the list by price descending.

SELECT vend_name 'Vendor Name', Prod_name 'Product Name', Prod_price 'Product Price'
FROM vendor, product 
order by Prod_price desc;

# List State and count of vendors by state (State, Count) use Group By

SELECT vend_state, count(Vend_id) count
FROM vendor 
group by vend_state;
