package io.github.Projektgrupp01.Project_INTE.Map;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;

import java.util.*;

public class BaseMap implements Map {

    private final int x;
    private final int y;
    private final iRandomNumber random;
    private final Generator generator = new Generator();
    private final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private char[][] mapArray;
    private int walkableArea;
    private final char TUNNEL = ' ';
    private final char EQUIPMENT = 'x';
    private final char NPC = 'n';
    private ArrayList<BaseNPC> listOfNPCs = new ArrayList<>();
    private ArrayList<Equipment> listOfEquipment = new ArrayList<>();

    public BaseMap() {
        this(10, 10, new RandomNumber(new Random()));
    }

    public BaseMap(int x, int y, iRandomNumber random) {
        this.x = x;
        this.y = y;
        this.random = random;
        createArray(x, y);
    }

    public char[][] getMap() {
        return mapArray;
    }


    public int getNrOfWalkableArea() {
        return walkableArea;
    }

    public List<BaseNPC> getNPCs() {
        return Collections.unmodifiableList(listOfNPCs);
    }

    public List<Equipment> getEquipment() {
        return Collections.unmodifiableList(listOfEquipment);
    }

    private void createArray(int x, int y) {
        mapArray = new char[x][y];
        for (char[] row : mapArray) {
            Arrays.fill(row, '#');
        }
    }

    public void createMap() {
        createMap(1, 300);
    }

    public void createMap(int level, int steps) {
        mapArray[0][0] = TUNNEL;
        walkableArea = 1;
        int currentRow = 0;
        int currentColumn = 1;

        for (int i = 0; i < steps - 1; i++) {
            mapArray[currentRow][currentColumn] = TUNNEL;
            walkableArea++;

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
    }

    public void populateMap(char object, int nrOfObject) {
        for (int i = 0; i < nrOfObject; i++) {
            boolean placed = false;
            int attempts = 0;
            while (!placed && attempts < (walkableArea)) {
                int posX = random.nextInt(x);
                int posY = random.nextInt(y);
                if (mapArray[posX][posY] == TUNNEL) {
                    if (addPlacedObjectToList(object)) {
                        mapArray[posX][posY] = object;
                        walkableArea--;
                        placed = true;
                    } else {
                        throw new IllegalArgumentException("Unknown objects cannot be added to the map");
                    }
                } else {
                    attempts++;
                }
            }
        }
    }

    private boolean addPlacedObjectToList(char object) {
        if (object == NPC) {
            return listOfNPCs.add(generator.generateNPC());
        } else if (object == EQUIPMENT) {
            return listOfEquipment.add(generator.generateEquipment());
        }
        return false;
    }

    public void initializeGenerator(String[] NPCNames, Equipment[] equipment) {
        generator.addNPCNames(NPCNames);
        generator.addEquipmentTemplates(equipment);
    }

    @Override
    public String toString() {
        StringBuilder mapString = new StringBuilder();
        for (char[] row : mapArray) {
            for (char c : row) {
                mapString.append(c);
            }
            mapString.append("\n");
        }
        return mapString.toString();
    }
}
