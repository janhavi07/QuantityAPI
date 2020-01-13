package com.qm.service;

import com.qm.exception.QuantityMeasurementException;
import com.qm.model.IUnit;
import com.qm.model.QuantityModel;
import com.qm.model.TEMPERATURE;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class QuantityMeasurementService {

    public Double value;
    public IUnit units;

    public QuantityMeasurementService() {
    }

    public QuantityMeasurementService(IUnit unit, Double value) {
        this.value = value;
        this.units = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityMeasurementService that = (QuantityMeasurementService) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(units, that.units);
    }

    public boolean compareUnits(QuantityMeasurementService that) throws QuantityMeasurementException {
        if (!that.units.getClass().equals(this.units.getClass())) {
            throw new QuantityMeasurementException("Class Not Equal", QuantityMeasurementException.ExceptionType.CLASS_NOT_EQUAL);
        }
        return Double.compare((this.value * this.units.conversion()), (that.value * that.units.conversion())) == 0;
    }


    public double additionOfUnits(QuantityMeasurementService current, QuantityMeasurementService that, QuantityModel quantityModel) {
        Mapping mapping = new Mapping();
        IUnit conversionValue = mapping.getConversionValue(quantityModel.getAnswerValue());
        return (((current.value * current.units.conversion()) + (that.value * that.units.conversion())) / conversionValue.conversion());
    }

    public Boolean temperatureConversion(QuantityMeasurementService that) {
        if (this.units.equals(TEMPERATURE.CELSIUS))
            return Double.compare(Math.round(this.value - TEMPERATURE.FAHRENHEIT.measurementValue * (5 / 9)), Math.round(this.value)) == 0;
        return Double.compare(Math.round((that.value * 9 / 5) + 32), Math.round(this.value)) == 0;
    }

}
