package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.Player;

public class DoubleHealthDecorator extends PlayerDecorator{
	private String name = "Double Health!";
	public DoubleHealthDecorator (Player p) {
		super(p);
	}
	@Override
	public int getHealth() {
		return super.getHealth() * 2;
	}
	@Override
	public String getName() {
		return name;
	}
}
