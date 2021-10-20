package com.makkras.validator.impl;

import com.makkras.validator.SphereValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SphereCorrectnessValidatorTest {
    private String[] rawData;
    private SphereValidator validator;
    @BeforeMethod
    public void setUp() {
        rawData = new String[]{"112","Jack","1","2","1","7"};
        validator = new SphereCorrectnessValidator();
    }
    @Test
    public void CheckIfSphere(){
        assertTrue(validator.checkIfSphere(rawData));
    }
}