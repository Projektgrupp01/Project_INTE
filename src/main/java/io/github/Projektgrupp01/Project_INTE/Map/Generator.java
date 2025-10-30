package io.github.Projektgrupp01.Project_INTE.Map;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;
import io.github.Projektgrupp01.Project_INTE.equipment.EquipmentType;

import java.util.*;

public class Generator {

    List<String> NPCNames = new ArrayList<>();
    List<BaseNPC> NPCsList = new ArrayList<>();
    List<Equipment> EquipmentTemplates = new ArrayList<>();
    List<Equipment> equipmentList = new ArrayList<>();
    Random random = new Random();

    public List<BaseNPC> generateNPC(char type, int amount) {
        if (type == 'n' && amount > 0) {
            for (int i = 0; i < amount; i++) {
                NPCsList.add(addNPC());
            }
            return Collections.unmodifiableList(NPCsList);
        } else {
            throw new IllegalArgumentException("Not a recognized type, or amount is too low.");
        }
    }

    public List<Equipment> generateEquipment(char type, int amount) {
        if (type == 'x' && amount > 0) {
            for (int i = 0; i < amount; i++) {
                equipmentList.add(addEquipment());
            }
            return Collections.unmodifiableList(equipmentList);
        } else {
            throw new IllegalArgumentException("Not a recognized type, or amount is too low.");
        }
    }

    public void addNPCNames(String... names) {
        NPCNames.addAll(Arrays.asList(names));
    }

    public List<String> getNPCNames() {
        return Collections.unmodifiableList(NPCNames);
    }

    private BaseNPC addNPC(/*BaseNPC npc*/) {
        String name = NPCNames.get(random.nextInt(NPCNames.size()));
        int health = random.nextInt(10, 100);
        NPC.Disposition disposition = getRandomDisposition();
        int speed = random.nextInt();
        int strength = random.nextInt();
        int energy = random.nextInt();
        return new BaseNPC(name, health, disposition, speed, strength, energy);
    }

    private NPC.Disposition getRandomDisposition() {
        NPC.Disposition[] dispositions = NPC.Disposition.values();
        return dispositions[random.nextInt(dispositions.length)];
    }

    public List<BaseNPC> getNPCs() {
        return Collections.unmodifiableList(NPCsList);
    }

    public void addEquipmentTemplates(Equipment... equipment) {
        EquipmentTemplates.addAll(Arrays.asList(equipment));
    }

    public List<Equipment> getEquipmentTemplates() {
        return Collections.unmodifiableList(EquipmentTemplates);
    }

    private Equipment addEquipment() {
        return EquipmentTemplates.get(random.nextInt(EquipmentTemplates.size()));
    }

    public List<Equipment> getEquipment() {
        return Collections.unmodifiableList(equipmentList);
    }

}
