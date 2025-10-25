package io.github.Projektgrupp01.Project_INTE.creatures.decorators;

import io.github.Projektgrupp01.Project_INTE.creatures.*;

public class CookingDecorator extends JobDecorator {
	
	public CookingDecorator(Player p) {
		super(p);
		super.setJobName("Cooking");
	}
	
	public String getName() {
		return super.getName();
	}
}
