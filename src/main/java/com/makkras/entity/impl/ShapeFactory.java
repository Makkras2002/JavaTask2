package com.makkras.entity.impl;

import com.makkras.entity.CustomShape;
import com.makkras.entity.CustomShapeFactory;

public class ShapeFactory implements CustomShapeFactory {
    public CustomShape createShape() {
        return new Sphere();
    }
}
