package io.github.Projektgrupp01.Project_INTE.equipment;

import java.nio.channels.IllegalSelectorException;

public class Equipment {

    private String name;
    private EquipmentType type;
    private double weight = 0.0;
    private Integer durability;
    private Integer attackDamage;
    private Integer magicDamage;
    private Integer physicalDefense;
    private Integer magicDefense;
    private Integer magicBonus;
    private Integer healthBonus;
    private Integer energyBonus;
    private Integer levelRequirement = 0;

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

    // AttackDamage for weapons
    public void setAttackDamage(int attackDamage) {
        if (type != EquipmentType.WEAPON) {
            throw new IllegalStateException("Only weapons can have attack damage");
        }

        if (attackDamage < 0) {
            throw new IllegalArgumentException("Attack damage cannot be negative");
        }
        this.attackDamage = attackDamage;
    }

    public Integer getAttackDamage() {
        return attackDamage;
    }

    // MagicDamage for weapons
    public void setMagicDamage(int magicDamage) {
        if (type != EquipmentType.WEAPON) {
            throw new IllegalStateException("Only weapons can have magic damage");
        }

        if (magicDamage < 0) {
            throw new IllegalArgumentException("Magic damage cannot be negative");
        }
        this.magicDamage = magicDamage;
    }

    public Integer getMagicDamage() {
        return magicDamage;
    }

    public int getTotalDamage() {
        if (type != EquipmentType.WEAPON) {
            throw new IllegalStateException("Only weapons can have damage");
        }
        int totalDamage = 0;
        if (attackDamage != null) {
            totalDamage += attackDamage;
        }
        if (magicDamage != null) {
            totalDamage += magicDamage;
        }
        return totalDamage;
    }

    // Physical defense for armor
    public void setPhysicalDefense(int physicalDefense) {
        if (type == EquipmentType.WEAPON || type == EquipmentType.RING || type == EquipmentType.AMULET) {
            throw new IllegalStateException("This equipment cannot have defense");
        }
        if (physicalDefense < 0) {
            throw new IllegalArgumentException("Physical defense cannot be negative");
        }
        this.physicalDefense = physicalDefense;
    }

    public Integer getPhysicalDefense() {
        return physicalDefense;
    }

    // Magic defense for armor
    public void setMagicDefense(int magicDefense) {
        if (type == EquipmentType.WEAPON || type == EquipmentType.RING || type == EquipmentType.AMULET) {
            throw new IllegalStateException("This equipment cannot have defense");
        }
        if (magicDefense < 0) {
            throw new IllegalArgumentException("Magic defense cannot be negative");
        }
        this.magicDefense = magicDefense;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public int getTotalDefense() {
        if (type == EquipmentType.WEAPON || type == EquipmentType.RING || type == EquipmentType.AMULET) {
            throw new IllegalStateException("This equipment cannot have defense");
        }
        int totalDefense = 0;
        if (physicalDefense != null) {
            totalDefense += physicalDefense;
        }
        if (magicDefense != null) {
            totalDefense += magicDefense;
        }
        return totalDefense;
    }

    // magic power for amulets and rings
    public void setMagicBonus(int magicBonus) {
        if (type != EquipmentType.RING && type != EquipmentType.AMULET) {
            throw new IllegalStateException("This equipment cannot give magic power");
        }

        if (magicBonus < 0) {
            throw new IllegalArgumentException("Magic bonus cannot be negative");
        }
        this.magicBonus = magicBonus;
    }

    public Integer getMagicBonus() {
        return magicBonus;
    }

    public void setHealthBonus(int healthBonus) {
        if (type != EquipmentType.RING && type != EquipmentType.AMULET) {
            throw new IllegalStateException("This equipment cannot give health bonus");
        }
        if (healthBonus < 0) {
            throw new IllegalArgumentException("Health bonus cannot be negative");
        }
        this.healthBonus = healthBonus;
    }

    public Integer getHealthBonus() {
        return healthBonus;
    }

    public void setEnergyBonus(int energyBonus) {
        if (type != EquipmentType.RING && type != EquipmentType.AMULET) {
            throw new IllegalStateException("This equipment cannot give energy bonus");
        }
        if (energyBonus < 0) {
            throw new IllegalArgumentException("Energy bonus cannot be negative");
        }
        this.energyBonus = energyBonus;
    }

    public Integer getEnergyBonus() {
        return energyBonus;
    }

    public void setLevelRequirement(int levelRequirement) {
        if (levelRequirement < 0) {
            throw new IllegalArgumentException("Level requirement cannot be negative");
        }
        this.levelRequirement = levelRequirement;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

}
