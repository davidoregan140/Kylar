INSERT INTO players VALUES (1, 'David', 'O''Regan', 'Male', 'Sharkbag', 1000); 

INSERT INTO equipment (id, type, name, damageInflicted, protectionProvided, upgradeLevel, price) 
					 VALUES (1, 'up-close weapon', 'Sword', 55, 20, 1, 300), 
							(2, 'distance weapon', 'Crossbow', 70, 5, 1, 400),
							(3, 'up-close weapon', 'Dagger', 50, 2, 1, 200),
							(4, 'distance weapon', 'Spear', 68, 0, 1, 250),
							(5, 'shield', 'Basic Wooden Shield', 5, 55, 1, 150),
							(6, 'shield', 'Heavy Wooden Shield', 12, 73, 1, 230),
							(7, 'armour', 'Chain Mail', 0, 30, 1, 300),
							(8, 'armour', 'Plate Armour', 0, 74, 1, 450);

INSERT INTO players_equipment VALUES (1, 1), (1, 5), (1, 7); 