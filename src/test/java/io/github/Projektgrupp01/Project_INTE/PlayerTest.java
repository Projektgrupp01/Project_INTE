package io.github.Projektgrupp01.Project_INTE;
import io.github.Projektgrupp01.Project_INTE.spells.Fire;
import io.github.Projektgrupp01.Project_INTE.spells.Spell;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.HalfHealthDecorator;

class PlayerTest {
	
	private BasePlayer player;
	@BeforeEach
	void setUp() {
		player = new BasePlayer();
	}
	
	
	@Test
	void playerHas100Health() {
		assertEquals(100, player.getHealth());
	}

	@Test
	void playerHas100Speed() {
		assertEquals(100, player.getSpeed());
	}

	@Test
	void playerHas100Strength() {
		assertEquals(100, player.getStrength());
	}

	@Test
	void playerHas100Energy() {
		assertEquals(100, player.getEnergy());
	}

	@Test
	void playerCanLoseHealth() {
		player.takeDamage(10);
		assertEquals(90, player.getHealth());
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
	@Test
	void playerCanLearnSpell() {
		BasePlayer p = new BasePlayer();
		Spell fire = new Fire();
		p.learnSpell(fire);
		assertTrue(p.getSpellBook().contains(fire));
		assertEquals(1, p.getSpellBook().size());
	}		
}
