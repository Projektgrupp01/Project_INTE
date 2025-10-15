package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC;

public class NPCTest {
	private BaseNPC friendlyNPC;
    private BaseNPC hostileNPC;
    private BaseNPC neutralNPC;
    private BasePlayer player;

    @BeforeEach
    void setUp() {
        friendlyNPC = new BaseNPC("Friendly Bob",50, NPC.Disposition.FRIENDLY);
        hostileNPC = new BaseNPC("Goblin", 50, NPC.Disposition.HOSTILE);
        neutralNPC = new BaseNPC("Villager", 50, NPC.Disposition.NEUTRAL);
        player = new BasePlayer();
    }
	
	@Test
	void shouldLoseHealthWhenHit() {
		hostileNPC.takeDamage(10);
		assertEquals(hostileNPC.getHealth(), 40);
	}
	@Test
	void friendlyNPCGreetsPlayer() {
		String result = friendlyNPC.interact(player);
		assertEquals("Friendly Bob greets you.", result);
	}
	@Test
    void neutralNpcIgnoresPlayer() {
        String result = neutralNPC.interact(player);
        assertEquals("Villager ignores you.", result);
    }
    @Test
    void hostileNpcAttacksPlayer() {
        String result = hostileNPC.interact(player);
        assertEquals("Goblin attacks!", result);
    }
}
