package com.makkras.task.service.spherecomparator.impl;

import com.makkras.task.entity.impl.Sphere;
import com.makkras.task.service.spherecomparator.CustomComparator;

public class SphereComparatorById implements CustomComparator {
    public int compare(Sphere o1, Sphere o2){
        if(o1.getId()>o2.getId()){
            return  1;
        }else if(o1.getId() < o2.getId()){
            return -1;
        }else {return 0;}
    }
}
