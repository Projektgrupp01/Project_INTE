package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.*;

public class RaceDecorator extends PlayerDecorator{
	private String raceName;
	
	public RaceDecorator(Player p, String raceName) {
		super(p);
		this.raceName = raceName;
	}
	
	public String getRace() {
		return raceName;
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
