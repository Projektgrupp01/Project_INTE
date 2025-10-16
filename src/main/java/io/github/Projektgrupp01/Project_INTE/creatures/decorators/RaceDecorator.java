package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.*;

public class RaceDecorator extends PlayerDecorator{
	private String raceName;
	
	public RaceDecorator(Player p, String raceName) {
		super(p);
		this.raceName = raceName;
		if(raceName == "") {
			throw new IllegalArgumentException();
		}
	}
	
	public String getRace() {
		return raceName;
	}
	
	public void setRace(String newRace) {
		this.raceName = newRace;
	}
	
	@Override
	public String getName() {
		return "RaceDecorator"; //Change this?
	}
	
	@Override
	public int getHealth() {
		return super.getHealth();
	}
}
