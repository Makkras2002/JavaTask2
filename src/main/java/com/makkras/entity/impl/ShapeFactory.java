package com.makkras.entity.impl;

import com.makkras.entity.CustomShape;
import com.makkras.entity.CustomShapeFactory;

public class ShapeFactory implements CustomShapeFactory {
    public CustomShape createShape(String type) {
        if(type.equals("SPHERE")){
            return new Sphere();
        }else {
            return null;
        }
    }
}
