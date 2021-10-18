package com.makkras.entity.factory.impl;

import com.makkras.entity.factory.GeometricalPointFactory;
import com.makkras.entity.impl.GeometricalPoint;

public class PointFactory implements GeometricalPointFactory {

    public GeometricalPoint createPoint() {
        return new GeometricalPoint();
    }
}
