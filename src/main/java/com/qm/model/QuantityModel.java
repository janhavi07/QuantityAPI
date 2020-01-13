package com.qm.model;

public class QuantityModel {
    Double value1;
    Double value2;
    String unit1;
    String unit2;
    String answerValue;

    public QuantityModel(Double value1, Double value2, String unit1, String unit2, String answerValue) {
        this.value1 = value1;
        this.value2 = value2;
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.answerValue = answerValue;
    }

    public QuantityModel() {
    }

    public Double getValue1() {
        return value1;
    }


    public Double getValue2() {
        return value2;
    }

    public String getUnit1() {
        return unit1;
    }


    public String getUnit2() {
        return unit2;
    }

    public String getAnswerValue() {
        return answerValue;
    }
}
