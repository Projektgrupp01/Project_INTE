package io.github.Projektgrupp01.Project_INTE;

public class BasePlayer implements Player {
	private int health;
	private int speed;
	private int strength;
	private int energy;
	
	public BasePlayer() {
		this.health = 100;
		this.speed = 100;
		this.strength = 100;
		this.energy = 100;
	}
	
	public BasePlayer(int health, int energy, int speed) {
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
