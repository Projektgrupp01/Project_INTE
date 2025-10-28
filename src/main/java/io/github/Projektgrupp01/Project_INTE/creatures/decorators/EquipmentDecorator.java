package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;

public class EquipmentDecorator extends PlayerDecorator {

    private Equipment equipment;

    public EquipmentDecorator(Player player, Equipment equipment) {
        super(player);
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }
}
