package com.makkras.task.entity;

import com.makkras.task.entity.impl.Sphere;
import com.makkras.task.specification.Specification;

import java.util.List;


public interface CustomRepo {
    void addSphere(Sphere sphere);
    void removeSphere(Sphere sphere);
    List<Sphere> query(Specification specification);
    void sortRepoByName();
    void sortRepoById();
    void sortRepoByRadius();
    void sortRepoByXCordOfCenter();
    List<Sphere> getList();
}
