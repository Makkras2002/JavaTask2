package com.makkras.entity.impl;

import com.makkras.entity.GeometricalPointFactory;

public class PointFactory implements GeometricalPointFactory {

    public GeometricalPoint createPoint() {
        return new GeometricalPoint();
    }
}
