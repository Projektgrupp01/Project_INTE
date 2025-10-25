package io.github.Projektgrupp01.Project_INTE.professions;

public abstract class Profession {
	
	String professionName;
	
	public Profession(String professionName){
		this.professionName = professionName;
	}
	
	public String getProfessionName() {
		return professionName;
	}

}
