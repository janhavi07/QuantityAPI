package com.qm.model;

public enum TEMPERATURE implements IUnit {
    FAHRENHEIT(32.0), CELSIUS(1.0);

    public final double measurementValue;

    TEMPERATURE(Double measurementValue) {
        this.measurementValue = measurementValue;
    }

    @Override
    public Double conversion() {
        if (this.equals(FAHRENHEIT))
            return FAHRENHEIT.measurementValue;
        return CELSIUS.measurementValue;
    }
}
