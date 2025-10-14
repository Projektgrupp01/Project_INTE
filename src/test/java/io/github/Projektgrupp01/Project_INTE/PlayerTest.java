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
}
