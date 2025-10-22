package io.github.Projektgrupp01.Project_INTE.equipment;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
