package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PlayerDecoratorTest {
	@Test
	void buffedPlayerIncreaseHealth() {
		Player player = new BasePlayer();
		Player buffedPlayer = new BuffedPlayerDecorator(player);
		assertEquals(player.getHealth() * 2, buffedPlayer.getHealth());
	}

	@Test
	void canStackBuffs() {
		Player player = new BasePlayer();
		Player playerBuffedTwice = new BuffedPlayerDecorator(new BuffedPlayer2Decorator(player));
		assertEquals(player.getHealth() * 2 * 3, playerBuffedTwice.getHealth());
		
	}
}
