package io.github.Projektgrupp01.Project_INTE.Map;

import java.util.Arrays;

public class Map implements BaseMap {

    private int x;
    private int y;
    private char [][] mapArray;

    public Map(){
        this(20,20);
    }

    public Map(int x, int y){
        //indatakontroller?
        this.x = x;
        this.y = y;
        createArray(x, y);
    }

    public char[][] getMap(){
        return mapArray;
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
