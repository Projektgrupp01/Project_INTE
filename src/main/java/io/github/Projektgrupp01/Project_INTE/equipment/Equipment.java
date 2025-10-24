package io.github.Projektgrupp01.Project_INTE.equipment;

public class Equipment {

    private String name;
    private EquipmentType type;
    private double weight = 0.0;

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative!");

        }
        this.weight = weight;
    }
}
