import java.lang.*;
import java.util.*;

public class Enemy {
	private String type;
	private int HP;
	private int damage;

	public Enemy() {}
	public Enemy(String type, int HP, int damage) {
		this.type = type;
		this.HP = HP;
		this.damage = damage;
	}

	public String getType() {
		return type;
	}

	public int getHP() {
		return HP;
	}

	public int getDamage() {
		return damage;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void attack(Character c, int enemyDamage) {
		int life = c.getHP() - enemyDamage;
		c.setHP(life);
	}

	public String toString() {
		return "Name: " + getType() + "\nHP: " + getHP() + "\nDamage: " + getDamage();
	}


}