package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;

import io.github.Projektgrupp01.Project_INTE.creatures.Creature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import io.github.Projektgrupp01.Project_INTE.Map.Map;

import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.List;

//borde verkligen döpa om testen
//samordna så att map skapar inför varje test?
//lägg till felmeddelanden för alla test?
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
         //HUR??? läs wikisida om rand.walk
    }

    //ev gör om dessa t sådant som testar m flera värden
    @Test
    void createMapTest_x_noInitializers(){
        Map map = new Map();
        char[][] mapArray = map.getMap();
        assertEquals(20, mapArray[0].length); //vad exakt gör detta? dubbelkolla
    }

    @Test
    void createMapTest_y_noInitializers(){
        Map map = new Map();
        char[][] mapArray = map.getMap();
        assertEquals(20, mapArray.length);
    }

    @Disabled
    @Test //döp om så man fattar det inte är namnet på en metod
    void createMapTest_doesTunnelsExist(){
        Map map = new Map();
        char[][] mapArray = map.getMap();

        int nrOfTunnels = 0;
        for(char[] row: mapArray){
            for(char c: row){
                if (c == ' '){ //idk om villkoret är korrekt, fixa sen
                    nrOfTunnels++;
                }
            }
        }

        assertTrue(nrOfTunnels >= 50);
    } //test för att kontrollera längd på gångar/storlek på rum?
    //men då måste jag nog fixa så att jag kan lägga ut rum ordentligt först

    @Disabled
    @Test
    void generateCreatures_Test(){
        Map map = new Map();

        //fixa annan/bättre loop?
        //eller att man kan returnera position av enemies etc
        List<Creature> creatures = map.getCreatures();

        //borde jag göra ngt test för att kontrollera m vkn täthet de placeras?
        assertTrue(creatures.size() >= 5);

    }

    @Disabled
    @Test
    void generateStuff_Test(){ //byt namn
        Map map = new Map();

        //fixa annan/bättre loop?
        //eller att man kan returnera position av enemies etc
        List<Creature> creatures = map.getCreatures();

        //borde jag göra ngt test för att kontrollera m vkn täthet de placeras?
        assertTrue(creatures.size() >= 5);

    }

    @Disabled
    @Test
    void levelsTest(){

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