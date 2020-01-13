package com.qm.model;

public enum WEIGHT implements IUnit {
    KILOGRAMS(1.0), GRAMS(0.001), TONNES(1000.0);

    public final double measurementValue;

    WEIGHT(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    @Override
    public Double conversion() {
        return this.measurementValue;
    }
}
