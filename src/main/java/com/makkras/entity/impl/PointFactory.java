package com.makkras.entity.impl;

import com.makkras.entity.CustomPoint;
import com.makkras.entity.CustomPointFactory;

public class PointFactory implements CustomPointFactory {

    public CustomPoint createPoint(String type) {
        if(type.equals("GEOMETRICALPOINT")){
            return new GeometricalPoint();
        }else {
            return null;
        }
    }
}
