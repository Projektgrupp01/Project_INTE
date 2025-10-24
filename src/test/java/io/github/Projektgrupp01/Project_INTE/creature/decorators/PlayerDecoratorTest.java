package io.github.Projektgrupp01.Project_INTE.creature.decorators;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.HalfHealthDecorator;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.TripleHealthDecorator;

public class PlayerDecoratorTest {
	@Test
	void playerCanBeDecorated() {
		Player player = new BasePlayer();
		Player buffedPlayer = new TripleHealthDecorator(player);
		assertEquals(player.getHealth() * 3, buffedPlayer.getHealth());
	}

	@Test
	void canStackDecorations() {
		Player player = new BasePlayer();
		Player playerBuffedTwice = new HalfHealthDecorator(new TripleHealthDecorator(player));
		assertEquals(player.getHealth() / 2 * 3, playerBuffedTwice.getHealth());

	}
}
