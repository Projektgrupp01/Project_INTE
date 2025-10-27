package io.github.Projektgrupp01.Project_INTE.spells;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC.Disposition;
import io.github.Projektgrupp01.Project_INTE.races.Dwarf;
import io.github.Projektgrupp01.Project_INTE.races.Elf;
import io.github.Projektgrupp01.Project_INTE.races.Race;

class AttackSpellsTest {
    BasePlayer player;
    Spell nature;
    Spell fire;
    BaseNPC npc;
    Race dwarf;
    Race elf;
    @BeforeEach
    void setup(){
        player = new BasePlayer();
        nature = new Nature();
        fire = new Fire();
        npc = new BaseNPC("monster", 100, Disposition.HOSTILE);
        dwarf = new Dwarf();
        elf = new Elf();
        player.learnSpell(nature);
        player.learnSpell(fire);
    }
    @Test
    void otherRaceNatureIsNormal(){
        AttackSpells.attack(player, npc, nature);
        assertEquals(93, npc.getHealth());
    }
    @Test
    void dwarfNatureIsWeak(){
        player.addRace(dwarf);
		assertTrue(player.getSpellBook().contains(nature));
		assertEquals(2, player.getSpellBook().size());
        AttackSpells.attack(player, npc, nature);
        assertEquals(93, npc.getHealth());
    }
    @Test
    void elfNatureIsStrong(){
        player.addRace(elf);
        AttackSpells.attack(player, npc, nature);
        assertEquals(93, npc.getHealth());
    }
    @Test
    void otherRaceFireIsNormal(){
        AttackSpells.attack(player, npc, fire);
        assertEquals(90, npc.getHealth());
    }
    @Test
    void elfNatureIsStrongNoEnergy(){
        player.addRace(elf);
        player.setEnergy(1);
        assertThrows(IllegalArgumentException.class, () -> {
            AttackSpells.attack(player, npc, nature);
        });
    }

    
}
