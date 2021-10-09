package com.makkras.entity;

import com.makkras.entity.impl.GeometricalPoint;

public interface CustomShape {
    GeometricalPoint getCenter();
    void setCenter(double x,double y,double z);
    int getId();
    void setId(int id);
    String getName();
    void setName(String name);
    double getRadius();
    void setRadius(double radius);
}
