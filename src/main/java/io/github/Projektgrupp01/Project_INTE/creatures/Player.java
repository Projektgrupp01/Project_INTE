package io.github.Projektgrupp01.Project_INTE.creatures;

import java.util.Set;

import io.github.Projektgrupp01.Project_INTE.quests.Quest;

public interface Player extends Creature {
	int getLevel();

	long getExperience();

	long getExperienceToNextLevel();

	void addExperience(long amount);

	void acceptQuest(Quest quest);

	void completeQuest(Quest quest);

	public Set<Quest> getActiveQuests();

	void setLevel(int level);

	int getMaxHealth();

	int getMaxEnergy();

}
