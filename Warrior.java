import java.lang.*;
import java.util.*;

public class Warrior {
	private String weapon;
	private int weaponDamage;
	Character character;


	public Warrior() {}
	public Warrior(Character character, String weapon, int weaponDamage) {
		this.character = character;
		this.weapon = weapon;
		this.weaponDamage = weaponDamage;
	}

	public String getWeapon() {
		return weapon;
	}

	public int getWeaponDamage() {
			return weaponDamage;
	}

	public Character setCharacter(Character character) {
		return this.character = character;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	public void attack(Enemy e) {
				int life = e.getHP() - this.weaponDamage;
				e.setHP(life);
	}

	public String toString() {
			return "\n" + character.toString() + "\nWeapon: " + getWeapon() + "\nScream: " + character.getScream("Warrior");
	}

}