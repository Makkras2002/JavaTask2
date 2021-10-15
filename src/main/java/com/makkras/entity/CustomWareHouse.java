package com.makkras.entity;

public interface CustomWareHouse {
    String showWareHouse();
    void fillMap(CustomRepo repo);
    void changeData(int id,double areaSize,double capacitySize,double correlation);
    void removeData(int id);
}
