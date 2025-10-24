package io.github.Projektgrupp01.Project_INTE.equipment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
}
