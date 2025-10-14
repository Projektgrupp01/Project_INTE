package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.Spells.Fire;

public class FireTest {
    
        @Test
        void basicConstructorTest() {
            Fire f = new Fire();
            assertEquals(10, f.getDamage());
            assertEquals(8, f.getManaCost());
        }
        @Test
        void customConstructorTest() {
            Fire f = new Fire(1,2);
            assertEquals(2, f.getDamage());
            assertEquals(1, f.getManaCost());
        }
        @Test
        void negativeManaCostException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Fire(-1, 1);});
        }
        @Test
        void negativeDamageException() {
            assertThrows(IllegalArgumentException.class,() -> { 
                new Fire(1, -1);});
        }
        @Test
        void ZeroManaCostTest() {
            Fire f = new Fire(0,1);
            assertEquals(0, f.getManaCost());
        }
        @Test
        void ZeroDamageTest() {
            Fire f = new Fire(1,0);
            assertEquals(0, f.getDamage());
    }

}
