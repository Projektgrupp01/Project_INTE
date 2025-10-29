package io.github.Projektgrupp01.Project_INTE.quest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC;
import io.github.Projektgrupp01.Project_INTE.quests.Quest;

public class GoblinRaidQuestTest {
	private Quest quest;
	private Player player;
	private BaseNPC questNPC;

	@BeforeEach
	void setUp() {
		quest = new Quest("The Goblin Raid",
				"The village is being attacked by Goblins! Please save us! [Kill 3 goblins before the village is destroyed in 10 minutes]",
				100, 5, 0);
		questNPC = new BaseNPC("Friendly Bob", 50, NPC.Disposition.FRIENDLY);
		player = new BasePlayer();
	}

	@Test
	void possibleNormalCompletionFlowOfTheGoblinRaid() {
		questNPC.addQuest(quest);
		player.setLevel(4);
		assertTrue(!quest.meetsRequirement(player));
		questNPC.interact(player);
        assertTrue(player.getActiveQuests().isEmpty());
        assertEquals(Quest.Status.LOCKED, quest.getStatus());
        player.setLevel(5);
//        assertEquals(Quest.Status.AVAILABLE, quest.getStatus());
//        questNPC.interact(player);
//        questNPC.offerQuest(player, quest);
//        questNPC.playerRefuseOffer(player);
//        assertTrue(player.getActiveQuests().isEmpty());
//        assertEquals(Quest.Status.AVAILABLE, quest.getStatus());
//        questNPC.interact(player);
//        questNPC.offerQuest(player);
//        questNPC.playerAcceptsQuest(player);
//        assertTrue(player.getActiveQuests().contains(quest));
//        assertEquals(Quest.Status.ACCEPTED, quest.getStatus());
//        player.kill("goblin");
//        player.kill("goblin");
//        player.kill("goblin");
//        quest.setTimer(599);
//        assertEquals(Quest.Status.SUCCESS_NORMAL, quest.getStatus());
//        questNPC.interact(player);
//        questNPC.giveReward(player, quest);
//        assertTrue(player.getSpellBook().isEmpty());
//		assertEquals(160, player.getExperience());
//		assertTrue(player.getActiveQuests().isEmpty());
//		assertTrue(player.getCompletedQuest().contains(quest));
//		assertEquals(Quest.Status.COMPLETED, quest.getStatus());
	}
}
