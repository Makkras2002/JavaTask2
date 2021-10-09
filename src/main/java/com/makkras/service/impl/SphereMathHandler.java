package com.makkras.service.impl;

import com.makkras.entity.CustomShape;
import com.makkras.service.MathHandler;

public class SphereMathHandler implements MathHandler {
    public double countAreaSize(CustomShape shape) {
        return 4*Math.PI* Math.pow(shape.getRadius(),2);
    }

    @Override
    public double countCapacitySize(CustomShape shape) {
        return (4*Math.PI*Math.pow(shape.getRadius(),3))/3;
    }
}
