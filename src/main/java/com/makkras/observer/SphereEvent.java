package com.makkras.observer;

import com.makkras.entity.impl.Sphere;

import java.util.EventObject;

public class SphereEvent extends EventObject {
    public SphereEvent(Sphere source) {
        super(source);
    }
    @Override
    public Object getSource() {
        return super.getSource();
    }
}
