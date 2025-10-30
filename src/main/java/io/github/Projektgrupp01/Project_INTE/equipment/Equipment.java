package io.github.Projektgrupp01.Project_INTE.equipment;

import java.nio.channels.IllegalSelectorException;

public class Equipment {

    private static final int MAX_DURABILITY = 100;
    private static final int MIN_DURABILITY = 0;

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

        validateConstructorValues(name, type);
        this.name = name;
        this.type = type;
        this.durability = initializeDurability(type);
    }

    private Integer initializeDurability(EquipmentType type) {
        if (isDurableEquipmentType(type)) {
            return MAX_DURABILITY;
        }
        return null; // Rings and amulets have no durability
    }

    private boolean isDurableEquipmentType(EquipmentType type) {
        return type == EquipmentType.WEAPON
                || type == EquipmentType.HELMET
                || type == EquipmentType.CHEST
                || type == EquipmentType.LEGS
                || type == EquipmentType.BOOTS
                || type == EquipmentType.GLOVES
                || type == EquipmentType.SHIELD;
    }

    private boolean isArmorEquipmentType(EquipmentType type) {
        return type == EquipmentType.HELMET
                || type == EquipmentType.CHEST
                || type == EquipmentType.LEGS
                || type == EquipmentType.BOOTS
                || type == EquipmentType.GLOVES
                || type == EquipmentType.SHIELD;
    }

    private boolean isAccessoryType(EquipmentType type) {
        return type == EquipmentType.RING || type == EquipmentType.AMULET;
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

    // Durability system
    public boolean hasDurability() {
        return durability != null;
    }

    public Integer getDurability() {
        return durability;
    }

    public void takeDamage(int damage) {
        validateHasDurability("take damage");
        validNonNegativeInputs(damage, "Damage");
        this.durability = Math.max(0, this.durability - damage);
    }

    public boolean isBroken() {
        return hasDurability() && durability <= MIN_DURABILITY;
    }

    public void repair(int amount) {
        validateHasDurability("be repaired");
        validateNotBroken();
        validNonNegativeInputs(amount, "Repair amount");

        durability = Math.min(MAX_DURABILITY, durability + amount);
    }

    // Weapon stats system
    public void setAttackDamage(int attackDamage) {
        validateWeaponOnly("have attack damage");
        validNonNegativeInputs(attackDamage, "Attack damage");
        this.attackDamage = attackDamage;
    }

    public Integer getAttackDamage() {
        return attackDamage;
    }

    public void setMagicDamage(int magicDamage) {
        validateWeaponOnly("have magic damage");
        validNonNegativeInputs(magicDamage, "Magic damage");
        this.magicDamage = magicDamage;
    }

    public Integer getMagicDamage() {
        return magicDamage;
    }

    public int getTotalDamage() {
        validateWeaponOnly("have damage");
        int totalDamage = 0;
        if (attackDamage != null) {
            totalDamage += attackDamage;
        }
        if (magicDamage != null) {
            totalDamage += magicDamage;
        }
        return totalDamage;
    }

    // Defense stats system
    public void setPhysicalDefense(int physicalDefense) {
        validateArmorOnly("have defense");
        validNonNegativeInputs(physicalDefense, "Physical defense");
        this.physicalDefense = physicalDefense;
    }

    public Integer getPhysicalDefense() {
        return physicalDefense;
    }

    public void setMagicDefense(int magicDefense) {
        validateArmorOnly("have defense");
        validNonNegativeInputs(magicDefense, "Magic defense");
        this.magicDefense = magicDefense;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public int getTotalDefense() {
        validateArmorOnly("have defense");
        int totalDefense = 0;
        if (physicalDefense != null) {
            totalDefense += physicalDefense;
        }
        if (magicDefense != null) {
            totalDefense += magicDefense;
        }
        return totalDefense;
    }

    // Accessory stats system
    public void setMagicBonus(int magicBonus) {
        validateAccessoryOnly("give magic bonus");
        validNonNegativeInputs(magicBonus, "Magic bonus");
        this.magicBonus = magicBonus;
    }

    public Integer getMagicBonus() {
        return magicBonus;
    }

    public void setHealthBonus(int healthBonus) {
        validateAccessoryOnly("give health bonus");
        validNonNegativeInputs(healthBonus, "Health bonus");
        this.healthBonus = healthBonus;
    }

    public Integer getHealthBonus() {
        return healthBonus;
    }

    public void setEnergyBonus(int energyBonus) {
        validateAccessoryOnly("give energy bonus");
        validNonNegativeInputs(energyBonus, "Energy bonus");
        this.energyBonus = energyBonus;
    }

    public Integer getEnergyBonus() {
        return energyBonus;
    }

    // Level requirement system
    public void setLevelRequirement(int levelRequirement) {
        validNonNegativeInputs(levelRequirement, "Level requirement");
        this.levelRequirement = levelRequirement;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    // Validation helper methods

    private void validateConstructorValues(String name, EquipmentType type) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (type == null) {
            throw new IllegalArgumentException("Equipment type cannot be null");
        }
    }

    private void validateHasDurability(String string) {
        if (!hasDurability()) {
            throw new IllegalStateException("This equipment cannot" + string);
        }
    }

    private void validateNotBroken() {
        if (isBroken()) {
            throw new IllegalStateException("Cannot repair broken: " + name);
        }
    }

    private void validNonNegativeInputs(int value, String parameter) {
        if (value < 0) {
            throw new IllegalArgumentException(parameter + " cannot be negative");
        }
    }

    private void validateWeaponOnly(String damageType) {
        if (type != EquipmentType.WEAPON) {
            throw new IllegalStateException("Only weapons can " + damageType);
        }
    }

    private void validateArmorOnly(String defenseType) {
        if (type != EquipmentType.WEAPON) {
            throw new IllegalStateException("Only weapons can " + defenseType);
        }
    }

    private void validateAccessoryOnly(String bonus) {
        if (!isAccessoryType(type)) {
            throw new IllegalStateException("Only weapons can " + bonus);
        }
    }

}
