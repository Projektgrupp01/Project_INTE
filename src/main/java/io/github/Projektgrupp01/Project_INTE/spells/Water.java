package io.github.Projektgrupp01.Project_INTE.spells;

public class Water extends Spell {

    public Water() {
        super(6, 8, "Water");
    }

    public Water(int energyCost, int damage, String name) {
        super(energyCost, damage, name);
    }

    @Override
    public SpellType getSpellType() {
        return SpellType.WATER;
    }

    @Override
    public String castSpell() {
        return "A water spell has been casted!";
    }

}
