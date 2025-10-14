package io.github.Projektgrupp01.Project_INTE;

public interface PlayerInterface {
	int getHealth();
	int getSpeed();
	int getStrength();
	int getEnergy();
	
	void takeDamage(int amount);
	boolean isDead();
	
}
