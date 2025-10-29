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
		if (status == Status.LOCKED && !meetsRequirement(player)) {
			System.out.println("You do not meet the requirements.");
			return;
		}
		System.out.println("The quest is not available");
	}

	public void fail() {
		if (status != Status.IN_PROGRESS && status != Status.ACCEPTED) {
			System.out.println("You can only fail a quest in progress.");
		}

		attempt++;
		if (allowedAttempts > 0 && attempt >= allowedAttempts) {
			status = Status.PERMANENT_LOCK;
		} else {
			status = Status.FAILED;
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
			System.out.println("You have already completed this quest.");
			return;
			
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
			System.out.println("You have not completed the objective yet.");
			return;
		
		default:
			throw new NullPointerException("Status cannot be null.");
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