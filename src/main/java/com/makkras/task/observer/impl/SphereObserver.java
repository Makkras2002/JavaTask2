package com.makkras.task.observer.impl;

import com.makkras.task.entity.impl.Sphere;
import com.makkras.task.entity.impl.WareHouse;
import com.makkras.task.observer.Observer;
import com.makkras.task.observer.SphereEvent;
import com.makkras.task.service.impl.SphereMathHandler;

public class SphereObserver implements Observer {
    public void paramsChanged(SphereEvent event){
        SphereMathHandler mathHandler = new SphereMathHandler();
        Sphere sphere = (Sphere) event.getSource();
        WareHouse.getInstance().changeData(sphere.getId(), mathHandler.countAreaSize(sphere),mathHandler.countCapacitySize(sphere),
                mathHandler.countCapacityCorrelationCreatedByCordSpaceXYCutSphere(sphere));
    }
}
