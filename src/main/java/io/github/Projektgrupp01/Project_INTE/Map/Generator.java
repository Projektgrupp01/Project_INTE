package io.github.Projektgrupp01.Project_INTE.Map;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import io.github.Projektgrupp01.Project_INTE.equipment.EquipmentType;

import java.util.*;

public class Generator {

    List<String> NPCNames = new ArrayList<>();
    List<BaseNPC> NPCsList = new ArrayList<>();
    List<String> EquipmentNames = new ArrayList<>();
    List<Equipment> equipmentList = new ArrayList<>();
    Random random = new Random();

    public List<?> generate(String type, int amount){

        if(type.equalsIgnoreCase("npc") && amount > 0) {

            for (int i = 0; i < amount; i++) {

                NPCsList.add(addNPC());
            }

            return Collections.unmodifiableList(NPCsList);

        }else if(type.equalsIgnoreCase("equipment") && amount > 0){
            for (int i = 0; i < amount; i++) {

                equipmentList.add(addEquipment());
            }

            return Collections.unmodifiableList(equipmentList);
        }

        throw new IllegalArgumentException("Type must be npc or equipment, amount must be an integer.");

    }

    public void addNPCNames(String...names){
        NPCNames.addAll(Arrays.asList(names));
    }

    public List<String> getNPCNames(){
        return Collections.unmodifiableList(NPCNames);
    }

    private BaseNPC addNPC(/*BaseNPC npc*/){
        String name = NPCNames.get(random.nextInt(NPCNames.size()));
        int health = random.nextInt(10, 100);
        NPC.Disposition disposition = getRandomDisposition();
        int speed = random.nextInt();
        int strength = random.nextInt();
        int energy = random.nextInt();
        //borde ha test som kontrollerar att attribut sätts korrekt? eller finns det i npc?
        return new BaseNPC(name, health, disposition, speed, strength, energy);
    }

    private NPC.Disposition getRandomDisposition(){
        NPC.Disposition[] dispositions = NPC.Disposition.values();
        return dispositions[random.nextInt(dispositions.length)];
    }

    public List<BaseNPC> getNPCs(){
        return Collections.unmodifiableList(NPCsList);
    }

    public void addEquipmentNames(String...names){
        EquipmentNames.addAll(Arrays.asList(names));
    }

    private Equipment addEquipment(){
        String name = EquipmentNames.get(random.nextInt(EquipmentNames.size()));
        EquipmentType type = getRandomEquipmentType();
        return new Equipment(name, type);
    }

    private EquipmentType getRandomEquipmentType(){
        EquipmentType[] equipmentTypes = EquipmentType.values();
        return equipmentTypes[random.nextInt(equipmentTypes.length)];
    }

    //ev ta bort denna metod. alt lägg t likadan för npc
    public List<Equipment> getEquipment(){
        return Collections.unmodifiableList(equipmentList);
    }

}
