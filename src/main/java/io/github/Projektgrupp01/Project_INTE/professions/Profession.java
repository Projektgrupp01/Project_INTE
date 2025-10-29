package io.github.Projektgrupp01.Project_INTE.professions;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;

public abstract class Profession {
	
	final private String professionName;
	private int professionLevel=0;
	
	public Profession(String professionName){
		this.professionName = professionName;
	}
	
	public Profession(String professionName, int startingLevel) {
		this.professionName = professionName;
		setProfessionLevel(startingLevel);
	}
	
	public String getProfessionName() {
		return professionName;
	}
	
	public int getProfessionLevel() {
		return professionLevel;
	}
	
	public void setProfessionLevel(int level) {
		if (level >= 0) {
			professionLevel = level;
		}
		
	}
	
	public void levelUpProfession() {
		professionLevel += 1;
	}
	
	public static void levelUpNamedProfession(BasePlayer p, String professionName) {
		for (Profession prof : p.getProfessions()) {
			if (prof.getProfessionName().equals(professionName)) {
					prof.levelUpProfession();
			}
		}
	}
	
	@Override
	public String toString() {
		return "Level: "+ professionLevel + " " + professionName;
	}
	
}
