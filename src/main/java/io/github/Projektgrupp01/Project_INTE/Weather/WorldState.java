package io.github.Projektgrupp01.Project_INTE.Weather;

public class WorldState {
    private Weather weather;
    public enum Weather { SUNNY, RAIN, STORM, CLOUDY }

    public WorldState(Weather startWeather){
        this.weather = startWeather;
    }

    public Weather getWeather(){
        return weather;
    }

    public void setWeather(Weather newWeather){
        weather = newWeather;
    }
    
}
