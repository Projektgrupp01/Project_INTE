package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.Player;

public abstract class PlayerDecorator implements Player {
	protected Player p;

	protected PlayerDecorator(Player p) {
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
