package io.github.Projektgrupp01.Project_INTE.Map;

import java.util.Arrays;

public class Map {

    private int x;
    private int y;
    private char [][] mapArray;

    public Map(){
        this(20,20);
    }

    public Map(int x, int y){
        this.x = x;
        this.y = y;
        createArray(x, y);
    }

    public char[][] getMap(){
        return mapArray;
    }

    private void createArray(int x, int y){
        mapArray = new char[x][y];
        //flytta till createmap-metod sen
        for(char[] row: mapArray){
            Arrays.fill(row, '#');
        }
    }

    @Override
    public String toString(){
        return Arrays.deepToString(mapArray);
    }



}
