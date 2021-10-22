package com.makkras.task.service.impl;

import com.makkras.task.entity.impl.Sphere;
import com.makkras.task.service.ChangeHandler;

public class SphereChangeHandler implements ChangeHandler {
    public void changeRadius(Sphere sphere, Double radius){
        sphere.setRadius(radius);
    }
    public void changeXYZ(Sphere sphere, Double x,Double y,Double z){
        sphere.setCenter(x,y,z);
    }
}
