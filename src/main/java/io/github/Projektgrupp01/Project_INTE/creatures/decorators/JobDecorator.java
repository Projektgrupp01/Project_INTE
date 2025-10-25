package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.*;

public class JobDecorator extends PlayerDecorator{

	private String jobName = "Unemployed";
	
	public String getJobName() {
		return jobName;
		
	}
	
	public JobDecorator(Player p) {
		super(p);
	}

}
