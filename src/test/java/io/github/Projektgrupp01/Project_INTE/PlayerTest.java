package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.HalfHealthDecorator;

public class PlayerTest {
	
	private BasePlayer player;
	@BeforeEach
	void setUp() {
		player = new BasePlayer();
	}
	
	
	@Test
	void playerHas100Health() {
		assertEquals(player.getHealth(), 100);
	}

	@Test
	void playerHas100Speed() {
		assertEquals(player.getSpeed(), 100);
	}

	@Test
	void playerHas100Strength() {
		assertEquals(player.getStrength(), 100);
	}

	@Test
	void playerHas100Energy() {
		assertEquals(player.getEnergy(), 100);
	}

	@Test
	void playerCanLoseHealth() {
		player.takeDamage(10);
		assertEquals(player.getHealth(), 90);
	}

	@Test
	void playerDiesAtZeroHealth() {
		player.takeDamage(100);
		assertTrue(player.isDead());
	}

	@Test
	void playerCanBeBuffed() {
		HalfHealthDecorator buffedPlayer = new HalfHealthDecorator(player);
		assertTrue(buffedPlayer.getHealth() > player.getHealth());
	}
}
