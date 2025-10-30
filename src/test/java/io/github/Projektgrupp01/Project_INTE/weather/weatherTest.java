package io.github.Projektgrupp01.Project_INTE.weather;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.World.WeatherEffect;
import io.github.Projektgrupp01.Project_INTE.World.WorldState;
import io.github.Projektgrupp01.Project_INTE.World.WorldState.Weather;
import io.github.Projektgrupp01.Project_INTE.spells.Spell.SpellType;

class weatherTest {
    WorldState sunny, cloudy, rain, storm;
    @BeforeEach
    void setup(){
        sunny = new WorldState(Weather.SUNNY);
        cloudy = new WorldState(Weather.CLOUDY);
        rain = new WorldState(Weather.RAIN);
        storm = new WorldState(Weather.STORM);
    }
    @Test
    void setWeather(){
        WorldState w = new WorldState(Weather.RAIN);
        w.setWeather(Weather.CLOUDY);
        assertEquals(Weather.CLOUDY, w.getWeather());
    }
    @Test
    void weatherSunny(){
        assertEquals(1.2, WeatherEffect.modifier(SpellType.NATURE, Weather.SUNNY));
        assertEquals(Weather.SUNNY, sunny.getWeather());
    }
    @Test
    void weatherCloudy(){
        assertEquals(1.0, WeatherEffect.modifier(SpellType.NATURE, Weather.CLOUDY));
        assertEquals(Weather.CLOUDY, cloudy.getWeather());
    }
    @Test
    void weatherRainy(){
        assertEquals(1.0, WeatherEffect.modifier(SpellType.NATURE, Weather.RAIN));
        assertEquals(Weather.RAIN, rain.getWeather());
    }
    @Test
    void weatherStorm(){
        assertEquals(0.8, WeatherEffect.modifier(SpellType.NATURE, Weather.STORM));
        assertEquals(Weather.STORM, storm.getWeather());
    }
    @Test
    void weatherSunnyFire(){
        assertEquals(1.1, WeatherEffect.modifier(SpellType.FIRE, Weather.SUNNY));
        assertEquals(Weather.SUNNY, sunny.getWeather());
    }
    
}
