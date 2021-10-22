package com.makkras.task.service.spherecomparator;

import com.makkras.task.entity.impl.Sphere;

import java.util.Comparator;

public interface CustomComparator extends Comparator<Sphere> {
    int compare(Sphere o1, Sphere o2);
}
