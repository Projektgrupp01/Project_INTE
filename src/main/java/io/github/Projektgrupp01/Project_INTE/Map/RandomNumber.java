package io.github.Projektgrupp01.Project_INTE.Map;

import java.util.Random;

public class RandomNumber implements iRandomNumber {

    private final Random random;

    public RandomNumber(Random random){
        this.random = random;
    }

    @Override
    public int nextInt(){
        return random.nextInt();
    }

    @Override
    public int nextInt(int bound){
        return random.nextInt(bound);
    }

    @Override
    public int nextInt(int lowerBound, int upperBound){
        return random.nextInt(lowerBound, upperBound);
    }

}
