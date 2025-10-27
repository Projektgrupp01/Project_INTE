package io.github.Projektgrupp01.Project_INTE.quest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.quests.Quest;

class QuestTest {
	private Quest quest;

	@BeforeEach
	void setUp() {
		quest = new Quest("Help the village!", "Kill 5 rats to save the village.", 50, 0);
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
	void questsStartsWithStatusNotStarted() {
		assertEquals(Quest.Status.AVAILABLE, quest.getStatus());
	}

	@Test
	void questHasReward() {
		assertEquals(50, quest.getReward());
	}

	@Test
	void questCanBeStarted() {
		quest.start();
		assertEquals(Quest.Status.STARTED, quest.getStatus());
	}

	@Test
	void questCanBeCompleted() {
		quest.start();
		quest.complete();
		assertEquals(Quest.Status.COMPLETED, quest.getStatus());
	}

}
