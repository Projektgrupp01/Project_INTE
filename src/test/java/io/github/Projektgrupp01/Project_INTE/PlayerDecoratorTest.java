package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.DoubleHealthDecorator;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.TripleHealthDecorator;

public class PlayerDecoratorTest {
	@Test
	void buffedPlayerIncreaseHealth() {
		Player player = new BasePlayer();
		Player buffedPlayer = new DoubleHealthDecorator(player);
		assertEquals(player.getHealth() * 2, buffedPlayer.getHealth());
	}

	@Test
	void canStackBuffs() {
		Player player = new BasePlayer();
		Player playerBuffedTwice = new DoubleHealthDecorator(new TripleHealthDecorator(player));
		assertEquals(player.getHealth() * 2 * 3, playerBuffedTwice.getHealth());

	}
}
