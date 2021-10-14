package com.makkras.specification.impl;

import com.makkras.entity.impl.Sphere;
import com.makkras.service.MathHandler;
import com.makkras.service.impl.SphereMathHandler;
import com.makkras.specification.Specification;

public class AreaSizeIsInRangeSpecification implements Specification {
    private double min;
    private double max;
    public AreaSizeIsInRangeSpecification(double min,double max){
        this.min=min;
        this.max=max;
    }
    public boolean specify(Sphere sphere) {
        MathHandler mathHandler = new SphereMathHandler();
        return mathHandler.countAreaSize(sphere) >min &&
                mathHandler.countAreaSize(sphere)<max;
    }
}
