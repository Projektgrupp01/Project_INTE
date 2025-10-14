package io.github.Projektgrupp01.Project_INTE.spells;

public class Water implements SpellInterface{
    private int energyCost;
    private int damage;

    public Water(){
        this(6, 8);
    }

    public Water(int energyCost, int damage){
        if(energyCost < 0) {
            throw new IllegalArgumentException("mana cost can't negative");
        }
        if(damage < 0) {
            throw new IllegalArgumentException("damage can't negative");
        }
        this.energyCost = energyCost;
        this.damage = damage;
    }

    @Override
    public int getEnergyCost() {
        return energyCost;
    }

    @Override
    public int getDamage() {
        return damage;
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
