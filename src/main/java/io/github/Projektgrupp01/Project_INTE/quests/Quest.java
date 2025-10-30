package io.github.Projektgrupp01.Project_INTE.quests;

import io.github.Projektgrupp01.Project_INTE.creatures.Player;

public class Quest {
	public enum Status {
		LOCKED, AVAILABLE, ACCEPTED, IN_PROGRESS, FAILED, PERMANENT_LOCK, SUCCESS_NORMAL, SUCCESS_BONUS, COMPLETED
	}

	private final String name;
	private final String description;
	private final int allowedAttempts;
	private final int requiredLevel;
	private final long rewardExperience;
	private Status status;
	private int attempt;

	public Quest(String name, String description, long rewardExperience, int requiredLevel) {
		this.name = name;
		this.description = description;
		this.rewardExperience = rewardExperience;
		this.requiredLevel = requiredLevel;
		this.allowedAttempts = 0;
		this.status = Status.LOCKED;
	}

	public Quest(String name, String description, long rewardExperience, int requiredLevel, int allowedAttempts) {
		this.name = name;
		this.description = description;
		this.rewardExperience = rewardExperience;
		this.requiredLevel = requiredLevel;
		this.allowedAttempts = allowedAttempts;
		this.status = Status.LOCKED;
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

	public void setStatus(Status newStatus) {
		switch (newStatus) {
		case LOCKED:
			status = Status.LOCKED;
			break;
		case AVAILABLE:
			status = Status.AVAILABLE;
			break;
		case ACCEPTED:
			status = Status.ACCEPTED;
			break;
		case IN_PROGRESS:
			status = Status.IN_PROGRESS;
			break;
		case FAILED:
			status = Status.FAILED;
			break;
		case PERMANENT_LOCK:
			status = Status.PERMANENT_LOCK;
			break;
		case SUCCESS_NORMAL:
			status = Status.SUCCESS_NORMAL;
			break;
		case SUCCESS_BONUS:
			status = Status.SUCCESS_BONUS;
			break;
		case COMPLETED:
			status = Status.COMPLETED;
			break;
		}
	}

	public void start(Player player) {
		unlockIfEligible(player);
		if (status == Status.AVAILABLE) {
			status = Status.ACCEPTED;
			return;
		}
		if (status == Status.LOCKED) {
			System.out.println("You do not meet the level requirements.");
			return;
		}
		throw new IllegalStateException("The quest is not available");
	}

	public void fail() {
		switch (status) {
		case IN_PROGRESS:
		case ACCEPTED:
			status = Status.FAILED;
			System.out.println("Quest failed. You can retry if you have attempts left.");
			return;

		case FAILED:
			throw new IllegalStateException("Quest already marked as failed. Complete it to retry.");

		case AVAILABLE:
		case LOCKED:
			throw new IllegalStateException("You can't fail a quest that hasn't been started.");

		case PERMANENT_LOCK:
			throw new IllegalStateException("You are permanently locked from this quest.");

		case SUCCESS_NORMAL:
		case SUCCESS_BONUS:
		case COMPLETED:
			throw new IllegalStateException("You can’t fail a quest that has already been completed.");

		}
	}

	public void complete(Player player) {
		switch (status) {
		case SUCCESS_NORMAL:
		case ACCEPTED:
		case IN_PROGRESS:
			System.out.println("Normal reward");
			player.addExperience(rewardExperience);
			status = Status.COMPLETED;
			return;

		case SUCCESS_BONUS:
			System.out.println("Bonus reward");
			player.addExperience(rewardExperience * 2);
			status = Status.COMPLETED;
			return;

		case COMPLETED:
			throw new IllegalStateException("You have already completed this quest.");

		case FAILED:
			attempt++;
			if (allowedAttempts > 0 && attempt >= allowedAttempts) {
				status = Status.PERMANENT_LOCK;
				System.out.println("You have failed me for the last time.");
			} else if (allowedAttempts == 0) {
				status = Status.AVAILABLE;
			} else {
				int attemptsLeft = allowedAttempts - attempt;
				System.out.println("You have failed. You have " + attemptsLeft + " attempt(s) left.");
				status = Status.AVAILABLE;
			}
			return;

		case LOCKED:
		case PERMANENT_LOCK:
		case AVAILABLE:
			throw new IllegalStateException("You have not completed the objective yet.");

		}
	}

	public boolean meetsRequirement(Player player) {
		return player.getLevel() >= requiredLevel && status != Status.PERMANENT_LOCK;

	}

	public void unlockIfEligible(Player player) {
		if (meetsRequirement(player) && status == Status.LOCKED) {
			status = Status.AVAILABLE;
		}
	}
}