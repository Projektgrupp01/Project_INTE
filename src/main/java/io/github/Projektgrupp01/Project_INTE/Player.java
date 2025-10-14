package io.github.Projektgrupp01.Project_INTE;

public class Player {
	private int health = 100;
	private int speed = 100;
	private int strength = 100;
	private int energy = 100;
	
	public int getHealth() {
		return health;
	}
	public int getSpeed() {
		return speed;
	}
	public int getStrength() {
		return strength;
	}
	public int getEnergy() {
		return energy;
	}
	public int takeDamage(int damage) {
		return health -= damage;
	}
	public boolean isDead() {
		return health <= 0;
	}
	
}
