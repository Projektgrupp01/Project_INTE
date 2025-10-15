package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.RaceDecorator;


public class RaceDecoratorTest {
	@Test
	void getNameTest() {
		Player player = new BasePlayer();
		Player racialPlayer = new RaceDecorator(player, "Elf");
		assertEquals(racialPlayer.getName(),"RaceDecorator");
	}
	
	@Test
	void getRaceTest() {
		Player player = new BasePlayer();
		RaceDecorator racialPlayer = new RaceDecorator(player, "Elf");
		assertEquals(racialPlayer.getRace(),"Elf");
	}
	
	@Test 
	void setRaceTest() {
		Player player = new BasePlayer();
		RaceDecorator racialPlayer = new RaceDecorator(player, "Elf");
		racialPlayer.setRace("Dwarf");
		assertEquals(racialPlayer.getRace(),"Dwarf");
		
	}

}
