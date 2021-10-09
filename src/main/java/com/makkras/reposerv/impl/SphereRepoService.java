package com.makkras.reposerv.impl;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.CustomShape;
import com.makkras.entity.impl.Sphere;
import com.makkras.reposerv.RepoService;

import java.util.ArrayList;
import java.util.List;

public class SphereRepoService implements RepoService {
    public void delShapeById(CustomRepo sphereRepo,int id){
        int counter =0;
        while (counter<sphereRepo.getShapeList().size()){
            if(sphereRepo.getShapeList().get(counter).getId() == id){
                sphereRepo.getShapeList().remove(counter);
            }
            counter++;
        }
    }
    public void delShapeByName(CustomRepo sphereRepo,String name){
        int counter =0;
        while (counter<sphereRepo.getShapeList().size()){
            if(sphereRepo.getShapeList().get(counter).getName().equals(name)){
                sphereRepo.getShapeList().remove(counter);
            }
            counter++;
        }
    }
    public List<Sphere> findShapeByName(CustomRepo sphereRepo, String name){
       List<Sphere> list = new ArrayList<>();
        int counter =0;
        while (counter<sphereRepo.getShapeList().size()){
            if(sphereRepo.getShapeList().get(counter).getName().equals(name)){
                list.add(sphereRepo.getShapeList().get(counter));
            }
            counter++;
        }
        return list;
    }
    public List<Sphere> findShapeById(CustomRepo sphereRepo,int id){
        List<Sphere> list = new ArrayList<>();
        int counter =0;
        while (counter<sphereRepo.getShapeList().size()){
            if(sphereRepo.getShapeList().get(counter).getId()==id){
                list.add(sphereRepo.getShapeList().get(counter));
            }
            counter++;
        }
        return list;
    }
}
