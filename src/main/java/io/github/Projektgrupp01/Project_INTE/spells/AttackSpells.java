package io.github.Projektgrupp01.Project_INTE.spells;

import io.github.Projektgrupp01.Project_INTE.World.WeatherEffect;
import io.github.Projektgrupp01.Project_INTE.World.WorldState;
import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;

public class AttackSpells {

    private AttackSpells() {
    }

    // if damageModifier = 100 then the damage is not modified
    private static void energyDamage(BasePlayer player, BaseNPC npc, Spell spell, int damageModifier) {
        player.useEnergy(spell.getEnergyCost());
        int damage = (int) (spell.getDamage() * (damageModifier / 100.0));
        npc.takeDamage(damage);

    }

    public static void attack(BasePlayer player, BaseNPC npc, Spell spell, WorldState worldState) {
        if (player.getEnergy() >= spell.getEnergyCost() && player.getSpellBook().contains(spell)) {
            double m = WeatherEffect.modifier(spell.getSpellType(), worldState.getWeather());
            switch (spell.getSpellType()) { // switch ifall jag vill lägga till mer funktionalitet i andra spells
                case NATURE:
                    if (player.containsRace("Dwarf") && !player.containsRace("Elf")) {
                        energyDamage(player, npc, spell, (int) (80 * m));
                        return;
                    } else if (player.containsRace("elf")) {
                        energyDamage(player, npc, spell, (int) (140 * m));
                        return;
                    }
                    energyDamage(player, npc, spell, (int) (100 * m));
                    return;
                default:
                    energyDamage(player, npc, spell, (int) (100 * m));
                    return;
            }
        }
        throw new IllegalArgumentException("not enough mana or spellbook does not contain the spell");

    }

}
