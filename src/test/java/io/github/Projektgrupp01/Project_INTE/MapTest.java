package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import io.github.Projektgrupp01.Project_INTE.Map.Map;

import java.util.Arrays;
import java.lang.StringBuilder;

//borde verkligen döpa om testen
// & byt namn på Map/klassen så det blir tydligt att det endast är för
// mapGenerator
//o inte interfacet
//testa interface?
public class MapTest {

    @Test
    void getMapTest_notNull(){ //ändra t ngn annan assert? lista?
        /*Map map = new Map();
        assertEquals(getMap(), new Map(3,3));*/
        Map map = new Map(3, 4);
        assertNotNull(map.getMap()); //borde jag ha assertequals eller nått här?
        //ngt annat test som bekräftar att map:ens utseende är korrekt
    }

    @Test //gör test som bekräftar att innehållet/utseendet är korrekt
    void getMapTest(){
        Map map = new Map();

    }

    @Test
    void createMapTest(){

    }

    @Test
    void generateMapOnPlayerWalkTest(){

    }

    @Test
    void rememberMapTest(){ //byt namn t ngt mer begripligt

    }

    @Test //borde man inte kunna göra detta utan stringen...?
    void Map_toStringTest_NoInitializers(){
        Map map = new Map();
        /*char[][] array = new char[20][20];
        for(char[] row: array) {
            Arrays.fill(row, '#');
        }*/
        StringBuilder str = new StringBuilder();
        //initialisera sträng genom loop som tar map-arrayens antal rader som längdarg,
        //lägg in char '#' på alla positioner, bryt med \n efter varje loop
        assertEquals(map.toString(), /*Arrays.deepToString(array)*/);
    }

    @Test
    void Map_toStringTest_WithInitializers(){
        Map map = new Map(3,11);
        char[][] array = new char[3][11];
        for(char[] row: array) {
            Arrays.fill(row, '#');
        }
        assertEquals(map.toString(), Arrays.deepToString(array));
    }

}