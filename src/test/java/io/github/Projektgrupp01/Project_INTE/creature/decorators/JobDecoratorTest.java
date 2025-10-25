package io.github.Projektgrupp01.Project_INTE.creature.decorators;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.JobDecorator;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.RaceDecorator;
import io.github.Projektgrupp01.Project_INTE.creatures.decorators.CookingDecorator;

public class JobDecoratorTest {
	
	
	@Test
	void getNameTest() {
		Player player = new BasePlayer();
		Player workingPlayer = new JobDecorator(player);
		assertEquals(workingPlayer.getName(),"BasePlayer");
	}
	
	@Test
	void getCookingNameTest() {
		Player player = new BasePlayer();
		Player workingPlayer = new CookingDecorator(player);
		assertEquals(workingPlayer.getName(),"BasePlayer");
	}
	
}
