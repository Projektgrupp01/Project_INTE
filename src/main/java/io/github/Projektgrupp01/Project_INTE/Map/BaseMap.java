package io.github.Projektgrupp01.Project_INTE.Map;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import io.github.Projektgrupp01.Project_INTE.equipment.EquipmentType;

import java.util.*;

public class BaseMap implements Map {

    private final int x;
    private final int y;
    private final Random random = new Random();
    private final Generator generator = new Generator();
    private final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private char[][] mapArray;
    private int walkableArea;
    private final char TUNNEL = ' ';
    private final char EQUIPMENT = 'x';
    private final char NPC = 'n';
    private final String[] NPCNames = {"Bertil", "Mina", "Gustav"};
    private final Equipment[] equipmentTemplates = {new Equipment("Shield", EquipmentType.SHIELD), new Equipment("Sword", EquipmentType.WEAPON), new Equipment("Treasure", EquipmentType.CHEST)};
    private ArrayList<BaseNPC> listOfNPCs;
    private ArrayList<Equipment> listOfEquipment;

    public BaseMap() {
        this(20, 20);
    }

    public BaseMap(int x, int y) {
        this.x = x;
        this.y = y;
        createArray(x, y);
        initializeGenerator();
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

    public void createMap(int level) {
        createMap(level, 300);
    }

    public void createMap(int level, int steps) {
        listOfNPCs = new ArrayList<>();
        listOfEquipment = new ArrayList<>();

        mapArray[0][0] = TUNNEL;
        walkableArea = 1;
        int currentRow = 0;
        int currentColumn = 1;

        for (int i = 0; i < steps; i++) {
            mapArray[currentRow][currentColumn] = ' ';
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

        int nrOfNPCs = level * random.nextInt(1, 5);
        int nrOfEquipment = level * random.nextInt(1, 5);

        populateMap(NPC, nrOfNPCs);
        populateMap(EQUIPMENT, nrOfEquipment);

    }

    private void populateMap(char object, int nrOfObject) {
        for (int i = 0; i < nrOfObject; i++) {
            boolean placed = false;
            int attempts = 0;
            while (!placed && attempts < (x * y)) {
                int posX = random.nextInt(x);
                int posY = random.nextInt(y);
                if (mapArray[posX][posY] == TUNNEL) {
                    mapArray[posX][posY] = object;
                    placed = true;
                    if (object == NPC) {
                        listOfNPCs.add(generator.generateNPC());
                    } else if (object == EQUIPMENT) {
                        listOfEquipment.add(generator.generateEquipment());
                    }
                } else {
                    attempts++;
                }
            }
        }
    }

    private void initializeGenerator() {
        initializeGenerator(NPCNames, equipmentTemplates);
    }

    private void initializeGenerator(String[] NPCNames, Equipment[] equipment) {
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
