package io.github.Projektgrupp01.Project_INTE.damageCalc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.World.WorldState;
import io.github.Projektgrupp01.Project_INTE.World.WorldState.Weather;
import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC.Disposition;
import io.github.Projektgrupp01.Project_INTE.races.Dwarf;
import io.github.Projektgrupp01.Project_INTE.races.Elf;
import io.github.Projektgrupp01.Project_INTE.races.Race;
import io.github.Projektgrupp01.Project_INTE.spells.SpellDamageCalculator;
import io.github.Projektgrupp01.Project_INTE.spells.Fire;
import io.github.Projektgrupp01.Project_INTE.spells.Nature;
import io.github.Projektgrupp01.Project_INTE.spells.Spell;

class AttackSpellsRaceTest {
    BasePlayer player;
    Spell nature;
    Spell fire;
    BaseNPC npc;
    Race dwarf;
    Race elf;
    WorldState worldState;

    @BeforeEach
    void setup() {
        player = new BasePlayer();
        nature = new Nature();
        fire = new Fire();
        npc = new BaseNPC("monster", 100, Disposition.HOSTILE);
        dwarf = new Dwarf();
        elf = new Elf();
        player.learnSpell(nature);
        player.learnSpell(fire);
        worldState = new WorldState(Weather.CLOUDY);
    }

    @Test
    void otherRaceNatureIsNormal() {
        SpellDamageCalculator.attack(player, npc, nature, worldState);
        assertEquals(93, npc.getHealth());
    }

    @Test
    void dwarfNatureIsWeak() {
        player.addRace(dwarf);
        SpellDamageCalculator.attack(player, npc, nature, worldState);
        assertEquals(95, npc.getHealth());
    }

    @Test
    void elfNatureIsStrong() {
        player.addRace(elf);
        SpellDamageCalculator.attack(player, npc, nature, worldState);
        assertEquals(91, npc.getHealth());
    }

    @Test
    void otherRaceFireIsNormal() {
        SpellDamageCalculator.attack(player, npc, fire, worldState);
        assertEquals(90, npc.getHealth());
    }
    @Test
    void playerHasTwoRaces() {
        player.addRace(elf);
        player.addRace(dwarf);
        SpellDamageCalculator.attack(player, npc, nature, worldState);
        assertEquals(91, npc.getHealth());
    }
    @Test
    void noEnergyExceptionThrows() {
        player.addRace(elf);
        player.setEnergy(1);
        assertThrows(IllegalArgumentException.class, () -> {
            SpellDamageCalculator.attack(player, npc, nature, worldState);
        });
        assertEquals(1, player.getEnergy());
        assertEquals(100, npc.getHealth());
    }
    @Test
    void noSpellExceptionThrows() {
        player.addRace(elf);
        player.forgetSpell(nature);
        assertThrows(IllegalArgumentException.class, () -> {
            SpellDamageCalculator.attack(player, npc, nature, worldState);
        });
    }
    @Test
    void castSpellAsHumanThenElf(){
        SpellDamageCalculator.attack(player, npc, nature, worldState);
        assertEquals(93, npc.getHealth());
        player.addRace(elf);
        SpellDamageCalculator.attack(player, npc, nature, worldState);
        assertEquals(84, npc.getHealth());
    }

}
