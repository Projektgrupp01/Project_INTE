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
        generator.addEquipmentNames("Sak", "Ting", "Grej");
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

    @Disabled
    @Test
    void canAddEquipmentTest(){
        Equipment equipment = new Equipment("Sword", EquipmentType.WEAPON);
        generator.addEquipment(equipment);
        assertTrue(generator.getEquipment().contains(equipment));
    }

    @Test
    void generatorGenerateReturnsNPCList(){
        assertEquals(generator.getNPCs(), generator.generate("npc", 1));
    }

    @Test
    void generatorGenerateReturnsEquipmentList(){
        assertEquals(generator.getEquipment(), generator.generate("equipment", 1));
    }

    @Test
    void generatorGenerateNPCReturnsCorrectNrOfNPCs(){
        generator.generate("npc", 2);
        assertEquals(2, generator.getNPCs().size());
    }

    @Test
    void generatorCreateEquipmentReturnsCorrectNrOfEquipment(){
        generator.generate("equipment", 43);
        assertEquals(43, generator.getEquipment().size());
    }

    //borde göra test för att kontrollera
}
