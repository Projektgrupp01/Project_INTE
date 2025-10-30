package io.github.Projektgrupp01.Project_INTE.Map;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import io.github.Projektgrupp01.Project_INTE.equipment.EquipmentType;

import java.util.*;

public class Generator {

    List<String> NPCNames = new ArrayList<>();
    List<BaseNPC> NPCsList = new ArrayList<>();
    List<Equipment> equipmentList = new ArrayList<>();

    //alt. gör generisk. sen.
    public List<Object> generate(String type, int amount){
        Random random = new Random();

        if((type.equalsIgnoreCase("npc") || type.equalsIgnoreCase("equipment")) && amount > 0) {

            for (int i = 0; i < amount; i++) {

                //objectList.add(random.nextInt(1, amount));
            }

            return Collections.unmodifiableList(new ArrayList<>());

        }

        throw new IllegalArgumentException("Type must be npc or equipment, amount must be an integer.");

    }

    public void addNPCNames(String...names){
        NPCNames.addAll(Arrays.asList(names));
    }

    public List<String> getNPCNames(){
        return Collections.unmodifiableList(NPCNames);
    }

    public void addEquipment(Equipment equipment){
        equipmentList.add(equipment);
    }

    public List<Equipment> getEquipment(){
        return Collections.unmodifiableList(equipmentList);
    }


}
