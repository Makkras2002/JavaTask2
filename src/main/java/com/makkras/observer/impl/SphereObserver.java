package com.makkras.observer.impl;

import com.makkras.entity.impl.Sphere;
import com.makkras.entity.impl.WareHouse;
import com.makkras.observer.Observer;
import com.makkras.observer.SphereEvent;
import com.makkras.service.impl.SphereMathHandler;

public class SphereObserver implements Observer {
    public void paramsChanged(SphereEvent event){
        SphereMathHandler mathHandler = new SphereMathHandler();
        Sphere sphere = (Sphere) event.getSource();
        WareHouse.getInstance().changeData(sphere.getId(), mathHandler.countAreaSize(sphere),mathHandler.countCapacitySize(sphere),
                mathHandler.countCapacityCorrelationCreatedByCordSpaceXYCutSphere(sphere));
    }
}
