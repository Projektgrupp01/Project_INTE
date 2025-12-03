package io.github.Projektgrupp01.Project_INTE.Map;

import io.github.Projektgrupp01.Project_INTE.creatures.BaseNPC;
import io.github.Projektgrupp01.Project_INTE.creatures.NPC;
import io.github.Projektgrupp01.Project_INTE.equipment.Equipment;

import java.util.*;

public class Generator {

    private final List<String> NPCNames = new ArrayList<>();
    private final List<BaseNPC> NPCsList = new ArrayList<>();
    private final List<Equipment> EquipmentTemplates = new ArrayList<>();
    private final List<Equipment> equipmentList = new ArrayList<>();
    private final iRandomNumber random;

    public Generator() {
        this(new RandomNumber(new Random()));
    }

    public Generator(iRandomNumber random) {
        this.random = random;
    }

    public BaseNPC generateNPC() {
        String name = NPCNames.get(random.nextInt(NPCNames.size()));
        int health = random.nextInt(10, 100);
        NPC.Disposition disposition = getRandomDisposition();
        int speed = random.nextInt();
        int strength = random.nextInt();
        int energy = random.nextInt();
        BaseNPC newNPC = new BaseNPC(name, health, disposition, speed, strength, energy);
        NPCsList.add(newNPC);
        return newNPC;
    }

    public Equipment generateEquipment() {
        Equipment newEquipment = EquipmentTemplates.get(random.nextInt(EquipmentTemplates.size()));
        equipmentList.add(newEquipment);
        return newEquipment;
    }

    public void addNPCNames(String... names) {
        NPCNames.addAll(Arrays.asList(names));
    }

    public List<String> getNPCNames() {
        return Collections.unmodifiableList(NPCNames);
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

    public List<Equipment> getEquipment() {
        return Collections.unmodifiableList(equipmentList);
    }

}
