package io.github.Projektgrupp01.Project_INTE.creature;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC;

public class NPCTest {
	private NPC friendlyNPC;
	private NPC neutralNPC;
	private NPC hostileNPC;
	private Player player;

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
		assertEquals(40, hostileNPC.getHealth());
	}
	@Test
	void friendlyNPCGreetsPlayer() {
		friendlyNPC.interact(player);
		assertEquals(player.getHealth(), 110);
	}
	@Test
    void neutralNpcIgnoresPlayer() {
		neutralNPC.interact(player);
		assertEquals(player.getHealth(), 100);
    }
    @Test
    void hostileNpcAttacksPlayer() {
    	hostileNPC.interact(player);
		assertEquals(player.getHealth(), 90);
    }
}
