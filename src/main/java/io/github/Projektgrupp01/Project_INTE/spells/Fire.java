package io.github.Projektgrupp01.Project_INTE.spells;

import java.util.Objects;

public class Fire implements SpellInterface{
    private int manaCost;
    private int damage;

    public Fire(){
        this(8, 10);
    }

    public Fire(int manaCost, int damage){
        if(manaCost < 0) {
            throw new IllegalArgumentException("mana cost can't negative");
        }
        if(damage < 0) {
            throw new IllegalArgumentException("damage can't negative");
        }
        this.manaCost = manaCost;
        this.damage = damage;
        
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }

    @Override
    public int getDamage() {
        return damage;
    }

}
