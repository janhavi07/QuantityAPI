package com.qm;

import com.qm.controller.QuantityMeasurementController;
import com.qm.model.IUnit;
import com.qm.model.LENGTH;
import com.qm.model.QuantityModel;
import com.qm.service.Mapping;
import com.qm.service.QuantityMeasurementService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuantityMeasurementControllerTest {

    @Mock
    QuantityMeasurementService quantityMeasurementService;

    @Mock
    Mapping mapping;

    @InjectMocks
    QuantityMeasurementController quantityMeasurementController;

    @BeforeEach
    void setUp() {
        quantityMeasurementService = mock(QuantityMeasurementService.class);
        quantityMeasurementController = new QuantityMeasurementController();
        mapping =mock(Mapping.class);
        quantityMeasurementController.setMockObjects(quantityMeasurementService,mapping);
    }

    @Test
    void givenTheRequiredValues_ShouldReturnDoubleValue() {
        QuantityModel quantityModel = new QuantityModel(1.0, 1.0, "feet", "feet", "feet");
        QuantityMeasurementService quantityMeasurementService1 = new QuantityMeasurementService(LENGTH.FEET, quantityModel.getValue1());
        QuantityMeasurementService quantityMeasurementService2 = new QuantityMeasurementService(LENGTH.FEET, quantityModel.getValue2());
        when(quantityMeasurementService.additionOfUnits(quantityMeasurementService1, quantityMeasurementService2, quantityModel)).thenReturn(2.0);
        double add = quantityMeasurementController.adding(quantityModel);
        Assert.assertEquals(2.0, add, 0.0);
    }
}

