package io.github.Projektgrupp01.Project_INTE;
import io.github.Projektgrupp01.Project_INTE.spells.Fire;
import io.github.Projektgrupp01.Project_INTE.spells.Spell;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;

class PlayerSpellTest {

    private BasePlayer player;
    private Spell fire;
	@BeforeEach
	void setUp() {
		player = new BasePlayer();
        fire = new Fire();
	}
    @Test
    //learnSpell tests
	void playerCanLearnSpell() {
		player.learnSpell(fire);
		assertTrue(player.getSpellBook().contains(fire));
		assertEquals(1, player.getSpellBook().size());
	}
    @Test
    void learnSameSpellTwiceException() {
        player.learnSpell(fire);
        assertThrows(IllegalArgumentException.class,() -> { 
            player.learnSpell(fire);});
    }
    @Test
    void learnNullSpellException(){
        assertThrows(NullPointerException.class, () -> {
            player.learnSpell(null);
        });
    }
    //getSpellbook Tests
    @Test
    void getEmptySpellbookTest(){
        assertEquals(Collections.emptySet(), player.getSpellBook());
    }
    //forgetSpell tests
    @Test
    void canRemoveSpell(){
        player.learnSpell(fire);
        player.forgetSpell(fire);
        assertEquals(Collections.emptySet(), player.getSpellBook());
    }
    @Test
    void forgetNullSpellException(){
        player.learnSpell(fire);
        assertThrows(NullPointerException.class, ()->{
            player.forgetSpell(null);
        });
    }
    @Test
    void removingSpellThatDoesNotExistException(){
        assertThrows(IllegalArgumentException.class, () -> {
            player.forgetSpell(fire);
        });
    }



    
    
    
    
}
