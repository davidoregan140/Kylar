package ie.cit.soft8027.kylarsvengeance.domain;

public class Equipment {

	private int id;
	
	private String type;
	
	private String name;
	
	private int damageInflicted;
	
	private int protectionProvided;
	
	private int upgradeLevel;
	
	private int price;
	

	public Equipment(int id, String type, String name, int damageInflicted, int protectionProvided, int upgradeLevel, int price) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.damageInflicted = damageInflicted;
		this.protectionProvided = protectionProvided;
		this.upgradeLevel = upgradeLevel;
		this.price = price;
	}

	public Equipment() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamageInflicted() {
		return damageInflicted;
	}

	public void setDamageInflicted(int damageInflicted) {
		this.damageInflicted = damageInflicted;
	}

	public int getProtectionProvided() {
		return protectionProvided;
	}

	public void setProtectionProvided(int protectionProvided) {
		this.protectionProvided = protectionProvided;
	}

	public int getUpgradeLevel() {
		return upgradeLevel;
	}

	public void setUpgradeLevel(int upgradeLevel) {
		this.upgradeLevel = upgradeLevel;
	}
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", type=" + type + ", name=" + name + ", damageInflicted=" + damageInflicted
				+ ", protectionProvided=" + protectionProvided + ", upgradeLevel=" + upgradeLevel + ", price =" + price + "]";
	}
	
	
}
