package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.spells.Fire;

public class FireTest {
    
        @Test
        void basicConstructorTest() {
            Fire f = new Fire();
            assertEquals(10, f.getDamage());
            assertEquals(8, f.getEnergyCost());
        }
        @Test
        void customConstructorTest() {
            Fire f = new Fire(1,2);
            assertEquals(2, f.getDamage());
            assertEquals(1, f.getEnergyCost());
        }
        @Test
        void negativeEnergyCostException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Fire(-1, 1);});
        }
        @Test
        void negativeDamageException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Fire(1, -1);});
        }
        @Test
        void ZeroEnergyCostTest() {
            Fire f = new Fire(0,1);
            assertEquals(0, f.getEnergyCost());
        }
        @Test
        void ZeroDamageTest() {
            Fire f = new Fire(1,0);
            assertEquals(0, f.getDamage());
    }

}
