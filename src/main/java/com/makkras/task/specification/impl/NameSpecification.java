package com.makkras.task.specification.impl;

import com.makkras.task.entity.impl.Sphere;
import com.makkras.task.specification.Specification;

public class NameSpecification implements Specification {
    private String subString;
    public NameSpecification(String subString){
        this.subString = subString;
    }
    public boolean specify(Sphere sphere) {
        return sphere.getName().equals(subString);
    }
}
