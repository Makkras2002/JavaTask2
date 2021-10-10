package com.makkras.service.spherecomparator.impl;

import com.makkras.entity.impl.Sphere;
import com.makkras.service.spherecomparator.CustomComparator;

public class SphereComparatorByName implements CustomComparator {
    public int compare(Sphere o1, Sphere o2){
        return o1.getName().compareTo(o2.getName());
    }
}
