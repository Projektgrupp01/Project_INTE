package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PlayerTest {
	@Test
	void playerHas100Health(){
		Player p = new Player();
		assertEquals(p.getHealth(), 100);
	}
	@Test
	void playerHas100Speed(){
		Player p = new Player();
		assertEquals(p.getSpeed(), 100);
	}
	@Test
	void playerHas100Strength() {
		Player p = new Player();
		assertEquals(p.getStrength(), 100);
	}
	@Test
	void playerHas100Energy() {
		Player p = new Player();
		assertEquals(p.getEnergy(), 100);
	}
	@Test
	void playerCanLoseHealth() {
		Player p = new Player();
		p.takeDamage(10);
		assertEquals(p.getHealth(), 90);
	}
	@Test
	void playerCanDie() {
		Player p = new Player();
		p.takeDamage(100);
		assertTrue(p.isDead());
	}
	@Test
	void playerCanBeBuffed() {
		Player p = new Player();
		BuffedPlayer b = new BuffedPlayer();
		assertTrue(b.getHealth > p.getHealth());
	}
}
