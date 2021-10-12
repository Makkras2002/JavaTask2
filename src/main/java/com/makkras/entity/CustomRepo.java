package com.makkras.entity;

import com.makkras.entity.impl.Sphere;

import java.util.List;


public interface CustomRepo {
    void addShape(Sphere sphere);
    void showRepo();
    void delShapeById(int id);
    void delShapeByName(String name);
    List<Sphere> findShapeByName(String name);
    List<Sphere> findShapeById(int id);
    List<Sphere> findShapesWhichAreaSizeIsInRange(double min,double max);
    List<Sphere> findShapesWhichCapacitySizeIsInRange(double min, double max);
    List<Sphere> findShapesWhichCenterIsInRangeFromOrigin(double rangeMin, double rangeMax);
    void sortRepoByName();
    void sortRepoById();
    void sortRepoByRadius();
    void sortRepoByXCordOfCenter();
    List<Sphere> getShapeList();
}
