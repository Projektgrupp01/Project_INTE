package io.github.Projektgrupp01.Project_INTE.creature;
import io.github.Projektgrupp01.Project_INTE.spells.Fire;
import io.github.Projektgrupp01.Project_INTE.spells.Nature;
import io.github.Projektgrupp01.Project_INTE.spells.Spell;
import io.github.Projektgrupp01.Project_INTE.spells.Water;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;

class PlayerSpellTest {

    private BasePlayer player;
    private Spell fire;
    private Spell water;
    private Spell nature;
	@BeforeEach
	void setUp() {
		player = new BasePlayer();
        fire = new Fire();
        water = new Water();
        nature = new Nature();
	}
    @Test
    //learnSpell tests
	void playerCanLearnSpell() {
		player.learnSpell(fire);
		assertTrue(player.getSpellBook().contains(fire));
		assertEquals(1, player.getSpellBook().size());
	}
    @Test
    void playerCanLearnManySpells() {
		player.learnSpell(fire);
        player.learnSpell(water);
        player.learnSpell(nature);
		assertTrue(player.getSpellBook().contains(fire));
        assertTrue(player.getSpellBook().contains(water));
        assertTrue(player.getSpellBook().contains(nature));
		assertEquals(3, player.getSpellBook().size());
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
