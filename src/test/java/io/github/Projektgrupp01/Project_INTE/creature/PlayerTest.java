package io.github.Projektgrupp01.Project_INTE.creature;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.TripleHealthDecorator;
import io.github.Projektgrupp01.Project_INTE.quests.Quest;

public class PlayerTest {

	private Player player;
	private NPC friendlyNPC;
	private Quest quest;
	private Quest questWithRequirements;

	@BeforeEach
	void setUp() {
		player = new BasePlayer();
		quest = new Quest("Test Quest", "Description of Test Quest.", 50, 0);
		questWithRequirements = new Quest("Help the village!", "Kill 5 rats to save the village.", 50, 5, 3);
		friendlyNPC = new BaseNPC("Friendly Bob", 1, NPC.Disposition.FRIENDLY);
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
		Player buffedPlayer = new TripleHealthDecorator(player);
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

	@Test
	void playerLevelCanBeSet() {
		player.setLevel(2);
		assertEquals((2), player.getLevel());
	}

	@Test
	void playerLevelCanBeSetToMaxLevel() {
		player.setLevel(10);
		assertEquals((10), player.getLevel());
	}

	@Test
	void playerLevelCannotBeSetTo0OrLower() {
		assertThrows(IllegalStateException.class, () -> player.setLevel(0));
	}

	@Test
	void playerLevelCannotBeSetTo11() {
		assertThrows(IllegalStateException.class, () -> player.setLevel(11));
	}

	@Test
	void playerEnergyDefaultsTo0IfLower() {
		player.setEnergy(-10);
		assertEquals((0), player.getEnergy());
	}

	@Test
	void playerEnergyCannotBeSetToHigherThanMaxEnergy() {
		assertThrows(IllegalStateException.class, () -> player.setEnergy(101));
	}

	@Test
	void playerMaxEnergyCanBeSet() {
		player.setMaxEnergy(101);
		assertEquals(101, player.getMaxEnergy());
	}

	@Test
	void playerMaxEnergyCannotBeSetTo0OrLess() {
		assertThrows(IllegalStateException.class, () -> player.setMaxEnergy(0));
	}

	@Test
	void playerHealthCanBeSet() {
		player.setHealth(60);
		assertEquals(60, player.getHealth());
	}

	@Test
	void playerHealthDefaultsTo0IfLower() {
		player.setHealth(-1);
		assertEquals(0, player.getHealth());
	}

	@Test
	void playerHealthCannotBeSetHigherThanMaxHealth() {
		assertThrows(IllegalStateException.class, () -> player.setHealth(101));
	}

	@Test
	void playerStrengthCanBeSet() {
		player.setStrength(60);
		assertEquals(60, player.getStrength());
	}

	@Test
	void playerStrengthCannotBe0OrLess() {
		assertThrows(IllegalStateException.class, () -> player.setStrength(-1));
	}

	@Test
	void playerSpeedCanBeSet() {
		player.setSpeed(60);
		assertEquals(60, player.getSpeed());
	}

	@Test
	void playerSpeedCannotBe0OrLess() {
		assertThrows(IllegalStateException.class, () -> player.setSpeed(-1));
	}

	@Test
	void playerMaxHealthCanBeSet() {
		player.setMaxHealth(101);
		assertEquals(101, player.getMaxHealth());
	}

	@Test
	void playerMaxHealthCannotBeSetTo0OrLess() {
		assertThrows(IllegalStateException.class, () -> player.setMaxHealth(0));
	}

	@Test
	void playerCannotAcceptNullQuest() {
		assertThrows(NullPointerException.class, () -> player.acceptQuest(null));
	}

	@Test
	void playerCannotAcceptQuestWithoutRequirementsMet() {
		assertThrows(IllegalStateException.class, () -> player.acceptQuest(questWithRequirements));
	}

	@Test
	void deadPlayerCannotAcceptQuests() {
		player.takeDamage(100);
		player.acceptQuest(quest);
		assertFalse(player.getActiveQuests().contains(quest));
	}

	@Test
	void playerCanAcceptQuestGivenByNPC() {
		friendlyNPC.addQuest(quest);
		friendlyNPC.interact(player);
		assertTrue(player.getActiveQuests().contains(quest));
		assertEquals(Quest.Status.ACCEPTED, quest.getStatus());
	}

	@Test
	void playerCannotCompleteNullQuest() {
		assertThrows(NullPointerException.class, () -> player.completeQuest(null));
	}

	@Test
	void playerCannotCompleteQuestThatHasntStarted() {
		assertThrows(IllegalStateException.class, () -> player.completeQuest(quest));
	}

	@Test
	void playerCannotCompleteQuestThatHasBeenCompletedAlready() {
		player.acceptQuest(quest);
		player.completeQuest(quest);
		assertThrows(IllegalStateException.class, () -> player.completeQuest(quest));
	}

	@Test
	void playersCompletedQuestsContainsCompletedQuests() {
		player.acceptQuest(quest);
		player.completeQuest(quest);
		assertTrue(player.getCompletedQuests().contains(quest));
	}

	@Test
	void playerIsRewardedAndQuestCompletedByQuestCompletion() {
		player.acceptQuest(quest);
		player.completeQuest(quest);
		assertEquals(Quest.Status.COMPLETED, quest.getStatus());
		assertEquals(50, player.getExperience());
	}

	@Test
	void deadPlayerCannotCompleteQuests() {
		player.acceptQuest(quest);
		player.takeDamage(100);
		player.completeQuest(quest);
		assertFalse(player.getCompletedQuests().contains(quest));
	}
}
