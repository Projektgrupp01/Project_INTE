package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.*;

public abstract class JobDecorator extends PlayerDecorator{

	private String jobName;
	
	public String getJobName() {
		return jobName;
		
	}
	
	public JobDecorator(Player p) {
		super(p);
	}

}
