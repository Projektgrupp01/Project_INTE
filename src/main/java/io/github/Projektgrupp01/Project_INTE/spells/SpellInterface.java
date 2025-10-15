package io.github.Projektgrupp01.Project_INTE.spells;

public interface SpellInterface {
    enum SpellType {
        FIRE, WATER
    }
    
    int getEnergyCost();
    int getDamage();
    SpellType getSpellType();
    String castSpell();
}
