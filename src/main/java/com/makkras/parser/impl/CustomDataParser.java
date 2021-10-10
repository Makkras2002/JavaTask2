package com.makkras.parser.impl;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.CustomRepoFactory;
import com.makkras.entity.CustomShape;
import com.makkras.entity.impl.RepoFactory;
import com.makkras.entity.impl.ShapeFactory;
import com.makkras.entity.impl.Sphere;
import com.makkras.entity.impl.SphereRepo;
import com.makkras.parser.DataParser;
import com.makkras.validator.SphereValidator;
import com.makkras.validator.impl.SphereCorrectnessValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class CustomDataParser implements DataParser {
    private static Logger logger = LogManager.getLogger();
    public SphereRepo extractToRepo(List<String> list){
        CustomRepoFactory repoFactory = new RepoFactory();
        ShapeFactory shapeFactory = new ShapeFactory();
        SphereValidator sphereValidator = new SphereCorrectnessValidator();
        CustomRepo repo = repoFactory.createRepo("SPHEREREPO");
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
                sphere =shapeFactory.createShape("SPHERE");
                sphere.setCenter(Double.parseDouble(rawDataArray[2]),Double.parseDouble(rawDataArray[3]),
                        Double.parseDouble(rawDataArray[4]));
                sphere.setName(rawDataArray[1]);
                sphere.setId((int) Double.parseDouble(rawDataArray[0]));
                sphere.setRadius(Double.parseDouble(rawDataArray[5]));
                repo.addShape((Sphere) sphere);
            }
            tempCounter1++;
        }
        return (SphereRepo) repo;
    }
}