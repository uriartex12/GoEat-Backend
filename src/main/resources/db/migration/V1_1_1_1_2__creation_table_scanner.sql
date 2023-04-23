
CREATE TABLE IF NOT EXISTS Scanner(
	id serial4 primary key,
	code varchar(100),
	status int4,
	created_at timestamp,
	update_at timestamp	
);

