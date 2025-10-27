package io.github.Projektgrupp01.Project_INTE.equipment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class EquipmentTest {

    @Test
    void equipmentHasName() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        assertEquals("Sword", sword.getName());
    }

    @Test
    void equipmentHasType() {
        Equipment helmet = new Equipment("Helmet", EquipmentType.HELMET);
        assertEquals(EquipmentType.HELMET, helmet.getType());
    }

    // equipment weight tests

    @Test
    void equipmentHasZeroWeight() {
        Equipment ring = new Equipment("Ring", EquipmentType.RING);
        assertEquals(0.0, ring.getWeight());
    }

    @Test
    void equipmentWeightCannotBeNegative() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);

        try {
            sword.setWeight(-5.0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void equipmentWeightCanBeSmall() {
        Equipment leafRing = new Equipment("Leaf Ring", EquipmentType.RING);
        leafRing.setWeight(0.1);
        assertEquals(0.1, leafRing.getWeight(), 0.001);
    }

    @Test
    void equipmentWeightBeLarge() {
        Equipment rustyChest = new Equipment("Rusty Chest Plate", EquipmentType.CHEST);
        rustyChest.setWeight(999.9);
        assertEquals(999.9, rustyChest.getWeight(), 0.001);
    }

    // durability tests

    @Test
    void equipmentHasDurability() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        assertTrue(sword.hasDurability());
        assertEquals(100, sword.getDurability());

    }

    @Test
    void ringDoesNotHaveDurability() {
        Equipment ring = new Equipment("Ring", EquipmentType.RING);
        assertFalse(ring.hasDurability());
        assertNull(ring.getDurability());
    }

    @Test
    void equipmentBreaksAtZero() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        sword.takeDamage(100);
        assertTrue(sword.isBroken());
        assertEquals(0, sword.getDurability());
    }

    @Test
    void equipmentDoesNotBreakAtOne() {
        Equipment bow = new Equipment("Bow", EquipmentType.WEAPON);
        bow.takeDamage(99);
        assertFalse(bow.isBroken());
        assertEquals(1, bow.getDurability());
    }

    @Test
    void equipmentTakesDamage() {
        Equipment chestplate = new Equipment("Chest Plate", EquipmentType.CHEST);
        chestplate.takeDamage(30);
        assertEquals(70, chestplate.getDurability());
    }

    @Test
    void equipmentTakingNegativeDamage() {
        Equipment legs = new Equipment("Leg Armor", EquipmentType.LEGS);
        try {
            legs.takeDamage(-50);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void cannotDamageAmulet() {
        Equipment amulet = new Equipment("Amulet", EquipmentType.AMULET);
        try {
            amulet.takeDamage(1);
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {

        }
    }

    // repairing equipment
    @Test
    void equipmentCanBeRepaired() {
        Equipment helmet = new Equipment("Iron Helmet", EquipmentType.HELMET);
        helmet.takeDamage(67);
        helmet.repair(66);
        assertEquals(99, helmet.getDurability());
    }

    @Test
    void cantRepairBeyond100() {
        Equipment boots = new Equipment("Leather boots", EquipmentType.BOOTS);
        boots.takeDamage(5);
        boots.repair(10);
        assertEquals(100, boots.getDurability());
    }

    @Test
    void cannotRepairWithNegativeValues() {
        Equipment gloves = new Equipment("Iron Gloves", EquipmentType.GLOVES);
        gloves.takeDamage(15);
        try {
            gloves.repair(-15);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void cannotRepairAmulet() {
        Equipment amulet = new Equipment("Fire Amulet", EquipmentType.AMULET);
        try {
            amulet.repair(50);
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
        }
    }
}
