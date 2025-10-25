package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import io.github.Projektgrupp01.Project_INTE.Map.Map;

import java.util.Arrays;
import java.lang.StringBuilder;

//borde verkligen döpa om testen
public class MapTest {
    //borde jag testa initialisering av map med 0 el. neg?

    @Test
    void getMapTest_notNull(){ //ändra t ngn annan assert? lista?
       //byt namn + stil på test så det matchar toString-testen?
        Map map = new Map(3, 4);
        assertNotNull(map.getMap()); //borde jag ha assertequals eller nått här?
        //ngt annat test som bekräftar att map:ens utseende är korrekt
    }

    @Test
    void getMapTest_noInitializers(){
        Map map = new Map();
        char[][] array = new char[20][20];
        for(char[] row: array){
            Arrays.fill(row, '#');
        }
        assertArrayEquals(map.getMap(), array);
    }

    @Disabled
    @Test
    void createMapTest(){

    }

    @Disabled
    @Test
    void generateMapOnPlayerWalkTest(){

    }

    @Disabled
    @Test
    void rememberMapTest(){ //byt namn t ngt mer begripligt

    }

    //tostring-testerna är väldigt lika...c suggestions
    @Test
    void Map_toStringTest_NoInitializers(){
        Map map = new Map();

        StringBuilder expected = new StringBuilder();
        //för att testa att map-ens storlek/utseende blir som förväntat
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                expected.append("#");
            }
            expected.append("\n");
        }
        assertEquals(map.toString(), expected.toString());
    }

    @Test
    void Map_toStringTest_WithInitializers(){
        Map map = new Map(30,11);

        StringBuilder expected = new StringBuilder();
        //för att testa att map-ens storlek/utseende blir som förväntat
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 11; j++){
                expected.append("#");
            }
            expected.append("\n");
        }
        assertEquals(map.toString(), expected.toString());
    }

}