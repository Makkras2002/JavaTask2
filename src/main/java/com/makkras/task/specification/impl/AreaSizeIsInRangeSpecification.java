package com.makkras.task.specification.impl;

import com.makkras.task.entity.impl.Sphere;
import com.makkras.task.service.MathHandler;
import com.makkras.task.service.impl.SphereMathHandler;
import com.makkras.task.specification.Specification;

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
