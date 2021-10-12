package com.makkras.entity.impl;

import com.makkras.entity.CustomRepo;
import com.makkras.service.MathHandler;
import com.makkras.service.impl.SphereMathHandler;
import com.makkras.service.spherecomparator.CustomComparator;
import com.makkras.service.spherecomparator.impl.SphereComparatorById;
import com.makkras.service.spherecomparator.impl.SphereComparatorByName;
import com.makkras.service.spherecomparator.impl.SphereComparatorByRadius;
import com.makkras.service.spherecomparator.impl.SphereComparatorByXCordOfCenter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SphereRepo implements CustomRepo{
    private static Logger logger = LogManager.getLogger();
    private List<Sphere> sphereRepo;
    public SphereRepo(){
        sphereRepo = new ArrayList<>();
    }
    public void addShape(Sphere sphere){
        sphereRepo.add(sphere);
    }
    public void showRepo(){
        for(Sphere sphere :sphereRepo){
            logger.info(sphere.toString());
        }
    }
    public List<Sphere> getShapeList(){
        return sphereRepo;
    }
    public void delShapeById(int id){
        int counter =0;
        while (counter<sphereRepo.size()){
            if(sphereRepo.get(counter).getId() == id){
                sphereRepo.remove(counter);
            }
            counter++;
        }
    }
    public void delShapeByName(String name){
        int counter =0;
        while (counter<sphereRepo.size()){
            if(sphereRepo.get(counter).getName().equals(name)){
                sphereRepo.remove(counter);
            }
            counter++;
        }
    }
    public List<Sphere> findShapeByName(String name){
        List<Sphere> list = new ArrayList<>();
        int counter =0;
        while (counter<sphereRepo.size()){
            if(sphereRepo.get(counter).getName().equals(name)){
                list.add(sphereRepo.get(counter));
            }
            counter++;
        }
        return list;
    }
    public List<Sphere> findShapeById(int id){
        List<Sphere> list = new ArrayList<>();
        int counter =0;
        while (counter<sphereRepo.size()){
            if(sphereRepo.get(counter).getId()==id){
                list.add(sphereRepo.get(counter));
            }
            counter++;
        }
        return list;
    }
    public List<Sphere> findShapesWhichAreaSizeIsInRange(double min,double max){
        List<Sphere> list = new ArrayList<>();
        MathHandler mathHandler = new SphereMathHandler();
        int counter =0;
        while (counter<sphereRepo.size()){
            if(mathHandler.countAreaSize(sphereRepo.get(counter)) >min &&
                    mathHandler.countAreaSize(sphereRepo.get(counter))<max){
                list.add(sphereRepo.get(counter));
            }
            counter++;
        }
        return list;
    }
    public List<Sphere> findShapesWhichCapacitySizeIsInRange(double min, double max){
        List<Sphere> list = new ArrayList<>();
        MathHandler mathHandler = new SphereMathHandler();
        int counter =0;
        while (counter<sphereRepo.size()){
            if(mathHandler.countCapacitySize(sphereRepo.get(counter)) >min &&
                    mathHandler.countCapacitySize(sphereRepo.get(counter))<max){
                list.add(sphereRepo.get(counter));
            }
            counter++;
        }
        return list;
    }
    public List<Sphere> findShapesWhichCenterIsInRangeFromOrigin(double rangeMin, double rangeMax){
        List<Sphere> list = new ArrayList<>();
        int counter =0;
        while (counter<sphereRepo.size()){
            if(Math.sqrt(Math.pow(sphereRepo.get(counter).getCenter().getXAxis(),2)+
                    Math.pow(sphereRepo.get(counter).getCenter().getYAxis(),2)+
                    Math.pow(sphereRepo.get(counter).getCenter().getZAxis(),2)) <rangeMax  &&
                    Math.sqrt(Math.pow(sphereRepo.get(counter).getCenter().getXAxis(),2)+
                            Math.pow(sphereRepo.get(counter).getCenter().getYAxis(),2)+
                            Math.pow(sphereRepo.get(counter).getCenter().getZAxis(),2)) >rangeMin){
                list.add(sphereRepo.get(counter));
            }
            counter++;
        }
        return list;
    }
    public void sortRepoByName(){
        CustomComparator comparator = new SphereComparatorByName();
        sphereRepo.sort(comparator);
    }
    public void sortRepoById(){
        CustomComparator comparator = new SphereComparatorById();
        sphereRepo.sort(comparator);
    }
    public void sortRepoByRadius(){
        CustomComparator comparator = new SphereComparatorByRadius();
        sphereRepo.sort(comparator);
    }
    public void sortRepoByXCordOfCenter(){
        CustomComparator comparator = new SphereComparatorByXCordOfCenter();
        sphereRepo.sort(comparator);
    }
}
