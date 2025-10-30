package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.Player;

public class TripleHealthDecorator extends PlayerDecorator{
	public TripleHealthDecorator (Player p) {
		super(p);
	}
	@Override
	public int getHealth() {
		return super.getHealth() * 3;
	}
}
