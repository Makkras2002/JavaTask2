package com.makkras.task.service.spherecomparator.impl;

import com.makkras.task.entity.impl.Sphere;
import com.makkras.task.service.spherecomparator.CustomComparator;

public class SphereComparatorByXCordOfCenter implements CustomComparator {
    public int compare(Sphere o1, Sphere o2){
        if(o1.getCenter().getXAxis()>o2.getCenter().getXAxis()){
            return  1;
        }else if(o1.getCenter().getXAxis()<o2.getCenter().getXAxis()){
            return -1;
        }else {return 0;}
    }
}
