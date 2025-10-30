package io.github.Projektgrupp01.Project_INTE.map;

import static org.junit.jupiter.api.Assertions.*;

import io.github.Projektgrupp01.Project_INTE.Map.BaseMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.lang.StringBuilder;

public class MapTest {

    BaseMap map;

    @BeforeEach
    void createTestMap(){
        map = new BaseMap();
    }

    @Test
    void getMapTest_notNull_noInitializers(){
       assertNotNull(map.getMap());
    }

    @Test
    void getMapTest_notNull_withInitializers(){
        map = new BaseMap(3, 4);
        assertNotNull(map.getMap());
    }

    @Test
    void getMapTest_noInitializers(){
        char[][] array = new char[20][20];
        for(char[] row: array){
            Arrays.fill(row, '#');
        }
        assertArrayEquals(array, map.getMap());
    }

    @Test
    void getMapTest_withInitializers(){
        map = new BaseMap(4, 3);
        char[][] expected = {{'#','#', '#'},{'#','#', '#'},{'#','#', '#'}, {'#','#', '#'}};
        assertArrayEquals(expected, map.getMap());
    }

    @Test
    void createMapTest_x_noInitializers(){
        char[][] mapArray = map.getMap();
        assertEquals(20, mapArray[0].length);
    }

    @Test
    void createMapTest_y_noInitializers(){
        char[][] mapArray = map.getMap();
        assertEquals(20, mapArray.length);
    }

    @Test
    void createMapTest_tunnelsExist(){
        map.createMap();
        char[][] mapArray = map.getMap();

        int nrOfTunnels = 0;
        for(char[] row: mapArray){
            for(char c: row){
                if (c == ' '){nrOfTunnels++;}
            }
        }
        nrOfTunnels = (nrOfTunnels / mapArray.length);
        //om jag lägger in density sen borde jag ändra här först
        assertTrue(nrOfTunnels >= 2, "nrOfTunnels: " + nrOfTunnels + " och 5/2: " + 5/2);
    }

    @Test
    void generateNPCs_listNotNull(){
        map.createMap();
        assertNotNull(map.getNPCs());
    }

    @Test
    void generateEquipment_listNotNull(){
        map.createMap();
        assertNotNull(map.getEquipment());
    }

    @Test
    void checkNrOfNPCs_lowerBound(){
        map.createMap();
        assertTrue(map.getNPCs().size() >= 1 && map.getNPCs().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfNPCs_upperBound(){
        map.createMap();
        assertTrue(map.getNPCs().size() <= 5 && map.getNPCs().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfNPCsByPlayerLevel_lvl2upperBound(){
        map.createMap(2);
        assertTrue(map.getNPCs().size() <= 10 && map.getNPCs().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfNPCsPlacedByPlayerLevel_lvl3upperBound(){
        map.createMap(3);
        assertTrue(map.getNPCs().size() <= 15 && map.getNPCs().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfNPCsByPlayerLevel_lvl4upperBound(){
        map.createMap(4);
        assertTrue(map.getNPCs().size() <= 20 && map.getNPCs().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfNPCsByPlayerLevel_lvl5upperBound(){
        map.createMap(5);
        assertTrue(map.getNPCs().size() <= 25 && map.getNPCs().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfNPCsByPlayerLevel_lvl6upperBound(){
        map.createMap(6);
        assertTrue(map.getNPCs().size() <= 30 && map.getEquipment().size() <= map.getNrOfWalkableArea(),
                   "");
    }

    @Test
    void checkNrOfNPCsByPlayerLevel_lvl7upperBound(){
        map.createMap(7);
        assertTrue(map.getNPCs().size() <= 35 && map.getNPCs().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfNPCsByPlayerLevel_lvl8upperBound(){
        map.createMap(8);
        assertTrue(map.getNPCs().size() <= 40 && map.getNPCs().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfNPCsByPlayerLevel_lvl9upperBound(){
        map.createMap(9);
        assertTrue(map.getNPCs().size() <= 45 && map.getNPCs().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfNPCsByPlayerLevel_lvl10upperBound(){
        map.createMap(10);
        assertTrue(map.getNPCs().size() <= 50 && map.getNPCs().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfEquipment_lowerBound(){
        map.createMap();
        assertTrue(map.getEquipment().size() >= 1 && map.getEquipment().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfEquipment_upperBound(){
        map.createMap();
        assertTrue(map.getEquipment().size() <= 5 && map.getEquipment().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfEquipmentByPlayerLevel_lvl2upperBound(){
        map.createMap(2);
        assertTrue(map.getEquipment().size() <= 10 && map.getEquipment().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfEquipmentByPlayerLevel_lvl3upperBound(){
        map.createMap(3);
        assertTrue(map.getEquipment().size() <= 15 && map.getEquipment().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfEquipmentByPlayerLevel_lvl4upperBound(){
        map.createMap(4);
        assertTrue(map.getEquipment().size() <= 20 && map.getEquipment().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfEquipmentByPlayerLevel_lvl5upperBound(){
        map.createMap(5);
        assertTrue(map.getEquipment().size() <= 25 && map.getEquipment().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfEquipmentByPlayerLevel_lvl6upperBound(){
        map.createMap(6);
        assertTrue(map.getEquipment().size() <= 30 && map.getEquipment().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfEquipmentByPlayerLevel_lvl7upperBound(){
        map.createMap(7);
        assertTrue(map.getEquipment().size() <= 35 && map.getEquipment().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfEquipmentByPlayerLevel_lvl8upperBound(){
        map.createMap(8);
        assertTrue(map.getEquipment().size() <= 40 && map.getEquipment().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfEquipmentByPlayerLevel_lvl9upperBound(){
        map.createMap(9);
        assertTrue(map.getEquipment().size() <= 45 && map.getEquipment().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void checkNrOfEquipmentByPlayerLevel_lvl10upperBound(){
        map.createMap(10);
        assertTrue(map.getEquipment().size() <= 50 && map.getEquipment().size() <= map.getNrOfWalkableArea());
    }

    @Test
    void Map_toStringTest_NoInitializers(){
        StringBuilder expected = new StringBuilder();
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                expected.append("#");
            }
            expected.append("\n");
        }
        assertEquals(expected.toString(), map.toString());
    }

    @Test
    void Map_toStringTest_WithInitializers(){
        map = new BaseMap(30,11);

        StringBuilder expected = new StringBuilder();
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 11; j++){ //kolumner - x
                expected.append("#");
            }
            expected.append("\n");
        }
        assertEquals(expected.toString(), map.toString());
    }

}