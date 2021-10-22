package com.makkras.task.entity.factory.impl;

import com.makkras.task.entity.factory.GeometricalPointFactory;
import com.makkras.task.entity.impl.GeometricalPoint;

public class PointFactory implements GeometricalPointFactory {

    public GeometricalPoint createPoint() {
        return new GeometricalPoint();
    }
}
