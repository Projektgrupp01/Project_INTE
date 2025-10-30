package io.github.Projektgrupp01.Project_INTE.creatures;

import java.util.Set;

import io.github.Projektgrupp01.Project_INTE.quests.Quest;

public interface Player extends Creature {
	int getLevel();

	long getExperience();

	long getExperienceToNextLevel();

	int getMaxHealth();

	int getMaxEnergy();

	void setLevel(int level);
	
	void setEnergy(int i);

	void addExperience(long amount);

	void acceptQuest(Quest quest);

	void completeQuest(Quest quest);

	public Set<Quest> getActiveQuests();

	Set<Quest> getCompletedQuests();

	void setMaxEnergy(int i);

	void setMaxHealth(int i);

	void setHealth(int i);

	void setStrength(int i);

	void setSpeed(int i);



}
