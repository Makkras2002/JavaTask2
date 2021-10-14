package com.makkras.service;

import com.makkras.entity.impl.Sphere;

public interface ChangeHandler {
    void changeRadius(Sphere sphere, Double radius);
    void changeXYZ(Sphere sphere, Double x,Double y,Double z);
}
