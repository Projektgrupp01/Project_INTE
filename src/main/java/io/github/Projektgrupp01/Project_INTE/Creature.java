package io.github.Projektgrupp01.Project_INTE;

public interface Creature {
	String getName();
	
	int getHealth();

	int getSpeed();

	int getStrength();

	int getEnergy();

	void takeDamage(int amount);

	boolean isDead();

}
