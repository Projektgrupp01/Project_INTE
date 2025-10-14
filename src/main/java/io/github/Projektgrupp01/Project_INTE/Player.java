package io.github.Projektgrupp01.Project_INTE;

public class Player implements PlayerInterface {
	private int health;
	private int speed;
	private int strength;
	private int energy;
	
	public Player() {
		this.health = 100;
		this.speed = 100;
		this.strength = 100;
		this.energy = 100;
	}
	
	public Player(int health, int energy, int speed) {
        this.health = health;
        this.energy = energy;
        this.speed = speed;
    }
	
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
	public void takeDamage(int damage) {
		health -= damage;
	}
	public boolean isDead() {
		return health <= 0;
	}
	
}
