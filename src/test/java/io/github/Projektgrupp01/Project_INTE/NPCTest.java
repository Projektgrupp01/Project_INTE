package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC;

public class NPCTest {
	@Test
	void shouldLoseHealthWhenHit() {
		NPC goblin = new BaseNPC("Goblin", 50, NPC.Disposition.HOSTILE);
		goblin.takeDamage(10);
		assertEquals(goblin.getHealth(), 40);
	}

	@Test
	void canBeSetToHostile() {
		NPC goblin = new BaseNPC("Goblin", 50, NPC.Disposition.HOSTILE);
		assertEquals(NPC.Disposition.HOSTILE, goblin.getDisposition());
	}
}
