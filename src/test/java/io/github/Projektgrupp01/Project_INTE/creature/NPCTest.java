package io.github.Projektgrupp01.Project_INTE.creature;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC;
import io.github.Projektgrupp01.Project_INTE.quests.Quest;

public class NPCTest {
	private NPC friendlyNPC;
	private NPC neutralNPC;
	private NPC hostileNPC;
	private Player player;
	private Quest quest;

    @BeforeEach
    void setUp() {
        friendlyNPC = new BaseNPC("Friendly Bob",50, NPC.Disposition.FRIENDLY);
        hostileNPC = new BaseNPC("Goblin", 50, NPC.Disposition.HOSTILE);
        neutralNPC = new BaseNPC("Villager", 50, NPC.Disposition.NEUTRAL);
        player = new BasePlayer();
        quest = new Quest("TestQuest", "Test Description", 10, 0);
    }
	
	@Test
	void shouldLoseHealthWhenHit() {
		hostileNPC.takeDamage(10);
		assertEquals(40, hostileNPC.getHealth());
	}
	@Test
	void friendlyNPCGreetsPlayer() {
		player.takeDamage(10);
		friendlyNPC.interact(player);
		assertEquals(player.getMaxHealth(), player.getHealth());
	}
    @Test
    void friendlyNPCCanBeAssignedQuests() {
    	friendlyNPC.addQuest(quest);
    	assertTrue(friendlyNPC.getQuests().contains(quest));
    }
    @Test
    void friendlyNPCCanOfferAssignedQuests() {
    	friendlyNPC.addQuest(quest);
    	friendlyNPC.interact(player);
    }
	@Test
    void neutralNpcIgnoresPlayer() {
		neutralNPC.interact(player);
		assertEquals(100, player.getHealth());
    }
    @Test
    void hostileNpcAttacksPlayer() {
    	hostileNPC.interact(player);
		assertEquals(90, player.getHealth());
    }
}
