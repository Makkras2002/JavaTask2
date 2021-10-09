package com.makkras.entity;

import com.makkras.entity.impl.Sphere;

import java.util.List;


public interface CustomRepo {
    void addShape(Sphere sphere);
    void showRepo();
    List<Sphere> getShapeList();
}
