package io.github.Projektgrupp01.Project_INTE.Map;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseMap implements Map{

    private int x;
    private int y;
    private char [][] mapArray;

    public BaseMap(){
        this(20,20);
    }

    public BaseMap(int x, int y){
        this.x = x;
        this.y = y;
        createArray(y, x);
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
    private void createArray(int y, int x){
        mapArray = new char[y][x];
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
