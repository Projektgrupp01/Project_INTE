package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//borde nog dokumentera detta i google-doket:
public class MapTest {

    @Test
    void toStringTest(){
        Map map = new Map();
        char[][] array = {{20,20}};
        assertEquals(map.toString(), array.toString());
    }

}