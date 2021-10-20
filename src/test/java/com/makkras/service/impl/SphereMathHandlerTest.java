package com.makkras.service.impl;

import com.makkras.entity.CustomShape;
import com.makkras.entity.factory.CustomShapeFactory;
import com.makkras.entity.factory.impl.ShapeFactory;
import com.makkras.service.MathHandler;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SphereMathHandlerTest {
    private CustomShape sphere;
    private CustomShapeFactory factory;
    private MathHandler mathHandler;
    @BeforeClass
    public void setUp() {
        mathHandler = new SphereMathHandler();
        factory = new ShapeFactory();
        sphere = factory.createShape();
        sphere.setRadius(5);
    }
    @Test
    public void countCapacityTest(){
        assertEquals(523,mathHandler.countCapacitySize(sphere),2);
    }
    @Test
    public void countAreaSizeTest(){
        assertEquals(314,mathHandler.countAreaSize(sphere),2);
    }
}