package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.HalfHealthDecorator;

public class PlayerTest {
	@Test
	void playerHas100Health() {
		BasePlayer p = new BasePlayer();
		assertEquals(p.getHealth(), 100);
	}

	@Test
	void playerHas100Speed() {
		BasePlayer p = new BasePlayer();
		assertEquals(p.getSpeed(), 100);
	}

	@Test
	void playerHas100Strength() {
		BasePlayer p = new BasePlayer();
		assertEquals(p.getStrength(), 100);
	}

	@Test
	void playerHas100Energy() {
		BasePlayer p = new BasePlayer();
		assertEquals(p.getEnergy(), 100);
	}

	@Test
	void playerCanLoseHealth() {
		BasePlayer p = new BasePlayer();
		p.takeDamage(10);
		assertEquals(p.getHealth(), 90);
	}

	@Test
	void playerCanDie() {
		BasePlayer p = new BasePlayer();
		p.takeDamage(100);
		assertTrue(p.isDead());
	}

	@Test
	void playerCanBeBuffed() {
		BasePlayer p = new BasePlayer();
		HalfHealthDecorator b = new HalfHealthDecorator(p);
		assertTrue(b.getHealth() > p.getHealth());
	}
}
