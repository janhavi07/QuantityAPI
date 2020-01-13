package com.qm.service;

import com.qm.exception.QuantityMeasurementException;
import org.springframework.stereotype.Service;

@Service
public interface IQuantityMeasurementService {
    boolean compareUnits(QuantityMeasurementService that) throws QuantityMeasurementException;

//    double additionOfUnits(QuantityMeasurementService that);
//
//    Boolean temperatureConversion(QuantityMeasurementService that);
}
