package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class NPCTest {
	@Test
	void shouldLoseHealthWhenHit() {
		NPC goblin = new BaseNPC("Goblin", 50, HOSTILE);
		goblin.takeDamage(10);
		assertEquals(goblin.getHealth(), 40);
	}

	@Test
	void canBeSetToHostile() {
		NPC goblin = new BaseNPC("Goblin", 50, HOSTILE);
		assertEquals(NPC.disposition.HOSTILE, goblin.getDisposition);
	}
}
