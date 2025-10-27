package io.github.Projektgrupp01.Project_INTE.Map;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BaseMap implements Map{

    private int x;
    private int y;
    private final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private char [][] mapArray;

    public BaseMap(){
        this(20,20);
    }

    public BaseMap(int x, int y){
        this.x = x;
        this.y = y;
        createArray(x, y);
    }

    public char[][] getMap(){
        return mapArray;
    }

    public List<BaseNPC> getNPCs(){
        return new ArrayList<BaseNPC>();
    }

    public List<Equipment> getEquipment(){
        return new ArrayList<Equipment>();
    }

    //finns det ngn anledning till att ha kvar denna metod över huvud taget?
    // ev slå ihop m createMap sen
    private void createArray(int x, int y){
        mapArray = new char[x][y];
//        //flytta till createmap-metod sen
       for(char[] row: mapArray){
            Arrays.fill(row, '#');
        }
    }

    public void createMap(){
         //randomwalk
        Random rand = new Random();
        int steps = 300;

        //startar i övre vänstra hörnet
        mapArray[0][0] = ' ';
        int currentRow = 0;
        int currentColumn = 1;

        for (int i = 0; i < steps; i++) {
            //byt ut vägg-tecken mot mark-tecken
            mapArray[currentRow][currentColumn] = ' ';

            //slumpa fram en riktning
            int[] dir = DIRECTIONS[rand.nextInt(DIRECTIONS.length)];
            int newRow = currentRow + dir[0];
            int newColumn = currentColumn + dir[1];

            // Kontrollera gränser
            if (newRow >= 0 && newRow < x && newColumn >= 1 && newColumn < y) {
                currentRow = newRow;
                currentColumn = newColumn;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder mapString = new StringBuilder();
        
        for(char [] row: mapArray){
            for(char c: row){
                mapString.append(c);
            }
            mapString.append("\n");
        }
        
        return mapString.toString();
        
    }



}
