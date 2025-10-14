package io.github.Projektgrupp01.Project_INTE.spells;

public class Water implements SpellInterface{
    private int manaCost;
    private int damage;

    public Water(){
        this(6, 8);
    }

    public Water(int manaCost, int damage){
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
