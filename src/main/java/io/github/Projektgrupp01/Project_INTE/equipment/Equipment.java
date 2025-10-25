package io.github.Projektgrupp01.Project_INTE.equipment;

public class Equipment {

    private String name;
    private EquipmentType type;
    private double weight = 0.0;
    private Integer durability;

    public Equipment(String name, EquipmentType type) {

        this.name = name;
        this.type = type;

        // Certain equipment types have durability
        if (type == EquipmentType.WEAPON
                || type == EquipmentType.HELMET
                || type == EquipmentType.CHEST
                || type == EquipmentType.LEGS
                || type == EquipmentType.BOOTS
                || type == EquipmentType.GLOVES
                || type == EquipmentType.SHIELD) {

            this.durability = 100; // durability starts at 100
        } else {
            this.durability = null; // rings and amulets
        }

    }

    public String getName() {
        return name;
    }

    public EquipmentType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative!");

        }
        this.weight = weight;
    }

    public boolean hasDurability() {
        return durability != null;
    }

    public Integer getDurability() {
        return durability;
    }

    public void takeDamage(int damage) {
        if (!hasDurability()) {
            throw new IllegalStateException("Can't be broken");
        }
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        this.durability = Math.max(0, this.durability - damage);
    }

    public boolean isBroken() {
        return durability <= 0 && hasDurability();
    }

    public void repair(int amount) {
        if (!hasDurability()) {
            throw new IllegalStateException("This item cannot be repaired");
        }
        if (isBroken()) {
            throw new IllegalStateException("Cannot repair a broken item");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Repair amount cannot be negative");
        }

        this.durability = Math.min(100, this.durability + amount);
    }
}
