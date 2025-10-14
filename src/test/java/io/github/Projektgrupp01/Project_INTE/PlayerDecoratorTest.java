package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PlayerDecoratorTest {
	@Test
	void buffedPlayerIncreaseHealth() {
		PlayerInterface player = new Player();
		PlayerInterface buffedPlayer = new BuffedPlayerDecorator(player);
		assertEquals(player.getHealth() * 2, buffedPlayer.getHealth());
	}

	@Test
	void canStackBuffs() {
		PlayerInterface player = new Player();
		PlayerInterface playerBuffedTwice = new BuffedPlayerDecorator(new BuffedPlayer2Decorator(player));
		assertEquals(player.getHealth() * 2 * 3, playerBuffedTwice.getHealth());
		
	}
}
