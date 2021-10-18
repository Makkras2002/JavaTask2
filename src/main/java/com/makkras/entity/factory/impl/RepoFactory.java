package com.makkras.entity.factory.impl;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.factory.CustomRepoFactory;
import com.makkras.entity.impl.Sphere;
import com.makkras.entity.impl.SphereRepo;

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
