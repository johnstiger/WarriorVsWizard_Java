import java.lang.*;
import java.util.*;

public class Character {
	private String name;
	private int HP;
	private int damage;

	public Character() {}
	public Character(String name) {
		this.name = name;
		this.HP = 100;
		this.damage = 20;
	}

	public String getName() {
		return name;
	}

	public int getHP() {
		return HP;
	}

	public int getDamage() {
		return damage;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void attack(Enemy e, int combatDamage) {
		int life = e.getHP() - combatDamage;
		e.setHP(life);
	}

	public String getScream(String characterType) {
			return "The " + characterType + " "+ this.name + " scream!";
	}

	public String toString() {
		return "Name: " + getName() + "\nHP: " + getHP() + "\nDamage: " + getDamage();
	}
}

