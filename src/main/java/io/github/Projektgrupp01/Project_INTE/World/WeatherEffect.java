package io.github.Projektgrupp01.Project_INTE.World;

import io.github.Projektgrupp01.Project_INTE.World.WorldState.Weather;
import io.github.Projektgrupp01.Project_INTE.spells.Spell.SpellType;

public final class WeatherEffect {
    private WeatherEffect() {
    }

    public static double modifier(SpellType spelltype, Weather weather) {
        double m = 1.0;
        switch (weather) {
            case SUNNY:
                if (spelltype == SpellType.FIRE)
                    m *= 1.1;
                if (spelltype == SpellType.NATURE)
                    m *= 1.2;
                if (spelltype == SpellType.WATER)
                    m *= 0.8;
                break;
            case RAIN:
                if (spelltype == SpellType.FIRE)
                    m *= 0.5;
                if (spelltype == SpellType.WATER)
                    m *= 1.2;
                break;
            case STORM:
                if (spelltype == SpellType.NATURE)
                    m *= 0.8;
                break;
            default:
                break;
        }
        return m;
    }

}
