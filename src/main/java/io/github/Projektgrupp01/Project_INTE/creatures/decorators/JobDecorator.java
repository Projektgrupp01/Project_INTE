package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.*;

public class JobDecorator extends PlayerDecorator{

	private String jobName = "Unemployed";
	
	public String getJobName() {
		return jobName;
		
	}
	
	public void setJobName(String newName) {
		if(newName.equals("")) {
			throw new IllegalArgumentException();
		}
		jobName = newName;
	}
	
	public JobDecorator(Player p) {
		super(p);
	}

}
