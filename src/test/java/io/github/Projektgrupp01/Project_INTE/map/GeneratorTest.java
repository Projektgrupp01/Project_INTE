package io.github.Projektgrupp01.Project_INTE.map;

import io.github.Projektgrupp01.Project_INTE.Map.Generator;
import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import io.github.Projektgrupp01.Project_INTE.equipment.EquipmentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    Generator generator;

    @BeforeEach
    void createGenerator() {
        generator = new Generator();
        generator.addNPCNames("Misan", "Snorkfröken", "My", "Snobben", "Hemulen", "Bisamråttan", "Mumin", "Mårran");
        Equipment treasure = new Equipment("Treasure", EquipmentType.CHEST);
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        generator.addEquipmentTemplates(treasure, sword);
    }

    @Test
    void canAddNPCNamesTest() {
        generator.addNPCNames("Stefan");
        assertTrue(generator.getNPCNames().contains("Stefan"));
    }

    @Test
    void canAddMultipleNPCNamesTest() {
        String[] names = {"Stefan", "Bertil", "Ålög"};
        generator.addNPCNames(names);
        assertTrue(generator.getNPCNames().containsAll(Arrays.asList(names)));
    }

    @Test
    void canAddEquipmentTemplatesTest() {
        Equipment equipment = new Equipment("Mace", EquipmentType.WEAPON);
        generator.addEquipmentTemplates(equipment);
        assertTrue(generator.getEquipmentTemplates().contains(equipment));
    }

    @Test
    void generatorReturnsNPCList() {
        generator.generateNPC();
        generator.generateNPC();
        assertEquals(2, generator.getNPCs().size());
    }

    @Test
    void generatorNPCListContainsNPC() {
        BaseNPC NPC = generator.generateNPC();
        assertEquals(NPC, generator.getNPCs().getFirst());
    }

    @Test
    void generatorEquipmentListContainsEquipment() {
        Equipment equipment = generator.generateEquipment();
        assertEquals(equipment, generator.getEquipment().getFirst());
    }

    @Test
    void generatorGenerateNPCReturnsCorrectNrOfNPCs() {
        for (int i = 0; i < 7; i++) {
            generator.generateNPC();
        }
        assertEquals(7, generator.getNPCs().size());
    }

    @Test
    void generatorGenerateEquipmentReturnsCorrectNrOfEquipment() {
        for (int i = 0; i < 43; i++) {
            generator.generateEquipment();
        }
        assertEquals(43, generator.getEquipment().size());
    }

}
