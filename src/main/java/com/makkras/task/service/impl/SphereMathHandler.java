package com.makkras.task.service.impl;

import com.makkras.task.entity.CustomShape;
import com.makkras.task.service.MathHandler;

public class SphereMathHandler implements MathHandler {
    public double countAreaSize(CustomShape shape) {
        return 4*Math.PI* Math.pow(shape.getRadius(),2);
    }
    public double countCapacitySize(CustomShape shape) {
        return (4*Math.PI*Math.pow(shape.getRadius(),3))/3;
    }
    public double countCapacityCorrelationCreatedByCordSpaceXYCutSphere(CustomShape shape){
        double h1 = shape.getCenter().getZAxis() + shape.getRadius();
        double h2 = shape.getRadius() - shape.getCenter().getZAxis();
        if(h2<=0){
            return 0;
        }else {
            return (((Math.PI * Math.pow(h1,2)*(3*shape.getRadius() - h1))/3)   /  ((Math.PI * Math.pow(h2,2)*(3*shape.getRadius() - h2))/3));
        }
    }
    public boolean doesSphereTouchAnyCordArea(CustomShape shape){
        return (shape.getCenter().getXAxis() == shape.getRadius()) ||
                (shape.getCenter().getYAxis() == shape.getRadius()) ||
                (shape.getCenter().getZAxis() == shape.getRadius());
    }
}
