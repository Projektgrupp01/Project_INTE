package io.github.Projektgrupp01.Project_INTE.spells;

public abstract class Spell {
    private int energyCost;
    private int damage;
    private String name;

    public enum SpellType {
        FIRE, WATER, NATURE
    }

    protected Spell(int energyCost, int damage, String name) {
        if (energyCost < 0) {
            throw new IllegalArgumentException("mana cost can't negative");
        }
        if (damage < 0) {
            throw new IllegalArgumentException("damage can't negative");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name can't be null or empty");
        }
        this.energyCost = energyCost;
        this.damage = damage;
        this.name = name;

    }

    public int getEnergyCost() {
        return energyCost;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public abstract SpellType getSpellType();

    public abstract String castSpell();

}
