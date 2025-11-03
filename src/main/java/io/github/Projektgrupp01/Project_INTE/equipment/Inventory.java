package io.github.Projektgrupp01.Project_INTE.equipment;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public final class Inventory {

    private static final int DEFAULT_MAX_CAPACITY = 30;
    private int maxCapacity;
    private List<Equipment> inventoryItems;

    public Inventory() {
        this(DEFAULT_MAX_CAPACITY);
    }

    public Inventory(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Max capacity must be bigger than 0");
        }

        this.maxCapacity = maxCapacity;
        this.inventoryItems = new ArrayList<>();
    }

    public int getSize() {
        return inventoryItems.size();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void addItem(Equipment equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("Cannot add null object");
        }

        if (isFull()) {
            throw new IllegalStateException("Inventory is full");
        }
        inventoryItems.add(equipment);

    }

    public void removeItem(Equipment equipment) {
        if (!inventoryItems.contains(equipment)) {
            throw new IllegalArgumentException("Item does not exist in inventory");
        }
        inventoryItems.remove(equipment);
    }

    public boolean isFull() {
        return inventoryItems.size() >= maxCapacity;
    }

    public boolean contains(Equipment equipment) {
        return inventoryItems.contains(equipment);
    }

    public void clear() {
        inventoryItems.clear();
    }

    public int getRemainingInventorySpace() {
        return maxCapacity - inventoryItems.size();
    }

    public List<Equipment> getItems() {
        return Collections.unmodifiableList(inventoryItems);
    }
}
