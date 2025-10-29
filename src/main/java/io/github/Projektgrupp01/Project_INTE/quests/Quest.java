package io.github.Projektgrupp01.Project_INTE.quests;

import io.github.Projektgrupp01.Project_INTE.creatures.Player;

public class Quest {
	public enum Status {
		LOCKED, AVAILABLE, ACCEPTED, IN_PROGRESS, FAILED, PERMANENT_LOCKED, SUCCESS_NORMAL, SUCCESS_BONUS, COMPLETED
	}

	private final String name;
	private final String description;
	private Status status;
	private final long rewardExperience;
	private final int requiredLevel;
	
	public Quest(String name, String description, long rewardExperience, int requiredLevel) {
		this.name = name;
		this.description = description;
		this.rewardExperience = rewardExperience;
		this.requiredLevel = requiredLevel;
		this.status = Status.AVAILABLE;

	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Status getStatus() {
		return status;
	}

	public long getReward() {
		return rewardExperience;
	}

	public void start() {
		if (status != Status.AVAILABLE) {
			throw new IllegalStateException("Quest has already been started or completed.");
		}
		status = Status.ACCEPTED;
	}

	public void complete() {
		if (status != Status.ACCEPTED) {
			throw new IllegalStateException("Quest has to be Started before they can be completed.");
		}
		
		status = Status.COMPLETED;
	}

	public boolean meetsRequirement(Player player) {
		if (player.getLevel() <= requiredLevel) {
			throw new ArithmeticException("Player does not meet the level requirements!");
		}
		return true;
		
	}
}