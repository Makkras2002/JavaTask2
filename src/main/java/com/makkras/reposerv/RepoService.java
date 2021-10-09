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
}
