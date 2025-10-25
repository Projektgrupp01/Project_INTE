package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.Player;
import io.github.Projektgrupp01.Project_INTE.quests.Quest;

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

	@Override
	public String getName() {
		return player.getName();
	}

	@Override
	public int getLevel() {
		return player.getLevel();
	}

	@Override
	public long getExperience() {
		return player.getExperience();
	}

	@Override
	public long getExperienceToNextLevel() {
		return player.getExperienceToNextLevel();
	}

	@Override
	public void addExperience(long amount) {
		player.addExperience(amount);
	}

	@Override
	public void acceptQuest(Quest quest) {
		player.acceptQuest(quest);
	}

	@Override
	public void completeQuest(Quest quest) {
		player.completeQuest(quest);
	}

}
