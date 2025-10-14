package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.Player;

public class TripleHealthDecorator extends PlayerDecorator{
	private String name = "TRIPLE health!";
	public TripleHealthDecorator (Player p) {
		super(p);
	}
	@Override
	public int getHealth() {
		return super.getHealth() * 3;
	}
	@Override
	public String getName() {
		return name;
	}
}
