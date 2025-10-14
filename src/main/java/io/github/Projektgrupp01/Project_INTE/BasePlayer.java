package io.github.Projektgrupp01.Project_INTE;

public class BasePlayer implements Player {
	private int health;
	private int speed;
	private int strength;
	private int energy;
	private String name;

	public BasePlayer() {
		this.health = 100;
		this.speed = 100;
		this.strength = 100;
		this.energy = 100;
		this.name = "BasePlayer";
	}

	public BasePlayer(int health, int speed, int strength, int energy, String name) {
		this.health = health;
		this.speed = speed;
		this.strength = strength;
		this.energy = energy;
		this.name = name;
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

	@Override
	public String getName() {
		return name;
	}

}
