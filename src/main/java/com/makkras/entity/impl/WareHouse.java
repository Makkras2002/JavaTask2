package com.makkras.entity.impl;

import com.makkras.entity.CustomRepo;
import com.makkras.entity.CustomWareHouse;
import com.makkras.service.impl.SphereMathHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WareHouse implements CustomWareHouse {
    private static Map<Integer, List<Double>> houseMap;
    private static WareHouse INSTANCE;
    private WareHouse(){ houseMap= new HashMap<>();}
    public static WareHouse getInstance() {
        if(INSTANCE ==null){
            INSTANCE = new WareHouse();
        }
        return INSTANCE;
    }
    public String showWareHouse(){
        return houseMap.toString();
    }
    public void fillMap(CustomRepo repo){
        SphereMathHandler mathHandler = new SphereMathHandler();
        for(Sphere sphere : repo.getList()){
            houseMap.put(sphere.getId(), Stream.of(mathHandler.countAreaSize(sphere),mathHandler.countCapacitySize(sphere),
                    mathHandler.countCapacityCorrelationCreatedByCordSpaceXYCutSphere(sphere)).collect(Collectors.toList()));
        }
    }
    public void changeData(int id,double areaSize,double capacitySize,double correlation){

        houseMap.get(id).set(0,areaSize);
        houseMap.get(id).set(1,capacitySize);
        houseMap.get(id).set(2,correlation);
    }
    public void removeData(int id){
        houseMap.remove(id);
    }

}
