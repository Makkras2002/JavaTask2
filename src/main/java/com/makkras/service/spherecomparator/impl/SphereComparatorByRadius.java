package com.makkras.service.spherecomparator.impl;

import com.makkras.entity.impl.Sphere;
import com.makkras.service.spherecomparator.CustomComparator;

public class SphereComparatorByRadius implements CustomComparator {
    public int compare(Sphere o1, Sphere o2){
        if(o1.getRadius()>o2.getRadius()){
            return  1;
        }else if(o1.getRadius()<o2.getRadius()){
            return -1;
        }else {return 0;}
    }
}
