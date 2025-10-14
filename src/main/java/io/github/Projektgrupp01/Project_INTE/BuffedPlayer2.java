package io.github.Projektgrupp01.Project_INTE;

public class BuffedPlayer2 extends Player{
	public BuffedPlayer2 () {
		super();
	}
	@Override
	public int getHealth() {
		return super.getHealth() * 3;
	}
}
