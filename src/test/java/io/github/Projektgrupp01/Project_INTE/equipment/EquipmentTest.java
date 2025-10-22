package io.github.Projektgrupp01.Project_INTE.equipment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EquipmentTest {

    @Test
    void equiptmentHasName() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        assertEquals("Sword", sword.getName());
    }

    @Test equiptmentHasType() {
        Equipment helmet = new Equipment("Helmet", EquipmentType.HELMET);
        assertEquals(EquipmentType.HELMET, helmet.getType());
    }
}
