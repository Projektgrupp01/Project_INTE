package io.github.Projektgrupp01.Project_INTE;

public interface Creature {
	int getHealth();

	void takeDamage(int amount);

	boolean isDead();

	String getName();
}
