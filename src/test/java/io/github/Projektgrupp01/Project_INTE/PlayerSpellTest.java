package io.github.Projektgrupp01.Project_INTE;
import io.github.Projektgrupp01.Project_INTE.spells.Fire;
import io.github.Projektgrupp01.Project_INTE.spells.Spell;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.TripleHealthDecorator;

public class PlayerSpellTest {
    private BasePlayer player;
    @Test
	void playerCanLearnSpell() {
		Spell fire = new Fire();
		player.learnSpell(fire);
		assertTrue(player.getSpellBook().contains(fire));
		assertEquals(1, player.getSpellBook().size());
	}
    @Test
    void 
    
    
    
    
}
