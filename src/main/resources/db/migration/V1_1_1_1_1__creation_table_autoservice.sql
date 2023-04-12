CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS client(
	id serial4 primary key,
	code varchar(100),
	identitynumber varchar(100),
	businessname varchar(100),
	status int4,
	server varchar(80),
	endpoint varchar(250),
	secret varchar(100),
	logo varchar(250),
	home varchar(150),
	conf text,
	startdate timestamp
);


CREATE TABLE IF NOT EXISTS users(
	id serial4 primary key,
	username varchar(100),
	password varchar(100),
	firstname varchar(100),
	lastname varchar(100),
	gender varchar(1),
	currency varchar(5),
	status int4,
	online int4,
	address varchar(100),
	phone varchar(50),
	email varchar(100),
	img varchar(100),
	identitynumber varchar(100),
	created_at timestamp,
	update_at timestamp	
);


CREATE TABLE IF NOT EXISTS transaction(
	id serial4 primary key,
	userid int4,
	totalmoney numeric(18, 2),
	voucherid int8,
	comment text,
	igv numeric(18, 2),
	created_at timestamp,
	update_at timestamp,
	constraint userid_fk foreign key (userid) references users(id)
);

CREATE TABLE IF NOT EXISTS product(
	id serial4 primary key,
	code varchar(50),
	barcode varchar(50),
	description text,
	clientid int4,
	photo varchar(250),
	nameconcat varchar(250),
	amount numeric(18, 2),
	name varchar(100),
	totalmoney numeric(18, 2),
	created_at timestamp,
	update_at timestamp,
	constraint clientid_fk foreign key (clientid) references client(id)
);


CREATE TABLE IF NOT EXISTS transactiondetail(
	id serial4 primary key,
	transactionid int8,
	amount numeric(18, 2),
	productid int8,
	detail text,
	totalmoney numeric(18, 2),
	comment text,
	created_at timestamp,
	update_at timestamp,
	constraint transactionid_fk foreign key (transactionid) references transaction(id),
	constraint productid_fk foreign key (productid) references product(id)
);

		

