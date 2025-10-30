package io.github.Projektgrupp01.Project_INTE.Map;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;

import java.util.*;

import static io.github.Projektgrupp01.Project_INTE.creatures.NPC.Disposition.HOSTILE;
import static io.github.Projektgrupp01.Project_INTE.equipment.EquipmentType.CHEST;

public class BaseMap implements Map{

    private int x;
    private int y;
    private final Random random = new Random();
    private final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private char [][] mapArray;
    private final char EQUIPMENT = 'x';
    private final char NPC = 'n';
    private final ArrayList<BaseNPC> listOfNPCs = new ArrayList<>();
    private final ArrayList<Equipment> listOfEquipment = new ArrayList<>();

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
        return Collections.unmodifiableList(listOfNPCs);
    }

    public List<Equipment> getEquipment(){
        return Collections.unmodifiableList(listOfEquipment);
    }

    private void createArray(int x, int y){
        mapArray = new char[x][y];
       for(char[] row: mapArray){
            Arrays.fill(row, '#');
       }
    }

    public void createMap(){
        createMap(1, 300);
    }

    public void createMap(int level){
        createMap(level, 300);
    }

    public void createMap(int level, int steps){
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

        int nrOfNPCs = level * random.nextInt(1,5);
        int nrOfEquipment = level * random.nextInt(1,5);

        populateMap(NPC, nrOfNPCs);
        populateMap(EQUIPMENT, nrOfEquipment);

    }

    private void populateMap(char object, int nrOfObject){
        for(int i = 0; i < nrOfObject; i++){
            int posX = random.nextInt(x);
            int posY = random.nextInt(y);
            if(mapArray[posX][posY] == ' '){
                mapArray[posX][posY] = object;
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
