package com.makkras.reposerv.impl;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.impl.Sphere;
import com.makkras.reposerv.RepoService;
import com.makkras.service.MathHandler;
import com.makkras.service.impl.SphereMathHandler;
import com.makkras.service.spherecomparator.CustomComparator;
import com.makkras.service.spherecomparator.impl.SphereComparatorById;
import com.makkras.service.spherecomparator.impl.SphereComparatorByName;
import com.makkras.service.spherecomparator.impl.SphereComparatorByRadius;
import com.makkras.service.spherecomparator.impl.SphereComparatorByXCordOfCenter;

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
    public List<Sphere> findShapesWhichAreaSizeIsInRange(CustomRepo sphereRepo,double min,double max){
        List<Sphere> list = new ArrayList<>();
        MathHandler mathHandler = new SphereMathHandler();
        int counter =0;
        while (counter<sphereRepo.getShapeList().size()){
            if(mathHandler.countAreaSize(sphereRepo.getShapeList().get(counter)) >min &&
                    mathHandler.countAreaSize(sphereRepo.getShapeList().get(counter))<max){
                list.add(sphereRepo.getShapeList().get(counter));
            }
            counter++;
        }
        return list;
    }
    public List<Sphere> findShapesWhichCapacitySizeIsInRange(CustomRepo sphereRepo, double min, double max){
        List<Sphere> list = new ArrayList<>();
        MathHandler mathHandler = new SphereMathHandler();
        int counter =0;
        while (counter<sphereRepo.getShapeList().size()){
            if(mathHandler.countCapacitySize(sphereRepo.getShapeList().get(counter)) >min &&
                    mathHandler.countCapacitySize(sphereRepo.getShapeList().get(counter))<max){
                list.add(sphereRepo.getShapeList().get(counter));
            }
            counter++;
        }
        return list;
    }
    public List<Sphere> findShapesWhichCenterIsInRangeFromOrigin(CustomRepo sphereRepo,double rangeMin, double rangeMax){
        List<Sphere> list = new ArrayList<>();
        int counter =0;
        while (counter<sphereRepo.getShapeList().size()){
            if(Math.sqrt(Math.pow(sphereRepo.getShapeList().get(counter).getCenter().getXAxis(),2)+
                    Math.pow(sphereRepo.getShapeList().get(counter).getCenter().getYAxis(),2)+
                    Math.pow(sphereRepo.getShapeList().get(counter).getCenter().getZAxis(),2)) <rangeMax  &&
                    Math.sqrt(Math.pow(sphereRepo.getShapeList().get(counter).getCenter().getXAxis(),2)+
                            Math.pow(sphereRepo.getShapeList().get(counter).getCenter().getYAxis(),2)+
                            Math.pow(sphereRepo.getShapeList().get(counter).getCenter().getZAxis(),2)) >rangeMin){
                list.add(sphereRepo.getShapeList().get(counter));
            }
            counter++;
        }
        return list;
    }
    public void sortRepoByName(CustomRepo repo){
        CustomComparator comparator = new SphereComparatorByName();
        repo.getShapeList().sort(comparator);
    }
    public void sortRepoById(CustomRepo repo){
        CustomComparator comparator = new SphereComparatorById();
        repo.getShapeList().sort(comparator);
    }
    public void sortRepoByRadius(CustomRepo repo){
        CustomComparator comparator = new SphereComparatorByRadius();
        repo.getShapeList().sort(comparator);
    }
    public void sortRepoByXCordOfCenter(CustomRepo repo){
        CustomComparator comparator = new SphereComparatorByXCordOfCenter();
        repo.getShapeList().sort(comparator);
    }
}
