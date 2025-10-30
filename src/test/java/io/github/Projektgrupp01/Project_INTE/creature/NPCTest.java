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
	private Quest questWithRequirements;

	@BeforeEach
	void setUp() {
		friendlyNPC = new BaseNPC("Friendly Bob", 50, NPC.Disposition.FRIENDLY);
		hostileNPC = new BaseNPC("Goblin", 50, NPC.Disposition.HOSTILE);
		neutralNPC = new BaseNPC("Villager", 50, NPC.Disposition.NEUTRAL);
		player = new BasePlayer();
		quest = new Quest("TestQuest", "Test Description", 10, 0);
		questWithRequirements = new Quest("Help the village!", "Kill 5 rats to save the village.", 50, 5, 3);
	}

	@Test
	void shouldLoseHealthWhenHit() {
		hostileNPC.takeDamage(10);
		assertEquals(40, hostileNPC.getHealth());
	}

	@Test
	void getDispositionTest() {
		assertEquals(NPC.Disposition.HOSTILE, hostileNPC.getDisposition());
	}

	@Test
	void getNameTest() {
		assertEquals("Friendly Bob", friendlyNPC.getName());
	}

	@Test
	void getSpeedTest() {
		assertEquals(100, friendlyNPC.getSpeed());
	}

	@Test
	void getStrengthTest() {
		assertEquals(100, friendlyNPC.getStrength());
	}

	@Test
	void getEnergyTest() {
		assertEquals(100, friendlyNPC.getEnergy());

	}

	@Test
	void diesAt0Health() {
		hostileNPC.takeDamage(50);
		assertTrue(hostileNPC.isDead());
	}

	@Test
	void isnotDeadAt1Health() {
		hostileNPC.takeDamage(49);
		assertFalse(hostileNPC.isDead());
	}

	@Test
	void friendlyNPCGreetsAndHealsPlayer() {
		player.takeDamage(11);
		friendlyNPC.interact(player);
		assertEquals(player.getMaxHealth() - 1, player.getHealth());
	}

	@Test
	void friendlyNPCGreetsAndHealsPlayerNearMaxHealth() {
		player.takeDamage(5);
		friendlyNPC.interact(player);
		assertEquals(player.getMaxHealth(), player.getHealth());
	}

	@Test
	void interactingWithNPCWithoutDispositionThrowsNullPointerException() {
		NPC nullNPC = new BaseNPC("NullMan", 1, null);
		assertThrows(NullPointerException.class, () -> nullNPC.interact(player));
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
		assertTrue(player.getActiveQuests().contains(quest));
	}

	@Test
	void npcCantOfferQuestIfPlayerDoesntMeetRequirements() {
		assertThrows(IllegalArgumentException.class, () -> friendlyNPC.offerQuest(player, questWithRequirements));
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

	@Test
	void npcIgnoresNonPlayerCreatures() {
		NPC friendlyNPC2 = new BaseNPC("Friendly Erik", 50, NPC.Disposition.FRIENDLY);
		friendlyNPC.interact(friendlyNPC2);
		assertEquals(50, (friendlyNPC2).getHealth());
	}
}
