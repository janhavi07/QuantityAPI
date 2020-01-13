package com.qm.exception;

public class QuantityMeasurementException extends Exception {

     ExceptionType type;

    public enum ExceptionType{
        CLASS_NOT_EQUAL;
    }

    public QuantityMeasurementException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
