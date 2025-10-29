package io.github.Projektgrupp01.Project_INTE.map;

import io.github.Projektgrupp01.Project_INTE.Map.Generator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    Generator generator;

    @BeforeEach
    void createGenerator(){
        generator = new Generator();
    }

    @Test
    void generateWrongTypeThrowsExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> generator.generate("fel", 1));
    }

    @Test
    void generateWrongAmountThrowsExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> generator.generate("npc", -1));
    }

    @Test
    void canAddNPCNamesTest(){
        generator.addNPCNames("Stefan");
        assertTrue(generator.getNPCNames().contains("Stefan"));
    }

    @Test
    void canAddMultipleNPCNamesTest(){
        String[] names = {"Stefan", "Bertil", "Ålög"};
        generator.addNPCNames(names);
        assertTrue(generator.getNPCNames().containsAll(Arrays.asList(names)));
    }

    @Test
    void generatorGenerateReturnsNPCList(){
        assertEquals(new ArrayList<>(), generator.generate("npc", 1));
    }

    @Test
    void generatorGenerateReturnsEquipmentList(){
        assertEquals(new ArrayList<>(), generator.generate("equipment", 1));
    }
}
