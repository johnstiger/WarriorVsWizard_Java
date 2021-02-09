import java.util.*;
import java.lang.*;
import java.io.*;

public class TestClass {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();

		int HP = 100;
		int damage = 20;
		int i = 0;
/***


Character Creation


***/
		System.out.print("Enter name: ");
		String name = scan.next();

		Character character = new Character(name);

		int choice = 0;
		while(choice == 0) {
			System.out.print("\nChoose type: Enter 1 for WIZARD or Enter 2 for WARRIOR: ");
			choice = scan.nextInt();

			switch(choice){
				case 1:
						character.setHP(HP + 100);
						character.setDamage(damage + 5);

						System.out.println("\nChoose your weapon! Enter 1 or 2");
						System.out.println("1. Sword, damage is 20");
						System.out.println("2. Axe, damage is 15");
						System.out.print("Enter here: ");
						int weaponChoice = scan.nextInt();

						Wizard wiz = new Wizard();
						wiz.setCharacter(character);
						i = 1;

						if(weaponChoice == 1) {
							wiz.setWeapon("Sword");
							wiz.setWeaponDamage(character.getDamage() + 20);
							character.setDamage(wiz.getWeaponDamage());
						} else {
							wiz.setWeapon("Axe");
							wiz.setWeaponDamage(character.getDamage() + 15);
							character.setDamage(wiz.getWeaponDamage());
						}

						System.out.println("\n\n--Player Stats--");
						System.out.println(wiz.toString());
						System.out.print("\n\nPress ENTER key to continue...");
						try {
							System.in.read();
						} catch (IOException error) {
						    error.printStackTrace();
    					}
				break;
				case 2:
						character.setHP(HP + 200);
						character.setDamage(damage + 10);

						System.out.println("\nChoose your weapon! Enter 1 or 2");
						System.out.println("1. Sword, damage is 20");
						System.out.println("2. Axe, damage is 15");
						System.out.print("Enter here: ");
						int weaponChoice1 = scan.nextInt();

						Warrior war = new Warrior();
						war.setCharacter(character);
						i = 2;

						if(weaponChoice1 == 1) {
							war.setWeapon("Sword");
							war.setWeaponDamage(character.getDamage() + 20);
							character.setDamage(war.getWeaponDamage());
						} else {
							war.setWeapon("Axe");
							war.setWeaponDamage(character.getDamage() + 15);
							character.setDamage(war.getWeaponDamage());
						}

						System.out.println("\n\n--Player Stats--");
						System.out.println(war.toString());
						System.out.print("\n\nPress ENTER key to continue...");
						try {
							System.in.read();
						} catch (IOException e) {
							e.printStackTrace();
    					}
				break;
				default:
					System.out.println("Invalid choice! Please try again!");
					choice = 0;
					break;
			}
		}

/***


Choosing Enemy


***/
		System.out.println("\n\nSelect enemy!");
		System.out.println("1. Slug");
		System.out.println("2. Goblin");
		System.out.print("Enter here: ");
		int enemyChoice = scan.nextInt();

		Enemy e = new Enemy();

		if(enemyChoice == 1) {
			e.setType("Slug");
			e.setHP(50);
			e.setDamage(15);
		}
		if(enemyChoice == 2) {
			e.setType("Goblin");
			e.setHP(100);
			e.setDamage(20);
		}

		System.out.println("\n\n" + character.getName()+ " goes first!");

		int playerChoice = -1;
		int lowCharacterDamage = 12;
		int highCharacterDamage = character.getDamage();
		int lowEnemyDamage = 10;
		int highEnemyDamage = e.getDamage();

		while(playerChoice != 0){
			System.out.println("\n\n\n--Make your choice!--");
			System.out.println("1. Attack");
			System.out.println("3. Scream!");
			playerChoice = scan.nextInt();

			switch(playerChoice) {
				case 1:
						int combatDamage = r.nextInt(highCharacterDamage - lowCharacterDamage) + lowCharacterDamage;
						int enemyDamage = r.nextInt(highEnemyDamage - lowEnemyDamage) + lowEnemyDamage;

						character.attack(e, combatDamage);

						System.out.println(character.getName() + " dealt " + combatDamage + " to the " + e.getType());
						System.out.println("The enemy has now " + e.getHP() + "HP left!");

						if(character.getHP() <= 0 || e.getHP() <= 0) {
							playerChoice = 0;
							break;
						}

						System.out.print("\n\nPress ENTER key to continue...");
						try {
							System.in.read();
						} catch (IOException error) {
							error.printStackTrace();
						}

						e.attack(character, enemyDamage);
						System.out.println(e.getType() + " dealt " + enemyDamage + " to the Player!");
						System.out.print("\n\nPress ENTER key to continue...");
						try {
							System.in.read();
						} catch (IOException error) {
							error.printStackTrace();
						}

						if(character.getHP() <= 0 || e.getHP() <= 0) {
							playerChoice = 0;
							//return;
						}

					break;
				case 2:
						enemyDamage = r.nextInt(highEnemyDamage - lowEnemyDamage) + lowEnemyDamage;

						if(i == 1) {
							System.out.println(character.getScream("Wizard"));
						} else {
							System.out.println(character.getScream("Warrior"));
						}

						System.out.println("The attack does absolutely nothing!");
						System.out.print("\n\nPress ENTER key to continue...");
						try {
							System.in.read();
						} catch (IOException error) {
							error.printStackTrace();
						}

						e.attack(character, enemyDamage);
						System.out.println(e.getType() + " dealt " + enemyDamage + " to the Player!");

						System.out.print("\n\nPress ENTER key to continue...");
						try {
							System.in.read();
						} catch (IOException error) {
							error.printStackTrace();
						}

						if(character.getHP() <= 0 || e.getHP() <= 0) {
							playerChoice = 0;
						}

					break;
				default:
						enemyDamage = r.nextInt(highEnemyDamage - lowEnemyDamage) + lowEnemyDamage;

						System.out.println("Invalid choice, my dear friend! The enemy will now attack!");
						System.out.print("\n\nPress any key to continue...");
						try {
							System.in.read();
						} catch (IOException error) {
							error.printStackTrace();
						}

						e.attack(character, enemyDamage);
						System.out.println(e.getType() + " dealt " + enemyDamage + " to the Player!");

						System.out.print("\n\nPress ENTER key to continue...");
						try {
							System.in.read();
						} catch (IOException error) {
							error.printStackTrace();
						}

						if(character.getHP() <= 0 || e.getHP() <= 0) {
							playerChoice = 0;
						}
					break;
			}
		}

		if(character.getHP() <= 0) {
			System.out.println("\n\nThe enemy won!");
		}

		if(e.getHP() <= 0){
			System.out.println("\n\nThe player won!");
			System.out.print("\n\nPress ENTER key to continue...");
		}
	}
}