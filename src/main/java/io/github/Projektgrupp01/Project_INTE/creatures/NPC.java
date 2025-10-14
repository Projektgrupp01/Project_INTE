package io.github.Projektgrupp01.Project_INTE.creatures;

public interface NPC extends Creature {
	enum Disposition {
		FRIENDLY, NEUTRAL, HOSTILE
	}

	Disposition getDisposition();

	void interact(Creature otherCreature);
}
