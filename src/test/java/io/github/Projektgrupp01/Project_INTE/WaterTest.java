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
        }
        @Test
        void customConstructorTest() {
            Water w = new Water(1,2);
            assertEquals(2, w.getDamage());
            assertEquals(1, w.getEnergyCost());
        }
        @Test
        void negativeEnergyCostException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Water(-1, 1);});
        }
        @Test
        void negativeDamageException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Water(1, -1);});
        }
        @Test
        void ZeroEnergyCostTest() {
            Water w = new Water(0,1);
            assertEquals(0, w.getEnergyCost());
        }
        @Test
        void ZeroDamageTest() {
            Water w = new Water(1,0);
            assertEquals(0, w.getDamage());
    }

}

