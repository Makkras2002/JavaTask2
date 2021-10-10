package com.makkras.service;

import com.makkras.entity.CustomShape;

public interface MathHandler {
    double countAreaSize(CustomShape shape);
    double countCapacitySize(CustomShape shape);
    double countCapacityCorrelationCreatedByCordSpaceXYCutSphere(CustomShape shape);
    boolean doesSphereTouchAnyCordArea(CustomShape shape);
}
