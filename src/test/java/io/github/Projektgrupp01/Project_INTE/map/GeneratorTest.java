package io.github.Projektgrupp01.Project_INTE.map;

import io.github.Projektgrupp01.Project_INTE.Map.Generator;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import io.github.Projektgrupp01.Project_INTE.equipment.EquipmentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    Generator generator;

    @BeforeEach
    void createGenerator(){
        generator = new Generator();
        generator.addNPCNames("Misan", "Snorkfröken", "My", "Snobben", "Hemulen", "Bisamråttan", "Mumin", "Mårran");
        Equipment treasure = new Equipment("Treasure", EquipmentType.CHEST);
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        generator.addEquipmentTemplates(treasure, sword);
    }

    @Test
    void generateNPCWrongTypeThrowsExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> generator.generateNPC('f', 1));
    }

    @Test
    void generateEquipmentWrongTypeThrowsExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> generator.generateEquipment('f', 1));
    }

    @Test
    void generateWrongAmountOfNPCsThrowsExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> generator.generateNPC('n', -1));
    }

    @Test
    void generateWrongAmountOfEquipmentThrowsExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> generator.generateEquipment('x', -1));
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
    void canAddEquipmentTemplatesTest(){
        Equipment equipment = new Equipment("Mace", EquipmentType.WEAPON);
        generator.addEquipmentTemplates(equipment);
        assertTrue(generator.getEquipmentTemplates().contains(equipment));
    }

    @Test
    void generatorGenerateReturnsNPCList(){
        assertEquals(generator.getNPCs(), generator.generateNPC('n', 1));
    }

    @Test
    void generatorGenerateReturnsEquipmentList(){
        assertEquals(generator.getEquipment(), generator.generateEquipment('x', 1));
    }

    @Test
    void generatorGenerateNPCReturnsCorrectNrOfNPCs(){
        generator.generateNPC('n', 2);
        assertEquals(2, generator.getNPCs().size());
    }

    @Test
    void generatorCreateEquipmentReturnsCorrectNrOfEquipment(){
        generator.generateEquipment('x', 43);
        assertEquals(43, generator.getEquipment().size());
    }

}
