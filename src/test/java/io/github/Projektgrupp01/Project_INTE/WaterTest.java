package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.spells.Water;

public class WaterTest {
    
        @Test
        void basicConstructorTest() {
            Water w = new Water();
            assertEquals(8, w.getDamage());
            assertEquals(6, w.getEnergyCost());
            assertEquals("Water", w.getName());
        }
        @Test
        void customConstructorTest() {
            Water w = new Water(1,2, "Water");
            assertEquals(2, w.getDamage());
            assertEquals(1, w.getEnergyCost());
            assertEquals("Water", w.getName());
        }
        @Test
        void negativeEnergyCostException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Water(-1, 1, "Water");});
        }
        @Test
        void negativeDamageException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Water(1, -1, "Water");});
        }
        @Test
        void ZeroEnergyCostTest() {
            Water w = new Water(0,1, "Water");
            assertEquals(0, w.getEnergyCost());
        }
        @Test
        void ZeroDamageTest() {
            Water w = new Water(1,0, "Water");
            assertEquals(0, w.getDamage());
        }
        @Test
        void getSpellTypeTest() {
            Water w = new Water();
            assertEquals(Water.SpellType.WATER, w.getSpellType());
        }
        @Test
        void castSpellTest() {
            Water w = new Water();
            assertEquals("A water spell has been casted!", w.castSpell());
        }
        @Test
        void nullNameException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Water(1, 1, null);});
        }
        @Test
        void emptyNameException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Water(1, 1, "");});
        }

}

