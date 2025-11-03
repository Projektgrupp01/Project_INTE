package io.github.Projektgrupp01.Project_INTE.equipment;

import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.EquipmentDecorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

public class InventoryTest {

    @Test
    void newInventoryIsEmpty() {
        Inventory Inventory = new Inventory();
        assertEquals(0, Inventory.getSize());
    }

    @Test
    void inventoryHasAMaxCapacityOfThirty() {

        Inventory inventory = new Inventory();
        assertEquals(30, inventory.getMaxCapacity());
    }

    @Test
    void canAddAnItemToInventory() {
        Inventory inventory = new Inventory();
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);

        inventory.addItem(sword);

        assertEquals(1, inventory.getSize());
    }

    @Test
    void cannotAddNullObjectToInventory() {
        Inventory inventory = new Inventory();

        try {
            inventory.addItem(null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cannotAddItemIfInventoryIsFull() {
        Inventory inventory = new Inventory(2);

        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        Equipment shield = new Equipment("Shield", EquipmentType.SHIELD);
        Equipment helmet = new Equipment("Helmet", EquipmentType.HELMET);

        inventory.addItem(sword);
        inventory.addItem(shield);

        try {
            inventory.addItem(helmet);
            fail("ExpectedIllegalStateException");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    void canRemoveItemFromInventory() {
        Inventory inventory = new Inventory();

        Equipment sword = new Equipment("sword", EquipmentType.WEAPON);

        inventory.addItem(sword);
        inventory.removeItem(sword);

        assertEquals(0, inventory.getSize());
    }

    @Test
    void cannotRemoveItemNotInInventory() {
        Inventory inventory = new Inventory();
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        Equipment shield = new Equipment("Shield", EquipmentType.SHIELD);
        inventory.addItem(sword);

        try {
            inventory.removeItem(shield);
            fail("Cannot remove item thats not in inventory");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void itemInInventoryReturnsTrue() {
        Inventory inventory = new Inventory();
        Equipment sword = new Equipment("Super sword", EquipmentType.WEAPON);

        inventory.addItem(sword);

        assertTrue(inventory.contains(sword));
    }

    @Test
    void removeAllItems() {
        Inventory inventory = new Inventory();
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        Equipment shield = new Equipment("Shield", EquipmentType.SHIELD);
        Equipment helmet = new Equipment("Helmet", EquipmentType.HELMET);

        inventory.addItem(helmet);
        inventory.addItem(shield);
        inventory.addItem(sword);

        inventory.clear();

        assertEquals(0, inventory.getSize());
    }

    @Test
    void getRemaindingInventorySpaceWorks() {
        Inventory inventory = new Inventory();
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);

        inventory.addItem(sword);
        assertEquals(29, inventory.getRemainingInventorySpace());
    }

    @Test
    void getItemsReturnsAllItemsInInventory() {
        Inventory inventory = new Inventory();
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        Equipment shield = new Equipment("Shield", EquipmentType.SHIELD);
        Equipment helmet = new Equipment("Helmet", EquipmentType.HELMET);

        inventory.addItem(helmet);
        inventory.addItem(sword);
        inventory.addItem(shield);

        List<Equipment> inventoryItems = inventory.getItems();

        assertEquals(3, inventoryItems.size());
        assertTrue(inventoryItems.contains(helmet));
        assertTrue(inventoryItems.contains(sword));
        assertTrue(inventoryItems.contains(shield));
    }

    @Test
    void cannotEquipNullEquipment() {
        Player player = new BasePlayer("Test", 100, 100, 100, 100, 5);

        assertThrows(IllegalArgumentException.class, () -> {
            new EquipmentDecorator(player, null);
        });
    }

}
