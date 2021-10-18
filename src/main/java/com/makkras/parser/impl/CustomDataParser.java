package com.makkras.parser.impl;

import com.makkras.entity.CustomShape;
import com.makkras.entity.factory.impl.ShapeFactory;
import com.makkras.entity.impl.Sphere;
import com.makkras.parser.DataParser;
import com.makkras.validator.SphereValidator;
import com.makkras.validator.impl.SphereCorrectnessValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomDataParser implements DataParser {
    private static Logger logger = LogManager.getLogger();
    private CustomDataParser(){}
    private static CustomDataParser instance;
    public static CustomDataParser getInstance(){
        if(instance == null){
            instance = new CustomDataParser();
        }
        return instance;
    }
    public List<Sphere> extractToList(List<String> list){
        ShapeFactory shapeFactory = new ShapeFactory();
        SphereValidator sphereValidator = new SphereCorrectnessValidator();
        List<Sphere> repo = new ArrayList<>();
        CustomShape sphere;
        String[] rawDataArray;
        String line;
        int tempCounter1 =0;
        while (tempCounter1<list.size()){
            line = list.get(tempCounter1);
            rawDataArray = line.split(" ");
            if(!sphereValidator.checkIfSphere(rawDataArray)){
                logger.error("Invalid data found in file.");
            }else {
                sphere =shapeFactory.createShape();
                sphere.setCenter(Double.parseDouble(rawDataArray[2]),Double.parseDouble(rawDataArray[3]),
                        Double.parseDouble(rawDataArray[4]));
                sphere.setName(rawDataArray[1]);
                sphere.setId((int) Double.parseDouble(rawDataArray[0]));
                sphere.setRadius(Double.parseDouble(rawDataArray[5]));
                repo.add((Sphere) sphere);
            }
            tempCounter1++;
        }
        return repo;
    }
}