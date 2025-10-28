package io.github.Projektgrupp01.Project_INTE.damageCalc;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.Weather.WorldState;
import io.github.Projektgrupp01.Project_INTE.Weather.WorldState.Weather;
import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC.Disposition;
import io.github.Projektgrupp01.Project_INTE.races.Dwarf;
import io.github.Projektgrupp01.Project_INTE.races.Elf;
import io.github.Projektgrupp01.Project_INTE.races.Race;
import io.github.Projektgrupp01.Project_INTE.spells.AttackSpells;
import io.github.Projektgrupp01.Project_INTE.spells.Fire;
import io.github.Projektgrupp01.Project_INTE.spells.Nature;
import io.github.Projektgrupp01.Project_INTE.spells.Spell;
import io.github.Projektgrupp01.Project_INTE.spells.Water;

class AttackSpellsWeatherTest {
    BasePlayer player;
    Spell nature, fire, water;
    BaseNPC npc;
    Race dwarf, elf;
    WorldState worldState;
    @BeforeEach
    void setup(){
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
        worldState = new WorldState(Weather.CLOUDY);
    }
    //sunny
    @Test
    void sunnyFireTest(){
        worldState = new WorldState(Weather.SUNNY);
        AttackSpells.attack(player, npc, fire, worldState);
        assertEquals(89, npc.getHealth());
    }
    @Test
    void sunnyWaterTest(){
        worldState = new WorldState(Weather.SUNNY);
        AttackSpells.attack(player, npc, water, worldState);
        assertEquals(94, npc.getHealth());
    }
    @Test
    void sunnyNatureTest(){
        worldState = new WorldState(Weather.SUNNY);
        AttackSpells.attack(player, npc, nature, worldState);
        assertEquals(92, npc.getHealth());
    }
    //rain
    @Test
    void rainFireTest(){
        worldState = new WorldState(Weather.RAIN);
        AttackSpells.attack(player, npc, fire, worldState);
        assertEquals(95, npc.getHealth());
    }
    @Test
    void rainWaterTest(){
        worldState = new WorldState(Weather.RAIN);
        AttackSpells.attack(player, npc, water, worldState);
        assertEquals(91, npc.getHealth());
    }
    @Test
    void rainNatureTest(){
        worldState = new WorldState(Weather.RAIN);
        AttackSpells.attack(player, npc, nature, worldState);
        assertEquals(93, npc.getHealth());
    }
    //storm
    @Test
    void stormFireTest(){
        worldState = new WorldState(Weather.STORM);
        AttackSpells.attack(player, npc, fire, worldState);
        assertEquals(90, npc.getHealth());
    }
    @Test
    void stormWaterTest(){
        worldState = new WorldState(Weather.STORM);
        AttackSpells.attack(player, npc, water, worldState);
        assertEquals(92, npc.getHealth());
    }
    @Test
    void stormNatureTest(){
        worldState = new WorldState(Weather.STORM);
        AttackSpells.attack(player, npc, nature, worldState);
        assertEquals(95, npc.getHealth());
    }
    //cloudy
    @Test
    void cloudyFireTest(){
        worldState = new WorldState(Weather.CLOUDY);
        AttackSpells.attack(player, npc, fire, worldState);
        assertEquals(90, npc.getHealth());
    }
    @Test
    void noEnergyWeatherTest(){
        BasePlayer newPlayer = new BasePlayer("player", 100, 100, 100, 1, 100);
        worldState = new WorldState(Weather.STORM);
        assertThrows(IllegalArgumentException.class, ()->{
            AttackSpells.attack(newPlayer, npc, nature, worldState);
        });
    }

}
