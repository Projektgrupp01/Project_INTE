package io.github.Projektgrupp01.Project_INTE.creatures;

import io.github.Projektgrupp01.Project_INTE.quests.Quest;

public interface Player extends Creature {
	int getLevel();
	long getExperience();
	long getExperienceToNextLevel();
	void addExperience(long amount);
	void acceptQuest(Quest quest);
	void completeQuest(Quest quest);
	
}
