package com.makkras.task.entity.factory.impl;

import com.makkras.task.entity.CustomRepo;
import com.makkras.task.entity.factory.CustomRepoFactory;
import com.makkras.task.entity.impl.Sphere;
import com.makkras.task.entity.impl.SphereRepo;

import java.util.List;

public class RepoFactory implements CustomRepoFactory {
    public CustomRepo createRepo() {
        return new SphereRepo();
    }
    public CustomRepo createRepo(List<Sphere> list){
        SphereRepo repo = new SphereRepo();
        repo.getList().addAll(list);
        return repo;
    }
}
