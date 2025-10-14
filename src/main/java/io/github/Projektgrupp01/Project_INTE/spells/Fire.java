package io.github.Projektgrupp01.Project_INTE.spells;

public class Fire implements SpellInterface{
    private int energyCost;
    private int damage;

    public Fire(){
        this(8, 10);
    }

    public Fire(int energyCost, int damage){
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
        return SpellType.FIRE;
    }

}
