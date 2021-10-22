package com.makkras.task.specification.impl;

import com.makkras.task.entity.impl.Sphere;
import com.makkras.task.service.MathHandler;
import com.makkras.task.service.impl.SphereMathHandler;
import com.makkras.task.specification.Specification;

public class CapacitySizeIsInRangeSpecification implements Specification {
    private double min;
    private double max;
    public CapacitySizeIsInRangeSpecification(double min,double max){
        this.min=min;
        this.max=max;
    }
    public boolean specify(Sphere sphere) {
        MathHandler mathHandler = new SphereMathHandler();
        return mathHandler.countCapacitySize(sphere) >min &&
                mathHandler.countCapacitySize(sphere)<max;
    }
}
