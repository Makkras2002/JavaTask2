package com.makkras.task.entity.factory;

import com.makkras.task.entity.CustomRepo;
import com.makkras.task.entity.impl.Sphere;

import java.util.List;

public interface CustomRepoFactory {
    CustomRepo createRepo();
    CustomRepo createRepo(List<Sphere> list);
}
