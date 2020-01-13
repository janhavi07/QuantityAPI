package com.qm.controller;

import com.qm.exception.QuantityMeasurementException;
import com.qm.model.IUnit;
import com.qm.model.QuantityModel;
import com.qm.service.Mapping;
import com.qm.service.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.EnumMap;

@RestController
@RequestMapping("/measurements")
public class QuantityMeasurementController {

    @Autowired
    QuantityMeasurementService quantityMeasurementService;
    @Autowired
    Mapping mapping;

    @GetMapping("/compare")
    public boolean compareUnits(@RequestParam(value = "unit1") String unit1, @RequestParam(value = "value1") Double value1,
                                @RequestParam(value = "unit2") String unit2, @RequestParam(value = "value2") Double value2) {
        Mapping mapping = new Mapping();
        QuantityMeasurementService unitDTO = new QuantityMeasurementService(mapping.getConversionValue(unit1), value1);
        QuantityMeasurementService unitDTO1 = new QuantityMeasurementService(mapping.getConversionValue(unit2), value2);
        try {
            return unitDTO.compareUnits(unitDTO1);
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
        return false;
    }

    @GetMapping("/adding")
    public double adding(@RequestBody QuantityModel quantityModel){
        Mapping mapping = new Mapping();
        IUnit conversionValue1 = mapping.getConversionValue(quantityModel.getUnit1());
        IUnit conversionValue2 = mapping.getConversionValue(quantityModel.getUnit2());
        QuantityMeasurementService quantityMeasurementService1 = new QuantityMeasurementService(conversionValue1, quantityModel.getValue1());
        QuantityMeasurementService quantityMeasurementService2 = new QuantityMeasurementService(conversionValue2, quantityModel.getValue2());
        return quantityMeasurementService.additionOfUnits(quantityMeasurementService1,quantityMeasurementService2,quantityModel);
    }

    @GetMapping("/converttemp")
    public Boolean addUnits(@RequestParam(value = "temp1") String temp1,@RequestParam(value = "value1") Double value1,
                            @RequestParam(value = "temp2") String temp2, @RequestParam(value = "value2") Double value2){
        Mapping mapping = new Mapping();
        QuantityMeasurementService unitDTO = new QuantityMeasurementService(mapping.getConversionValue(temp1), value1);
        QuantityMeasurementService unitDTO1 = new QuantityMeasurementService(mapping.getConversionValue(temp2), value2);
        return unitDTO.temperatureConversion(unitDTO1);
    }

    public void setMockObjects(QuantityMeasurementService quantityMeasurementService, Mapping mapping) {
        this.quantityMeasurementService=quantityMeasurementService;
        this.mapping=mapping;
    }
}
