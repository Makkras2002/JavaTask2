package com.makkras.entity.factory.impl;

import com.makkras.entity.CustomShape;
import com.makkras.entity.factory.CustomShapeFactory;
import com.makkras.entity.impl.Sphere;

public class ShapeFactory implements CustomShapeFactory {
    public CustomShape createShape() {
        return new Sphere();
    }
}
