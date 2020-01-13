package com.qm.model;

public enum VOLUME implements IUnit{

    GALLON(3.78),LITRES(1),MILLILITERS(0.001);

    public final double measurementValue;

    VOLUME(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    @Override
    public Double conversion() {
        return this.measurementValue;
    }
}
