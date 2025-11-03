package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;

public final class EquipmentDecorator extends PlayerDecorator {

    private Equipment equipment;

    public EquipmentDecorator(Player player, Equipment equipment) {
        super(player);

        validateEquipment(equipment);
        validateLevelRequirement(player, equipment);

        this.equipment = equipment;
    }

    private void validateEquipment(Equipment equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("Equipment cannot be null");
        }
    }

    private void validateLevelRequirement(Player player, Equipment equipment) {
        if (equipment.getLevelRequirement() > player.getLevel()) {
            throw new IllegalArgumentException("Player too low level to equip " + equipment.getName() + ", " +
                    "Required level: " + equipment.getLevelRequirement() + ", " +
                    "Current level: " + player.getLevel());
        }
    }

    public Equipment getEquipment() {
        return equipment;
    }

    // Stats modifiers

    public int getMaxHealth() {
        int baseMaxHealth = super.getMaxHealth();

        if (equipment.getHealthBonus() != null) {
            return applyBonus(baseMaxHealth, equipment.getHealthBonus());
        }

        return baseMaxHealth;
    }

    public int getMaxEnergy() {
        int baseMaxEnergy = super.getMaxEnergy();

        if (equipment.getEnergyBonus() != null) {
            return applyBonus(baseMaxEnergy, equipment.getEnergyBonus());
        }

        return baseMaxEnergy;
    }

    private int applyBonus(int baseStat, Integer bonus) {
        if (bonus != null) {
            return baseStat + bonus;
        }
        return baseStat;
    }

}
