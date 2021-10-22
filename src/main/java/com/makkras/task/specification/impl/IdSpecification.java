package com.makkras.task.specification.impl;

import com.makkras.task.entity.impl.Sphere;
import com.makkras.task.specification.Specification;

public class IdSpecification implements Specification {
    private int testId;
    public IdSpecification(int testId){
        this.testId = testId;
    }
    public boolean specify(Sphere sphere) {
        return sphere.getId()==testId;
    }
}
