package com.makkras.entity.impl;

import com.makkras.entity.CustomRepo;
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
}
