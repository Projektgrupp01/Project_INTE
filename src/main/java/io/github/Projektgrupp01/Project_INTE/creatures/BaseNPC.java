package io.github.Projektgrupp01.Project_INTE.creatures;

public class BaseNPC implements NPC {

	private int health;
	private int speed;
	private int strength;
	private int energy;
	private String name;
	private Disposition disposition;

	public BaseNPC(String name, int health, Disposition disposition) {
		this.name = name;
		this.health = health;
		this.disposition = disposition;
		this.speed = 100;
		this.strength = 100;
		this.energy = 100;
	}

	public BaseNPC(String name, int health, Disposition disposition, int speed, int strength, int energy) {
		this.name = name;
		this.health = health;
		this.disposition = disposition;
		this.speed = speed;
		this.strength = strength;
		this.energy = energy;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int getStrength() {
		return strength;
	}

	@Override
	public int getEnergy() {
		return energy;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void takeDamage(int amount) {
		health -= amount;
	}

	@Override
	public boolean isDead() {
		return health <= 0;
	}

	@Override
	public Disposition getDisposition() {
		return disposition;
	}

	@Override
	public void interact(Creature otherCreature) {
		switch (disposition) {
		case FRIENDLY:
			System.out.println(name + " greets you.");
			otherCreature.takeDamage(-10);
			break;
		case NEUTRAL:
			System.out.println(name + " ignores you.");
			break;
		case HOSTILE:
			System.out.println(name + " attacks!");
			otherCreature.takeDamage(10);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + disposition);
		}

	}

}
