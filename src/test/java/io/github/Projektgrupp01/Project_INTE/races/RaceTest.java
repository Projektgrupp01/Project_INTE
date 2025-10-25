package io.github.Projektgrupp01.Project_INTE.races;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;


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

}
