package com.makkras.task.entity.factory.impl;

import com.makkras.task.entity.CustomShape;
import com.makkras.task.entity.factory.CustomShapeFactory;
import com.makkras.task.entity.impl.Sphere;

public class ShapeFactory implements CustomShapeFactory {
    public CustomShape createShape() {
        return new Sphere();
    }
}
