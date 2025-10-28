package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;

public class EquipmentDecorator extends PlayerDecorator {

    private Equipment equipment;

    public EquipmentDecorator(Player player, Equipment equipment) {
        super(player);

        if (equipment == null) {
            throw new IllegalArgumentException("Equipment cannot be null");
        }

        if (equipment.getLevelRequirement() > player.getLevel()) {
            throw new IllegalArgumentException("Player too low level to equip " + equipment.getName() + ", " +
                    "Required level: " + equipment.getLevelRequirement() + ", " +
                    "Current level: " + player.getLevel());
        }

        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public int getMaxHealth() {
        int baseMaxHealth = super.getMaxHealth();

        if (equipment.getHealthBonus() != null) {
            return baseMaxHealth + equipment.getHealthBonus();
        }

        return baseMaxHealth;
    }

    public int getMaxEnergy() {
        int baseMaxEnergy = super.getMaxEnergy();

        if (equipment.getEnergyBonus() != null) {
            return baseMaxEnergy + equipment.getEnergyBonus();
        }

        return baseMaxEnergy;
    }

}
