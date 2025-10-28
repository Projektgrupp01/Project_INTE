package io.github.Projektgrupp01.Project_INTE.spells;

public class Nature extends Spell {

    public Nature() {
        super(5, 7, "nature");

    }

    public Nature(int energyCost, int damage, String name) {
        super(energyCost, damage, name);
    }

    @Override
    public SpellType getSpellType() {
        return SpellType.NATURE;
    }

    @Override
    public String castSpell() {
        return "A nature spell has been casted!";
    }

}
