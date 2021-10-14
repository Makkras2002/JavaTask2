package com.makkras.specification.impl;

import com.makkras.entity.impl.Sphere;
import com.makkras.specification.Specification;

public class NameSpecification implements Specification {
    private String subString;
    public NameSpecification(String subString){
        this.subString = subString;
    }
    public boolean specify(Sphere sphere) {
        return sphere.getName().equals(subString);
    }
}
