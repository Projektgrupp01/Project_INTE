package io.github.Projektgrupp01.Project_INTE;

public class BuffedPlayer2Decorator extends PlayerDecorator{
	public BuffedPlayer2Decorator (Player p) {
		super(p);
	}
	@Override
	public int getHealth() {
		return super.getHealth() * 3;
	}
}
