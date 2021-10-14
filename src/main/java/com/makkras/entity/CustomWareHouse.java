package com.makkras.entity;

import com.makkras.entity.impl.Sphere;
import com.makkras.service.impl.SphereMathHandler;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface CustomWareHouse {
    String showWareHouse();
    void fillMap(CustomRepo repo);
    void changeData(int id,double areaSize,double capacitySize,double correlation);
    void removeData(int id);
}
