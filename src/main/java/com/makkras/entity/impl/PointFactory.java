package com.makkras.entity.impl;

import com.makkras.entity.CustomPoint;
import com.makkras.entity.CustomPointFactory;

public class PointFactory implements CustomPointFactory {

    public CustomPoint createPoint() {
        return new GeometricalPoint();
    }
}
