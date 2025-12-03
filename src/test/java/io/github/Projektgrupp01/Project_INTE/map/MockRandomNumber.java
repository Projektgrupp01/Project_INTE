package io.github.Projektgrupp01.Project_INTE.map;

import io.github.Projektgrupp01.Project_INTE.Map.iRandomNumber;

public class MockRandomNumber implements iRandomNumber {

    private final int notRandom;

    public MockRandomNumber(int notRandom) {
        this.notRandom = notRandom;
    }

    @Override
    public int nextInt() {
        return notRandom;
    }

    @Override
    public int nextInt(int bound) {
        if (notRandom > bound) {
            throw new IllegalArgumentException("Bound cannot be lower than random");
        }
        return notRandom;
    }

    @Override
    public int nextInt(int lowerBound, int upperBound) {
        if (notRandom > upperBound) {
            throw new IllegalArgumentException("Bound cannot be lower than random");
        }
        return notRandom;
    }

}

