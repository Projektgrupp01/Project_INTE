package io.github.Projektgrupp01.Project_INTE.Map;

import java.util.*;

public class Generator<T> {

    List<String> NPCNames = new ArrayList<>();
    List<T> objectList = new ArrayList<>();

    public List<T> generate(String type, int amount){
        Random random = new Random();

        if((type.equalsIgnoreCase("npc") || type.equalsIgnoreCase("equipment")) && amount > 0) {

            for (int i = 0; i < amount; i++) {

                //objectList.add(random.nextInt(1, amount));
            }

            return Collections.unmodifiableList(objectList);

        }
//        }else if(type.equals(null)){
//
//        }else {

            throw new IllegalArgumentException("Type must be npc or equipment, amount must be an integer.");


    }

    public void addNPCNames(String...names){
        NPCNames.addAll(Arrays.asList(names));
    }

    public List<String> getNPCNames(){
        return Collections.unmodifiableList(NPCNames);
    }


}
