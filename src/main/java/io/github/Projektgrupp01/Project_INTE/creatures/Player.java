package io.github.Projektgrupp01.Project_INTE.creatures;

public interface Player extends Creature {
	int getLevel();
	long getExperience();
	long getExperienceToNextLevel();
	void addExperience(long amount);
	
}
