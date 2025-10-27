package io.github.Projektgrupp01.Project_INTE.spells;

public class Fire extends Spell {

    public Fire() {
        super(8, 10, "Fire");
    }

    public Fire(int energyCost, int damage, String name) {
        super(energyCost, damage, name);
    }

    @Override
    public SpellType getSpellType() {
        return SpellType.FIRE;
    }

    @Override
    public String castSpell() {
        return "A fire spell has been casted!";
    }

}
