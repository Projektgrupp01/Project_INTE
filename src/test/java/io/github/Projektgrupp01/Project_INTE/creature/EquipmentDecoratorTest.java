package io.github.Projektgrupp01.Project_INTE.creature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.EquipmentDecorator;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import io.github.Projektgrupp01.Project_INTE.equipment.EquipmentType;

public class EquipmentDecoratorTest {

    @Test
    void decoratorWrapsPlayer() {
        Player player = new BasePlayer("Main Character", 100, 100, 100, 100, 5);
        Equipment ring = new Equipment("Ring", EquipmentType.RING);
        Player decorated = new EquipmentDecorator(player, ring);

        assertNotNull(decorated);
        assertTrue(decorated.getName().contains("Main Character"));
    }

    @Test
    void decoratorKeepsCurrentStats() {
        Player player = new BasePlayer("Protagonist", 100, 100, 100, 100, 5);
        Equipment ring = new Equipment("Basic Ring", EquipmentType.RING);
        Player decorated = new EquipmentDecorator(player, ring);

        assertEquals(100, decorated.getHealth());
        assertEquals(100, decorated.getSpeed());
        assertEquals(100, decorated.getStrength());
        assertEquals(100, decorated.getEnergy());
    }

    @Test
    void healthBonusIncreasesMaxHealth() {
        Player player = new BasePlayer("Protaonist", 100, 100, 100, 100, 5);
        Equipment ring = new Equipment("Ring of Life", EquipmentType.RING);

        ring.setHealthBonus(25);
        EquipmentDecorator decorated = new EquipmentDecorator(player, ring);
        assertEquals(100, decorated.getHealth());
        assertEquals(125, decorated.getMaxHealth());
    }

}
