package io.github.Projektgrupp01.Project_INTE.creatures;

import java.util.Set;

import io.github.Projektgrupp01.Project_INTE.quests.Quest;

public interface NPC extends Creature {
	enum Disposition {
		FRIENDLY, NEUTRAL, HOSTILE
	}

	Disposition getDisposition();

	void interact(Creature otherCreature);

	void addQuest(Quest quest);

	Set<Quest> getQuests();
}
