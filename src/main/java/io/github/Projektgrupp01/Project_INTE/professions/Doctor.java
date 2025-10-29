package io.github.Projektgrupp01.Project_INTE.professions;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;

public class Doctor extends Profession {
	
	public Doctor() {
		super("Doctor");
	}
	
	public Doctor(int startingLevel) {
		super("Doctor", startingLevel);
	}
	
	public static void basicSelfHeal(BasePlayer player) {
		int found = 0;
		for (Profession prof : player.getProfessions()) {
			if (prof.getProfessionName().equals("Doctor")&&prof.getProfessionLevel()>0) {
				found = 1;
				break;
			}
		}
		if (found == 1) {
			player.takeDamage(-1);
		}
	}

}
