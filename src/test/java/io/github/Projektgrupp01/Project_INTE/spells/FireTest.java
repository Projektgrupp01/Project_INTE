package io.github.Projektgrupp01.Project_INTE.spells;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class FireTest {
    
        @Test
        void basicConstructorTest() {
            Fire f = new Fire();
            assertEquals(10, f.getDamage());
            assertEquals(8, f.getEnergyCost());
        }
        @Test
        void customConstructorTest() {
            Fire f = new Fire(1,2,"Fire");
            assertEquals(2, f.getDamage());
            assertEquals(1, f.getEnergyCost());
        }
        @Test
        void negativeEnergyCostException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Fire(-1, 1,"Fire");});
        }
        @Test
        void negativeDamageException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Fire(1, -1, "Fire");});
        }
        @Test
        void ZeroEnergyCostTest() {
            Fire f = new Fire(0,1, "Fire");
            assertEquals(0, f.getEnergyCost());
        }
        @Test
        void ZeroDamageTest() {
            Fire f = new Fire(1,0, "Fire");
            assertEquals(0, f.getDamage());
        }
        @Test
        void getSpellTypeTest() {
            Fire f = new Fire();
            assertEquals(Fire.SpellType.FIRE, f.getSpellType());
        }
        @Test
        void castSpellTest() {
            Fire f = new Fire();
            assertEquals("A fire spell has been casted!", f.castSpell());
        }
        @Test
        void nullNameException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Fire(1, 1, null);});
        }
        @Test
        void emptyNameException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Fire(1, 1, "");});
        }

}
