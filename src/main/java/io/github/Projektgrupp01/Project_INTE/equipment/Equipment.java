package io.github.Projektgrupp01.Project_INTE.equipment;

public class Equipment {

    private String name;
    private EquipmentType type;

    public Equipment(String name, EquipmentType type) {

        this.name = name;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public EquipmentType getType() {
        return type;
    }
}
