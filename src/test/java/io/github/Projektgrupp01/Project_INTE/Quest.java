package io.github.Projektgrupp01.Project_INTE;

public class Quest {
	public enum Status {
		NOT_STARTED, STARTED, COMPLETED
	}

	private final String name;
	private final String description;
	private Status status = Status.NOT_STARTED;
	private final long rewardExperience;

	public Quest(String name, String description, long rewardExperience) {
		this.name = name;
		this.description = description;
		this.rewardExperience = rewardExperience;

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
		if (status != Status.NOT_STARTED){
			throw new IllegalStateException("Quest has already been started or completed.");
		}
		status = Status.STARTED;
	}
	public void complete() {
		if (status != Status.STARTED){
			throw new IllegalStateException("Quest has to be Started before they can be completed.");
		}
		status = Status.COMPLETED;
	}
}