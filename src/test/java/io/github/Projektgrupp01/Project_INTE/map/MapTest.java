package io.github.Projektgrupp01.Project_INTE.map;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import io.github.Projektgrupp01.Project_INTE.Map.Map;

import java.util.Arrays;

public class MapTest {

    @Test
    void toStringTest_NoInitializers(){
        Map map = new Map();
        char[][] array = new char[20][20];
        for(char[] row: array) {
            Arrays.fill(row, '#');
        }
        assertEquals(map.toString(), Arrays.deepToString(array));
    }

    @Test
    void toStringTest_WithInitializers(){
        Map map = new Map(3,11);
        char[][] array = new char[3][11];
        for(char[] row: array) {
            Arrays.fill(row, '#');
        }
        assertEquals(map.toString(), Arrays.deepToString(array));
    }

}