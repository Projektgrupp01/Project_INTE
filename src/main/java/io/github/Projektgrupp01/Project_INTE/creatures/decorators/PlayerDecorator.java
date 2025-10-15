package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.Player;

public abstract class PlayerDecorator implements Player {
	protected Player player;

	protected PlayerDecorator(Player p) {
		this.player = p;
	}

	@Override
	public int getHealth() {
		return player.getHealth();
	}

	@Override
	public int getSpeed() {
		return player.getSpeed();
	}

	@Override
	public int getStrength() {
		return player.getStrength();
	}

	@Override
	public int getEnergy() {
		return player.getEnergy();
	}

	@Override
	public void takeDamage(int amount) {
		player.takeDamage(amount);
	}

	@Override
	public boolean isDead() {
		return player.isDead();
	}

	public String getName() {
		return player.getName();
	}

	public int getLevel() {
		return player.getLevel();
	}

	public long getExperience() {
		return player.getExperience();
	}

	public long getExperienceToNextLevel() {
		return player.getExperienceToNextLevel();
	}

	public void addExperience(long amount) {
		player.addExperience(amount);
	}
	
	

}
