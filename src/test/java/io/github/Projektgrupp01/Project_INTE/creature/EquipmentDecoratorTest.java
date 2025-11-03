package io.github.Projektgrupp01.Project_INTE.creature;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
        Player player = new BasePlayer("Protagonist", 100, 100, 100, 100, 5);
        Equipment ring = new Equipment("Ring of Life", EquipmentType.RING);

        ring.setHealthBonus(25);
        EquipmentDecorator decorated = new EquipmentDecorator(player, ring);
        assertEquals(100, decorated.getHealth());
        assertEquals(125, decorated.getMaxHealth());
    }

    @Test
    void healthBonusDoesNotIncreaseCurrentHealth() {
        Player player = new BasePlayer("Protagonist", 100, 100, 100, 100, 5);

        Equipment ring = new Equipment("Ring of Life", EquipmentType.RING);
        ring.setHealthBonus(25);
        EquipmentDecorator decorator = new EquipmentDecorator(player, ring);

        assertEquals(100, decorator.getHealth());
        assertEquals(125, decorator.getMaxHealth());

    }

    @Test
    void decoratorWithNullHealthBonus() {
        Player player = new BasePlayer("Protagonist", 100, 100, 100, 100, 5);
        Equipment ring = new Equipment("Cosmetic Ring", EquipmentType.RING);
        EquipmentDecorator decorator = new EquipmentDecorator(player, ring);

        assertEquals(100, decorator.getMaxHealth());
    }

    @Test
    void energyBonusIncreasesMaxEnergy() {
        Player player = new BasePlayer("Protagonist", 100, 100, 100, 100, 5);
        Equipment amulet = new Equipment("Amulet of Energy", EquipmentType.AMULET);

        amulet.setEnergyBonus(25);
        EquipmentDecorator decorator = new EquipmentDecorator(player, amulet);

        assertEquals(100, decorator.getEnergy());
        assertEquals(125, decorator.getMaxEnergy());
    }

    @Test
    void canUseMultipleEquipmentDecorators() {
        Player player = new BasePlayer("Protagonist", 100, 100, 100, 100, 5);

        Equipment ring = new Equipment("Ring of Life", EquipmentType.RING);
        ring.setHealthBonus(10);

        Equipment amulet = new Equipment("Amulet of Life", EquipmentType.AMULET);
        amulet.setHealthBonus(15);

        EquipmentDecorator withRing = new EquipmentDecorator(player, ring);
        EquipmentDecorator withBoth = new EquipmentDecorator(withRing, amulet);

        assertEquals(100, player.getMaxHealth());
        assertEquals(110, withRing.getMaxHealth());
        assertEquals(125, withBoth.getMaxHealth());

    }

    @Test
    void cannotEquipItemAbovePlayerLevel() {
        Player player = new BasePlayer("Protagonist", 100, 100, 100, 100, 4);

        Equipment sword = new Equipment("Iron Sword", EquipmentType.WEAPON);
        sword.setLevelRequirement(5);

        assertThrows(IllegalArgumentException.class,
                () -> new EquipmentDecorator(player, sword));
    }

    @Test
    void canEquipItemAtExactLevel() {
        Player player = new BasePlayer("Protagonist", 100, 100, 100, 100, 5);

        Equipment sword = new Equipment("Iron Sword", EquipmentType.WEAPON);
        sword.setLevelRequirement(5);

        assertDoesNotThrow(() -> new EquipmentDecorator(player, sword));
    }

    @Test
    void canEquipItemAtLevelAboveRequirement() {
        Player player = new BasePlayer("Protagonist", 100, 100, 100, 100, 6);
        Equipment sword = new Equipment("Iron Sword", EquipmentType.WEAPON);
        sword.setLevelRequirement(5);

        assertDoesNotThrow(() -> new EquipmentDecorator(player, sword));
    }

    @Test
    void canEquipItemAtMinimumValidLevel() {
        Player player = new BasePlayer("Starter Protagonist", 100, 100, 100, 100, 1);
        Equipment ring = new Equipment("Starter Ring", EquipmentType.RING);
        ring.setLevelRequirement(1);

        assertDoesNotThrow(() -> new EquipmentDecorator(player, ring));
    }

    @Test
    void canEquipItemAtMaximumValidLevel() {
        Player player = new BasePlayer("Master Progagonist", 100, 100, 100, 100, 10);

        Equipment legendary = new Equipment("Master Blade", EquipmentType.WEAPON);
        legendary.setLevelRequirement(10);

        assertDoesNotThrow(() -> new EquipmentDecorator(player, legendary));
    }

    @Test
    void cannotEquipItemJustBelowRequirement() {
        Player player = new BasePlayer("Protagonist", 100, 100, 100, 100, 4);

        Equipment sword = new Equipment("Level 5 Sword", EquipmentType.WEAPON);
        sword.setLevelRequirement(5);

        assertThrows(IllegalArgumentException.class,
                () -> new EquipmentDecorator(player, sword));
    }

    @Test
    void canEquipItemWithNoLevelRequirement() {
        Player player = new BasePlayer("Starter Protagonist", 100, 100, 100, 100, 1);

        Equipment ring = new Equipment("Cosmetic Ring", EquipmentType.RING);
        ring.setLevelRequirement(0);

        EquipmentDecorator equipped = new EquipmentDecorator(player, ring);

        assertEquals(ring, equipped.getEquipment());
        assertEquals(0, ring.getLevelRequirement());
    }

    @Test
    void canGetEquippedItem() {
        Player player = new BasePlayer("Emptyhanded Protagonist", 100, 100, 100, 100, 1);
        Equipment ring = new Equipment("Ring", EquipmentType.RING);
        EquipmentDecorator decorated = new EquipmentDecorator(player, ring);
        assertEquals(ring, decorated.getEquipment());
    }

}
