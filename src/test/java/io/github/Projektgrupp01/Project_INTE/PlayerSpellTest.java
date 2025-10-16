package io.github.Projektgrupp01.Project_INTE;
import io.github.Projektgrupp01.Project_INTE.spells.Fire;
import io.github.Projektgrupp01.Project_INTE.spells.Spell;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;

public class PlayerSpellTest {
    Spell fire = new Fire();
    @BeforeEach
    @Test
	void playerCanLearnSpell() {
        BasePlayer player = new BasePlayer();
		player.learnSpell(fire);
		assertTrue(player.getSpellBook().contains(fire));
		assertEquals(1, player.getSpellBook().size());
	}
    @Test
    void negativeEnergyCostException() {
        BasePlayer player = new BasePlayer();
        player.learnSpell(fire);
        assertThrows(IllegalArgumentException.class,() -> { 
            player.learnSpell(fire);;});
    }
    @Test
    void canRemoveSpell(){
        BasePlayer player = new BasePlayer();
        player.learnSpell(fire);
        player.forgetSpell(fire);
        assertEquals(Collections.emptySet(), player.getSpellBook());
    }
    @Test
    void removingSpellThatDoesNotExistException(){
        BasePlayer player = new BasePlayer();
        assertThrows(IllegalArgumentException.class, () -> {
            player.forgetSpell(fire);
        });
    }

    
    
    
    
}
