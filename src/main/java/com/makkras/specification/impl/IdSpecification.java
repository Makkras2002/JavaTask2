package com.makkras.specification.impl;

import com.makkras.entity.impl.Sphere;
import com.makkras.specification.Specification;

public class IdSpecification implements Specification {
    private int testId;
    public IdSpecification(int testId){
        this.testId = testId;
    }
    public boolean specify(Sphere sphere) {
        return sphere.getId()==testId;
    }
}
