package com.makkras.entity.factory;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.impl.Sphere;

import java.util.List;

public interface CustomRepoFactory {
    CustomRepo createRepo();
    CustomRepo createRepo(List<Sphere> list);
}
