package io.github.Projektgrupp01.Project_INTE;

public class BuffedPlayer2 extends Player{
	public BuffedPlayer2 () {
		super();
	}
	@Override
	public int getEnergy() {
		return super.getEnergy() * 2;
	}
}
