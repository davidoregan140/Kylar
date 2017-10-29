CREATE TABLE players (
	id int (3) NOT NULL AUTO_INCREMENT,
	firstName varchar (20),
	lastName varchar (20),	
	gender varchar (6),
	userName varchar (30) NOT NULL,
	balance int (10) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE equipment (
	id int (3) NOT NULL AUTO_INCREMENT,
	type varchar (20) NOT NULL,
	name varchar (20) NOT NULL,
	damageInflicted int (3),
	protectionProvided int (3),
	upgradeLevel int (10) NOT NULL,
	price int (10) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE players_equipment (
	player_id int(10) NOT NULL,
	equipment_id int(10) NOT NULL,
	PRIMARY KEY (player_id, equipment_id)
);



