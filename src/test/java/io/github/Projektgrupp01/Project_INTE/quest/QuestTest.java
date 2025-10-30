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
	void questStatusCanBeSetToAllStatuses() {
		for (Quest.Status status : Quest.Status.values()) {
			quest.setStatus(status);
			assertEquals(status, quest.getStatus(), "Status should be set correctly for " + status);
		}
	}

	@Test
	void questStatusCannotBeSetToNull() {
		assertThrows(NullPointerException.class, () -> quest.setStatus(null));
	}

	@Test
	void questWithAvailableStatusCanBeStarted() {
		quest.setStatus(Status.AVAILABLE);
		quest.start(player);
		assertEquals(Quest.Status.ACCEPTED, quest.getStatus());
	}

	@Test
	void questWithoutAvailableStatusCannotBeStarted() {
		quest.setStatus(Status.IN_PROGRESS);
		assertThrows(IllegalStateException.class, () -> quest.start(player));
	}

	@Test
	void questWithLockedStatusCannotBeStarted() {
		questWithRequirements.start(player);
		assertFalse(player.getActiveQuests().contains(questWithRequirements));
	}

	@Test
	void questWithNeitherLockedOrAvailableStatusCannotBeStarted() {
		quest.setStatus(Status.ACCEPTED);
		assertFalse(player.getActiveQuests().contains(quest));
	}

	@Test
	void questWithNormalSuccessCanBeCompletedWithNormalReward() {
		quest.setStatus(Status.SUCCESS_NORMAL);
		quest.complete(player);
		assertEquals(Quest.Status.COMPLETED, quest.getStatus());
	}

	@Test
	void questWithBonusSuccessCanBeCompletedWithBonusReward() {
		quest.setStatus(Status.SUCCESS_BONUS);
		quest.complete(player);
		assertEquals(2, player.getLevel());
		assertEquals(Quest.Status.COMPLETED, quest.getStatus());
	}

	@Test
	void questWithCompletedStatusCannotBeCompletedAgain() {
		quest.start(player);
		quest.complete(player);
		assertThrows(IllegalStateException.class, () -> quest.complete(player));
	}

	@Test
	void questWithLockedPermanentLockOrAvailableCannotBeCompleted() {
		quest.setStatus(Status.AVAILABLE);
		assertThrows(IllegalStateException.class, () -> quest.complete(player));
		quest.setStatus(Status.LOCKED);
		assertThrows(IllegalStateException.class, () -> quest.complete(player));
		quest.setStatus(Status.PERMANENT_LOCK);
		assertThrows(IllegalStateException.class, () -> quest.complete(player));
	}

	@Test
	void questWithStatusAcceptedCanFail() {
		quest.setStatus(Status.ACCEPTED);
		quest.fail();
		assertEquals(Status.FAILED, quest.getStatus());
	}

	@Test
	void questWithStatusInProgressCanFail() {
		quest.setStatus(Status.IN_PROGRESS);
		quest.fail();
		assertEquals(Status.FAILED, quest.getStatus());
	}

	@Test
	void questWithStatusFailedCannotFailAgain() {
		quest.setStatus(Status.FAILED);
		assertThrows(IllegalStateException.class, () -> quest.fail());
	}

	@Test
	void questWithStatusAvailableCannotFail() {
		quest.setStatus(Status.AVAILABLE);
		assertThrows(IllegalStateException.class, () -> quest.fail());
	}

	@Test
	void questWithStatusLockedCannotFail() {
		quest.setStatus(Status.LOCKED);
		assertThrows(IllegalStateException.class, () -> quest.fail());
	}

	@Test
	void questWithStatusPermanentLockCannotFail() {
		quest.setStatus(Status.PERMANENT_LOCK);
		assertThrows(IllegalStateException.class, () -> quest.fail());
	}

	@Test
	void questWithStatusSuccessNormalCannotFail() {
		quest.setStatus(Status.SUCCESS_NORMAL);
		assertThrows(IllegalStateException.class, () -> quest.fail());
	}

	@Test
	void questWithStatusSuccessBonusCannotFail() {
		quest.setStatus(Status.SUCCESS_BONUS);
		assertThrows(IllegalStateException.class, () -> quest.fail());
	}

	@Test
	void questWithStatusCompletedCannotFail() {
		quest.setStatus(Status.COMPLETED);
		assertThrows(IllegalStateException.class, () -> quest.fail());
	}

	@Test
	void questsWith0AllowedAttemptsCanBeRepeatedManyTimes() {
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
