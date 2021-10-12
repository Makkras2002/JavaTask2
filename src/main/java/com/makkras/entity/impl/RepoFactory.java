package com.makkras.entity.impl;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.CustomRepoFactory;

public class RepoFactory implements CustomRepoFactory {
    public CustomRepo createRepo() {
        return new SphereRepo();
    }
}
