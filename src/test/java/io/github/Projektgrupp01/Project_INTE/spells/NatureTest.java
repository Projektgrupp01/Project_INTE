package io.github.Projektgrupp01.Project_INTE.spells;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class NatureTest {
    
        @Test
        void basicConstructorTest() {
            Nature n = new Nature();
            assertEquals(7, n.getDamage());
            assertEquals(5, n.getEnergyCost());
        }
        @Test
        void customConstructorTest() {
            Nature n = new Nature(1,2,"Nature");
            assertEquals(2, n.getDamage());
            assertEquals(1, n.getEnergyCost());
        }
        @Test
        void negativeEnergyCostException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Nature(-1, 1,"Nature");});
        }
        @Test
        void negativeDamageException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Nature(1, -1, "Nature");});
        }
        @Test
        void ZeroEnergyCostTest() {
            Nature n = new Nature(0,1, "Nature");
            assertEquals(0, n.getEnergyCost());
        }
        @Test
        void ZeroDamageTest() {
            Nature n = new Nature(1,0, "Nature");
            assertEquals(0, n.getDamage());
        }
        @Test
        void getSpellTypeTest() {
            Nature n = new Nature();
            assertEquals(Nature.SpellType.NATURE, n.getSpellType());
        }
        @Test
        void castSpellTest() {
            Nature n = new Nature();
            assertEquals("A nature spell has been casted!", n.castSpell());
        }
        @Test
        void nullNameException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Nature(1, 1, null);});
        }
        @Test
        void emptyNameException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Nature(1, 1, "");});
        }

}
