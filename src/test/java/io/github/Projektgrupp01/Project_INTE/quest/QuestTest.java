package io.github.Projektgrupp01.Project_INTE.quest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.quests.Quest;
import io.github.Projektgrupp01.Project_INTE.quests.Quest.Status;

class QuestTest {
	private Quest quest;
	private Quest questWithRequirements;
	private Player player;
	private Player playerWithRequirements;

	@BeforeEach
	void setUp() {
		quest = new Quest("Help the village!", "Kill 5 rats to save the village.", 50, 0);
		questWithRequirements = new Quest("Help the village!", "Kill 5 rats to save the village.", 50, 5, 3);
		player = new BasePlayer();
		playerWithRequirements = new BasePlayer("Level 5-guy", 100, 100, 100, 100, 5);
	}

	@Test
	void questHasName() {
		assertEquals("Help the village!", quest.getName());
	}

	@Test
	void questHasDescription() {
		assertEquals("Kill 5 rats to save the village.", quest.getDescription());
	}

	@Test
	void questsStartsWithStatusLocked() {
		assertEquals(Quest.Status.LOCKED, quest.getStatus());
	}

	@Test
	void questHasReward() {
		assertEquals(50, quest.getReward());
	}

	@Test
	void questWithAvailableStatusCanBeStarted() {
		quest.setStatus(Status.AVAILABLE);
		quest.start(player);
		assertEquals(Quest.Status.ACCEPTED, quest.getStatus());
	}

	@Test
	void questWithNormalSuccessCanBeCompletedWithNormalReward() {
		quest.setStatus(Status.SUCCESS_NORMAL);
		quest.complete(player);
		assertEquals(Quest.Status.COMPLETED, quest.getStatus());
	}

	@Test
	void questsWithoutAllowedAttemptsCanBeRepeatedManyTimes() {
		for (int i = 0; i < 10000; i++) {
			quest.setStatus(Quest.Status.FAILED);
			quest.complete(player);
		}
		assertEquals(Status.AVAILABLE, quest.getStatus());
	}

	@Test
	void questsWithAllowedAttemptsCanOnlyBeRepeatedAllowedTimes() {
		questWithRequirements.start(playerWithRequirements);
		questWithRequirements.fail();
		questWithRequirements.complete(playerWithRequirements);
		questWithRequirements.start(playerWithRequirements);
		questWithRequirements.fail();
		questWithRequirements.complete(playerWithRequirements);
		questWithRequirements.start(playerWithRequirements);
		questWithRequirements.fail();
		questWithRequirements.complete(playerWithRequirements);
		assertEquals(Status.PERMANENT_LOCK, questWithRequirements.getStatus());

	}

}
