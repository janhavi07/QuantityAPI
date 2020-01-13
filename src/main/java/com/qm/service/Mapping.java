package com.qm.service;

import com.qm.model.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class Mapping {

    public static Map<String, IUnit> enumMap = new HashMap<>();

    public IUnit getConversionValue(String unit) {
        enumMap.put("feet", LENGTH.FEET);
        enumMap.put("inch", LENGTH.INCH);
        enumMap.put("centimeters", LENGTH.CENTIMETER);
        enumMap.put("yards", LENGTH.YARD);
        enumMap.put("kilogram", WEIGHT.KILOGRAMS);
        enumMap.put("grams",WEIGHT.GRAMS);
        enumMap.put("tonnes",WEIGHT.TONNES);
        enumMap.put("liters", VOLUME.LITRES);
        enumMap.put("milliliters",VOLUME.MILLILITERS);
        enumMap.put("gallon",VOLUME.GALLON);
        enumMap.put("celcius", TEMPERATURE.CELSIUS);
        enumMap.put("fahrenheit",TEMPERATURE.FAHRENHEIT);
        return enumMap.get(unit);
    }
}
