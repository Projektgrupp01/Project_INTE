package io.github.Projektgrupp01.Project_INTE.map;

import static org.junit.jupiter.api.Assertions.*;

import io.github.Projektgrupp01.Project_INTE.Map.BaseMap;
import io.github.Projektgrupp01.Project_INTE.Map.Map;
import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.Creature;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.List;

public class MapTest {

    @Test
    void getMapTest_notNull_noInitializers(){
       BaseMap map = new BaseMap();
       assertNotNull(map.getMap());
    }

    @Test
    void getMapTest_notNull_withInitializers(){
        Map map = new BaseMap(3, 4);
        assertNotNull(map.getMap());
    }

    @Test
    void getMapTest_noInitializers(){
        Map map = new BaseMap();
        char[][] array = new char[20][20];
        for(char[] row: array){
            Arrays.fill(row, '#');
        }
        assertArrayEquals(array, map.getMap());
    }

    @Test
    void getMapTest_withInitializers(){
        BaseMap map = new BaseMap(4, 3);
        char[][] expected = {{'#','#', '#'},{'#','#', '#'},{'#','#', '#'}, {'#','#', '#'}};
        assertArrayEquals(expected, map.getMap());
    }

    //ev gör om dessa t sådant som testar m flera värden
    @Test
    void createMapTest_x_noInitializers(){ //byt namn? testar skapandet av array inte karta
        Map map = new BaseMap();
        char[][] mapArray = map.getMap();
        assertEquals(20, mapArray[0].length);
    }

    @Test
    void createMapTest_y_noInitializers(){ //byt namn? testar skapandet av array inte karta
        Map map = new BaseMap();
        char[][] mapArray = map.getMap();
        assertEquals(20, mapArray.length);
    }

    @Disabled
    @Test
    void createMapTest_tunnelsExist(){
        Map map = new BaseMap();
        map.createMap();
        char[][] mapArray = map.getMap();

        int nrOfTunnels = 0;
        for(char[] row: mapArray){
            for(char c: row){
                if (c == ' '){
                    nrOfTunnels++;
                }
            }

        }
        nrOfTunnels = (nrOfTunnels / mapArray.length);
        //om jag lägger in density sen borde jag ändra här
        assertTrue(nrOfTunnels >= 2, "nrOfTunnels: " + nrOfTunnels + " och 5/2: " + 5/2);
    }

    @Disabled
    @Test
    void generateNPCs_Test(){
        BaseMap map = new BaseMap();
        List<BaseNPC> creatures = map.getNPCs();
        assertTrue(creatures.size() >= 5);
    }

    @Disabled
    @Test
    void generateEquipment_Test(){
        BaseMap map = new BaseMap();

        List<Equipment> equipment = map.getEquipment();

        assertTrue(equipment.size() >= 5);

    }

    @Test
    void Map_toStringTest_NoInitializers(){
        Map map = new BaseMap();

        StringBuilder expected = new StringBuilder();
        //för att testa att map-ens storlek/utseende blir som förväntat
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                expected.append("#");
            }
            expected.append("\n");
        }
        assertEquals(expected.toString(), map.toString());
    }

    @Test //UGH. vet att det blir fel här med rader/kolumner. fixa sen!
    void Map_toStringTest_WithInitializers(){
        Map map = new BaseMap(30,11);

        StringBuilder expected = new StringBuilder();
        //för att testa att map-ens storlek/utseende blir som förväntat
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 11; j++){ //kolumner - x
                expected.append("#");
            }
            expected.append("\n");
        }
        assertEquals(expected.toString(), map.toString());
    }

}