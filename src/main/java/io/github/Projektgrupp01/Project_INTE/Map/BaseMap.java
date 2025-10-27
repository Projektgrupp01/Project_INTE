package io.github.Projektgrupp01.Project_INTE.Map;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static io.github.Projektgrupp01.Project_INTE.creatures.NPC.Disposition.HOSTILE;
import static io.github.Projektgrupp01.Project_INTE.equipment.EquipmentType.CHEST;

public class BaseMap implements Map{

    private int x;
    private int y;
    private Random random = new Random();
    private final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private char [][] mapArray;
    private final char EQUIPMENT = 'x';
    private final char NPC = 'n'; //ev ändra om du lägger till olika typer/vill lägga till specifik typ
    private ArrayList<BaseNPC> listOfNPCs = new ArrayList<>();
    private ArrayList<Equipment> listOfEquipment = new ArrayList<>();

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
       for(char[] row: mapArray){
            Arrays.fill(row, '#');
        }
    }

    public void createMap(){
        int steps = 300;

        mapArray[0][0] = ' ';
        int currentRow = 0;
        int currentColumn = 1;

        for (int i = 0; i < steps; i++) {
            mapArray[currentRow][currentColumn] = ' ';

            //slumpa fram en riktning
            int[] dir = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            int newRow = currentRow + dir[0];
            int newColumn = currentColumn + dir[1];

            // Kontrollera gränser
            if (newRow >= 0 && newRow < x && newColumn >= 1 && newColumn < y) {
                currentRow = newRow;
                currentColumn = newColumn;
            }
        }

        populateMap(NPC, random.nextInt(1,5));
        populateMap(EQUIPMENT, random.nextInt(1,5));

    }

    private void populateMap(char object, int nrOfObject){
        for(int i = 0; i < nrOfObject; i++){
            int posX = random.nextInt(x);
            int posY = random.nextInt(y);
            if(mapArray[posX][posY] == ' '){
                mapArray[posX][posY] = object;
                //fixa slumpning
                if(object == NPC){ listOfNPCs.add(new BaseNPC("namnsson", 10, HOSTILE));}
                else if(object == EQUIPMENT){listOfEquipment.add(new Equipment("namn", CHEST ));}
            }else{
                i--;
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
