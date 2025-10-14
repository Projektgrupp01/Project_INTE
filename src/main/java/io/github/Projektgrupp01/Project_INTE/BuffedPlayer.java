package io.github.Projektgrupp01.Project_INTE;

public class BuffedPlayer extends Player{
	public BuffedPlayer () {
		super();
	}
	@Override
	public int getHealth() {
		return super.getHealth() * 2;
	}
}
