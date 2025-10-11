package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class HelloTest {
    @Test
    void testGreet() {
        assertEquals("Hello, world!", Hello.greet());
    }
}