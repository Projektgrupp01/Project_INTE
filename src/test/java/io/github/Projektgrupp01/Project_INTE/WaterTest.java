package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.Spells.Water;

public class WaterTest {
    
        @Test
        void basicConstructorTest() {
            Water w = new Water();
            assertEquals(8, w.getDamage());
            assertEquals(6, w.getManaCost());
        }
        @Test
        void customConstructorTest() {
            Water w = new Water(1,2);
            assertEquals(2, w.getDamage());
            assertEquals(1, w.getManaCost());
        }
        @Test
        void negativeManaCostException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Water(-1, 1);});
        }
        @Test
        void negativeDamageException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Water(1, -1);});
        }
        @Test
        void ZeroManaCostTest() {
            Water w = new Water(0,1);
            assertEquals(0, w.getManaCost());
        }
        @Test
        void ZeroDamageTest() {
            Water w = new Water(1,0);
            assertEquals(0, w.getDamage());
    }

}

