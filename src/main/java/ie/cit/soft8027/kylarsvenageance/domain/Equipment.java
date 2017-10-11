package ie.cit.soft8027.kylarsvenageance.domain;

public class Equipment {

	private int id;
	
	private String name;
	
	private int damageInflicted;
	
	private int protectionProvided;
	
	private int upgradeLevel;
	
	

	public Equipment(int id, String name, int damageInflicted, int protectionProvided, int upgradeLevel) {
		super();
		this.id = id;
		this.name = name;
		this.damageInflicted = damageInflicted;
		this.protectionProvided = protectionProvided;
		this.upgradeLevel = upgradeLevel;
	}

	public Equipment() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", damageInflicted=" + damageInflicted
				+ ", protectionProvided=" + protectionProvided + ", upgradeLevel=" + upgradeLevel + "]";
	}
	
	
}
