package io.github.Projektgrupp01.Project_INTE.races;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;
import io.github.Projektgrupp01.Project_INTE.World.WorldState;
import io.github.Projektgrupp01.Project_INTE.World.WorldState.Weather;

public class Elf extends Race {
	
	public Elf() {
		super("Elf");
	}
	
	public static void elfSong(BasePlayer player, WorldState w) {
		if(player.containsRace("Elf")&&w.getWeather().equals(Weather.RAIN)) {
			int prevMaxEnergy = player.getMaxEnergy();
			player.setMaxEnergy(prevMaxEnergy + 10);
		}
	}

}
