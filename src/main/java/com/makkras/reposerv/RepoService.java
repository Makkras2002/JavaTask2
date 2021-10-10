package com.makkras.reposerv;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.CustomShape;
import com.makkras.entity.impl.Sphere;

import java.util.List;

public interface RepoService {
    void delShapeById(CustomRepo sphereRepo, int id);
    void delShapeByName(CustomRepo sphereRepo,String name);
    List<Sphere> findShapeByName(CustomRepo sphereRepo, String name);
    List<Sphere> findShapeById(CustomRepo sphereRepo,int id);
    List<Sphere> findShapesWhichAreaSizeIsInRange(CustomRepo sphereRepo,double min,double max);
    List<Sphere> findShapesWhichCapacitySizeIsInRange(CustomRepo sphereRepo, double min, double max);
    List<Sphere> findShapesWhichCenterIsInRangeFromOrigin(CustomRepo sphereRepo,double rangeMin, double rangeMax);
    void sortRepoByName(CustomRepo repo);
    void sortRepoById(CustomRepo repo);
    void sortRepoByRadius(CustomRepo repo);
    void sortRepoByXCordOfCenter(CustomRepo repo);
}
