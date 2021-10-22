package com.makkras.task.specification.impl;

import com.makkras.task.entity.impl.Sphere;
import com.makkras.task.specification.Specification;

public class CenterIsInRangeFromOriginSpecification implements Specification {
    private double rangeMin;
    private double rangeMax;
    public CenterIsInRangeFromOriginSpecification(double rangeMin, double rangeMax){
        this.rangeMax=rangeMax;
        this.rangeMin=rangeMin;
    }
    public boolean specify(Sphere sphere) {
        return Math.sqrt(Math.pow(sphere.getCenter().getXAxis(),2)+
                Math.pow(sphere.getCenter().getYAxis(),2)+
                Math.pow(sphere.getCenter().getZAxis(),2)) <rangeMax  &&
                Math.sqrt(Math.pow(sphere.getCenter().getXAxis(),2)+
                        Math.pow(sphere.getCenter().getYAxis(),2)+
                        Math.pow(sphere.getCenter().getZAxis(),2)) >rangeMin;
    }
}
