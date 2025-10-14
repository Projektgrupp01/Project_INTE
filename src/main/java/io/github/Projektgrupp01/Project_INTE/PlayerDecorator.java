package io.github.Projektgrupp01.Project_INTE;

public abstract class PlayerDecorator implements PlayerInterface {
	protected PlayerInterface p;

	protected PlayerDecorator(PlayerInterface p) {
		this.p = p;
	}

	@Override
	public int getHealth() {
		return p.getHealth();
	}
	@Override
	public int getSpeed() {
		return p.getSpeed();
	}
	@Override
	public int getStrength() {
		return p.getStrength();
	}
	@Override
	public int getEnergy() {
		return p.getEnergy();
	}

	@Override
	public void takeDamage(int amount) {
		p.takeDamage(amount);
	}

	@Override
	public boolean isDead() {
		return p.isDead();
	}

}
