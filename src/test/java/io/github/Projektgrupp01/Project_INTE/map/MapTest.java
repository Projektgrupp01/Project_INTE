package io.github.Projektgrupp01.Project_INTE.map;

import static org.junit.jupiter.api.Assertions.*;

import io.github.Projektgrupp01.Project_INTE.Map.BaseMap;
import io.github.Projektgrupp01.Project_INTE.Map.RandomNumber;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import io.github.Projektgrupp01.Project_INTE.equipment.EquipmentType;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class MapTest {

    private final String[] NPCNames = {"Bertil", "Mina", "Gustav"};
    private final Equipment[] equipmentTemplates = {new Equipment("Shield", EquipmentType.SHIELD), new Equipment("Sword", EquipmentType.WEAPON), new Equipment("Treasure", EquipmentType.CHEST)};

    @Test
    void getMapTest_noInitializers() {
        BaseMap map = new BaseMap();
        char[][] expected = {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};
        assertArrayEquals(expected, map.getMap());
    }

    @Test
    void getMapTest_withInitializers() {
        BaseMap map = new BaseMap(4, 3, new MockRandomNumber(1));
        char[][] expected = {{'#', '#', '#'}, {'#', '#', '#'}, {'#', '#', '#'}, {'#', '#', '#'}};
        assertArrayEquals(expected, map.getMap());
    }

    @Test
    void createArrayTest_x_noInitializers() {
        BaseMap map = new BaseMap();
        char[][] mapArray = map.getMap();
        assertEquals(10, mapArray[0].length);
    }

    @Test
    void createArrayTest_y_noInitializers() {
        BaseMap map = new BaseMap();
        char[][] mapArray = map.getMap();
        assertEquals(10, mapArray.length);
    }

    @Test
    void generateRandomNrTest() {
        RandomNumber rnd = new RandomNumber(new Random());
        int nr = rnd.nextInt(3);
        assertTrue(nr >= 0 && nr <= 3);
    }

    @Test
    void walkableAreaTest_IsZeroBeforeMapCreation() {
        BaseMap map = new BaseMap();
        assertEquals(0, map.getNrOfWalkableArea());
    }

    @Test
    void createMapTest_tunnelsExist() {
        BaseMap map = new BaseMap();
        map.createMap(1, 10);
        int expected = 10;
        assertEquals(expected, map.getNrOfWalkableArea(), "Map: " + map.toString());
    }

    @Test
    void createMapTest_tunnelsExistInPopulatedMap() {
        BaseMap map = new BaseMap();
        map.createMap(1, 10);
        map.initializeGenerator(NPCNames, equipmentTemplates);
        map.populateMap('n', 3);
        map.populateMap('x', 3);
        int expected = 10 - map.getNPCs().size() - map.getEquipment().size();
        assertEquals(expected, map.getNrOfWalkableArea(), "Map: " + map.toString());
    }

    @Test
    void createMapTest_SeededRandomGivesSameMap() {
        Random rnd1 = new Random(1);
        BaseMap map1 = new BaseMap(10, 10, new RandomNumber(rnd1));
        map1.createMap(1, 100);

        Random rnd2 = new Random(1);
        BaseMap map2 = new BaseMap(10, 10, new RandomNumber(rnd2));
        map2.createMap(1, 100);
        assertEquals(map1.toString(), map2.toString());
    }

    @Test
    void createMapTest_RandomGivesDifferentMap() {
        Random rnd1 = new Random();
        BaseMap map1 = new BaseMap(10, 10, new RandomNumber(rnd1));
        map1.createMap(1, 100);

        Random rnd2 = new Random();
        BaseMap map2 = new BaseMap(10, 10, new RandomNumber(rnd2));
        map2.createMap(1, 100);
        assertNotEquals(map1.toString(), map2.toString());
    }

    @Test
    void createMapTest_RandomMapIsDifferentFromMockMap() {
        BaseMap map1 = new BaseMap(10, 10, new MockRandomNumber(1));
        map1.createMap();
        BaseMap map2 = new BaseMap(10, 10, new RandomNumber(new Random(1)));
        map2.createMap();
        assertNotEquals(map1.toString(), map2.toString());
    }

    @Test
    void createMapTest_newRowOutOfBounds() {
        BaseMap map = new BaseMap(2, 2, new MockRandomNumber(2));
        map.createMap();
        String expected = "  \n##\n";
        assertEquals(expected, map.toString());
    }

    @Test
    void createMapTest_newColumnOutOfBounds() {
        BaseMap map = new BaseMap(2, 2, new MockRandomNumber(0));
        map.createMap();
        String expected = "  \n##\n";
        assertEquals(expected, map.toString());
    }

    @Test
    void populateMapTest_cannotPopulateMapWithoutTunnels() {
        BaseMap map = new BaseMap();
        map.initializeGenerator(NPCNames, equipmentTemplates);
        map.populateMap('x', 3);
        assertEquals(0, map.getEquipment().size());
    }

    @Test
    void populateMapTest_canAddNPCsToMap() {
        BaseMap map = new BaseMap();
        map.createMap();
        map.initializeGenerator(NPCNames, equipmentTemplates);
        map.populateMap('n', 3);
        assertEquals(3, map.getNPCs().size());
    }

    @Test
    void populateMapTest_canAddEquipmentToMap() {
        BaseMap map = new BaseMap();
        map.createMap();
        map.initializeGenerator(NPCNames, equipmentTemplates);
        map.populateMap('x', 3);
        assertEquals(3, map.getEquipment().size());
    }

    @Test
    void populateMapTest_cannotAddUnknownItemsToMap() {
        BaseMap map = new BaseMap();
        map.createMap(1, 100);
        assertThrows(IllegalArgumentException.class, () -> map.populateMap('a', 1));
    }

    @Test
    void Map_toStringTest_NoInitializers() {
        BaseMap map = new BaseMap();
        String expected = "##########\n" +
                "##########\n" +
                "##########\n" +
                "##########\n" +
                "##########\n" +
                "##########\n" +
                "##########\n" +
                "##########\n" +
                "##########\n" +
                "##########\n";
        assertEquals(expected, map.toString());
    }

    @Test
    void Map_toStringTest_WithInitializers() {
        BaseMap map = new BaseMap(2, 3, new MockRandomNumber(1));
        String expected = "###\n" +
                "###\n";
        assertEquals(expected, map.toString());
    }
}