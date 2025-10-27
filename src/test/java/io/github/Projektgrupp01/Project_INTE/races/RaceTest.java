package io.github.Projektgrupp01.Project_INTE.races;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;

import java.util.*;


public class RaceTest {
	
	@Test
	void newElf() {
		Race elf = new Elf();
		assertEquals(elf.getRaceName(),"Elf");
	}
	
	@Test
	void newDwarf() {
		Race dwarf = new Dwarf();
		assertEquals(dwarf.getRaceName(),"Dwarf");
	}
	
	@Test
	void addRace() {
		BasePlayer player = new BasePlayer();
		Race dwarf = new Dwarf();
		player.addRace(dwarf);
		HashSet<Race> comparingSet = new HashSet<>();
		comparingSet.add(dwarf);
		assertEquals(player.getRaces(),comparingSet);
	}
	
	@Test
	void addTwoSameRaces() {
		BasePlayer player = new BasePlayer();
		Race dwarf = new Dwarf();
		Race dwarf2 = new Dwarf();
		player.addRace(dwarf);
		player.addRace(dwarf2);
		assertEquals(1, player.getRaces().size());
		
	}
	
	@Test
	void addTwoDifferentRaces() {
		BasePlayer player = new BasePlayer();
		Race elf = new Elf();
		Race dwarf = new Dwarf();
		player.addRace(elf);
		player.addRace(dwarf);
		assertEquals(2, player.getRaces().size());
		
	}
	
	@Test 
	void addNullRace() {
		BasePlayer player = new BasePlayer();
		assertThrows(IllegalArgumentException.class,() -> { 
           player.addRace(null);});
	}
	
	@Test
	void newPlayerHasNoRace() {
		BasePlayer player = new BasePlayer();
		assertEquals(0, player.getRaces().size());
	}
	
	@Test
	void checktoString() {
		Race elf = new Elf();
		assertEquals(elf.toString(),"Elf");

	}
	
	@Test 
	void doesContainRace() {
		BasePlayer player = new BasePlayer();
		Race elf = new Elf();
		player.addRace(elf);
		assertTrue(player.containsRace("Elf"));
	}
	
	@Test 
	void doesNotContainRace() {
		BasePlayer player = new BasePlayer();
		Race elf = new Elf();
		player.addRace(elf);
		assertFalse(player.containsRace("Dwarf"));
	}
}
