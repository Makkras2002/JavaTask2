package com.makkras.specification.impl;

import com.makkras.entity.impl.Sphere;
import com.makkras.service.MathHandler;
import com.makkras.service.impl.SphereMathHandler;
import com.makkras.specification.Specification;

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
