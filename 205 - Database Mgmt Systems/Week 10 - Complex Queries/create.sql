Drop database if exists test2;
Create database test2;
use test2;


########################
# Create customer table
########################
CREATE TABLE customer
(
  cust_id      int       NOT NULL AUTO_INCREMENT,
  cust_name    char(50)  NOT NULL ,
  cust_address char(50)  NULL ,
  cust_city    char(50)  NULL ,
  cust_state   char(5)   NULL ,
  cust_zip     char(10)  NULL ,
  cust_country char(50)  NULL ,
  cust_contact char(50)  NULL ,
  cust_email   char(255) NULL ,
  CONSTRAINT customer_PK PRIMARY KEY (cust_id)
) ENGINE=InnoDB;

######################
# Create vendor table
######################
CREATE TABLE vendor
(
  vend_id      int      NOT NULL AUTO_INCREMENT,
  vend_name    char(50) NOT NULL ,
  vend_address char(50) NULL ,
  vend_city    char(50) NULL ,
  vend_state   char(5)  NULL ,
  vend_zip     char(10) NULL ,
  vend_country char(50) NULL ,
  CONSTRAINT vendor_PK PRIMARY KEY (vend_id)
) ENGINE=InnoDB;


#####################
# Create orders table
#####################
CREATE TABLE orders
(
  order_num  int      NOT NULL AUTO_INCREMENT,
  order_date datetime NOT NULL ,
  cust_id    int      NOT NULL ,
  CONSTRAINT orders_PK PRIMARY KEY (order_num),
  CONSTRAINT orders_FK1 FOREIGN KEY (cust_id) REFERENCES customer (cust_id)
) ENGINE=InnoDB;

#######################
# Create product table
#######################
CREATE TABLE product
(
  prod_id    char(10)      NOT NULL,
  vend_id    int           NOT NULL ,
  prod_name  char(255)     NOT NULL ,
  prod_price decimal(8,2)  NOT NULL ,
  prod_desc  text          NULL ,
  CONSTRAINT product_PK PRIMARY KEY(prod_id),
  CONSTRAINT product_FK1 FOREIGN KEY (vend_id) REFERENCES vendor (vend_id)
) ENGINE=InnoDB;

#########################
# Create orderitem table
#########################
CREATE TABLE orderitem
(
  order_num  int          NOT NULL ,
  order_item int          NOT NULL ,
  prod_id    char(10)     NOT NULL ,
  quantity   int          NOT NULL ,
  item_price decimal(8,2) NOT NULL ,
  CONSTRAINT orderitem_PK PRIMARY KEY (order_num, order_item),
  CONSTRAINT orderitem_FK1 FOREIGN KEY (order_num) REFERENCES orders (order_num),
  CONSTRAINT orderitem_FK2 FOREIGN KEY (prod_id) REFERENCES product (prod_id)
) ENGINE=InnoDB;


###########################
# Create productnote table
###########################
CREATE TABLE productnote
(
  note_id    int           NOT NULL AUTO_INCREMENT,
  prod_id    char(10)      NOT NULL,
  note_date datetime       NOT NULL,
  note_text  text          NULL ,
  CONSTRAINT productnote_PK PRIMARY KEY(note_id),
  CONSTRAINT productnote_FK1 FOREIGN KEY (prod_id) REFERENCES product (prod_id)
) ENGINE=MyISAM;

