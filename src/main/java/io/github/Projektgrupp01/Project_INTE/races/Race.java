package io.github.Projektgrupp01.Project_INTE.races;


public abstract class Race {

	String raceName;
	
	public Race(String raceName){
		this.raceName = raceName;
	}
	
	public String getRaceName() {
		return raceName;
	}
	
	@Override
	public String toString() {
		return raceName;
	}

}
