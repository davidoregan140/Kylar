CREATE TABLE players (
	id int(10) NOT NULL AUTO_INCREMENT,
	firstName varchar (20),
	lastName varchar (20),	
	userName varchar (30) NOT NULL,
	balance double (6) NOT NULL,
	upCloseWeapon varchar (30),
	distanceWeapon varchar (30),
	armour varchar (30),
	shield varchar (30),
	PRIMARY KEY (id)
);

CREATE TABLE equipment (
	id int (10) NOT NULL AUTO_INCREMENT,
	name varchar (20) NOT NULL,
	damageInflicted int (3),
	protectionProvided int (3),
	upgradeLevel int (10) NOT NULL,
	PRIMARY KEY (id),
);


CREATE TABLE players_equipment (
	player_id int (10) NOT NULL,
	equipment_id int (10) NOT NULL,
	PRIMARY KEY (player_id, equipment_id)
);





