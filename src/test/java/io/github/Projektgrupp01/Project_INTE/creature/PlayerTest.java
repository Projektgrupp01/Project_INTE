package io.github.Projektgrupp01.Project_INTE.creature;

import io.github.Projektgrupp01.Project_INTE.spells.Fire;
import io.github.Projektgrupp01.Project_INTE.spells.Spell;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.TripleHealthDecorator;
import io.github.Projektgrupp01.Project_INTE.quests.Quest;

public class PlayerTest {

	private BasePlayer player;

	@BeforeEach
	void setUp() {
		player = new BasePlayer();
	}

	@Test
	void playerHas100Health() {
		assertEquals(100, player.getHealth());
	}

	@Test
	void playerHas100Speed() {
		assertEquals(100, player.getSpeed());
	}

	@Test
	void playerHas100Strength() {
		assertEquals(100, player.getStrength());
	}

	@Test
	void playerHas100Energy() {
		assertEquals(100, player.getEnergy());
	}

	@Test
	void playerTakesDamage() {
		player.takeDamage(10);
		assertEquals(90, player.getHealth());
	}

	@Test
	void playerTakeDamageBeyondMaximumHealth() {
		player.takeDamage(9999);
		assertEquals(0, player.getHealth());
		assertTrue(player.isDead());
	}

	@Test
	void playerDiesAtZeroHealth() {
		player.takeDamage(100);
		assertTrue(player.isDead());
	}

	@Test
	void playerCanBeDecorated() {
		TripleHealthDecorator buffedPlayer = new TripleHealthDecorator(player);
		assertTrue(buffedPlayer.getHealth() > player.getHealth());
	}

	@Test
	void playerStartsAtLevelOne() {
		assertEquals(1, player.getLevel());
	}

	@Test
	void playerCanGainExperience() {
		player.addExperience(10);
		assertEquals(10, player.getExperience());
	}

	@Test
	void addsExperienceAndLevelsUpCorrectly() {
		long needed = player.getExperienceToNextLevel();
		player.addExperience(needed);
		assertEquals(2, player.getLevel());
		assertEquals(0, player.getExperience());
	}

	@Test
	void playerCanGainMultipleLevelsAtOnce() {
		player.addExperience(300);
		assertEquals(3, player.getLevel());
	}

//	@Test
//	void playerCanAcceptQuestGivenByNPC() {
//		Quest quest = new Quest("Help the village!", "Kill 5 rats to save the village.", 50);
//		BaseNPC friendlyNPC = new BaseNPC("Friendly Bob", 50, NPC.Disposition.FRIENDLY);
//		friendlyNPC.setQuest(quest);
//		friendlyNPC.interact(player);
//
//		assertTrue(player.getActiveQuests().contains(quest));
//		assertEquals(Quest.Status.STARTED, quest.getStatus());
//	}

	@Test
	void playerIsRewardedAndQuestCompletedByQuestCompletion() {
		Quest quest = new Quest("Help the village!", "Kill 5 rats to save the village.", 50);
		player.acceptQuest(quest);
		player.completeQuest(quest);
		assertEquals(Quest.Status.COMPLETED, quest.getStatus());
		assertEquals(50, player.getExperience());
	}

}
