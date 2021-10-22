package com.makkras.task.service;

import com.makkras.task.entity.impl.Sphere;

public interface ChangeHandler {
    void changeRadius(Sphere sphere, Double radius);
    void changeXYZ(Sphere sphere, Double x,Double y,Double z);
}
