package io.github.Projektgrupp01.Project_INTE;

public class BuffedPlayerDecorator extends PlayerDecorator{
	public BuffedPlayerDecorator (Player p) {
		super(p);
	}
	@Override
	public int getHealth() {
		return super.getHealth() * 2;
	}
}
