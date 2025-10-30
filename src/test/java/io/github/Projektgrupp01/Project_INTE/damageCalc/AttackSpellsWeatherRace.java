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
import io.github.Projektgrupp01.Project_INTE.spells.Water;

class AttackSpellsWeatherRace {
    BasePlayer player;
    Spell nature, fire, water;
    BaseNPC npc;
    Race dwarf, elf;
    WorldState stateSunny, stateStorm, stateCloudy, stateRain;

    @BeforeEach
    void setup() {
        player = new BasePlayer();
        nature = new Nature();
        fire = new Fire();
        water = new Water();
        npc = new BaseNPC("monster", 100, Disposition.HOSTILE);
        dwarf = new Dwarf();
        elf = new Elf();
        player.learnSpell(nature);
        player.learnSpell(fire);
        player.learnSpell(water);
        stateSunny = new WorldState(Weather.SUNNY);
        stateStorm = new WorldState(Weather.STORM);
        stateCloudy = new WorldState(Weather.CLOUDY);
        stateRain = new WorldState(Weather.RAIN);
    }

    @Test
    void elfNatureSunny() {
        player.addRace(elf);
        SpellDamageCalculator.attack(player, npc, nature, stateSunny);
        assertEquals(89, npc.getHealth());
    }

    @Test
    void elfNatureStorm() {
        player.addRace(elf);
        SpellDamageCalculator.attack(player, npc, nature, stateStorm);
        assertEquals(93, npc.getHealth());
    }

    @Test
    void dwarfNatureSunny() {
        player.addRace(dwarf);
        SpellDamageCalculator.attack(player, npc, nature, stateSunny);
        assertEquals(94, npc.getHealth());
    }

    @Test
    void dwarfNatureStorm() {
        player.addRace(dwarf);
        SpellDamageCalculator.attack(player, npc, nature, stateStorm);
        assertEquals(96, npc.getHealth());
    }

    @Test
    void dwarfNatureCloudy() {
        player.addRace(dwarf);
        SpellDamageCalculator.attack(player, npc, nature, stateCloudy);
        assertEquals(95, npc.getHealth());
    }
    @Test
    void dwarfNatureRainy() {
        player.addRace(dwarf);
        SpellDamageCalculator.attack(player, npc, nature, stateRain);
        assertEquals(95, npc.getHealth());
    }

    @Test
    void elfFireCloudy() {
        player.addRace(elf);
        SpellDamageCalculator.attack(player, npc, fire, stateCloudy);
        assertEquals(90, npc.getHealth());
    }

    @Test
    void elfFireNoEnergy() {
        player.addRace(elf);
        BasePlayer p = new BasePlayer("player", 100, 100, 100, 1, 100);
        assertThrows(IllegalArgumentException.class, () -> {
            SpellDamageCalculator.attack(p, npc, fire, stateCloudy);
        });
    }

}
