package com.makkras.task.service;

import com.makkras.task.entity.CustomShape;

public interface MathHandler {
    double countAreaSize(CustomShape shape);
    double countCapacitySize(CustomShape shape);
    double countCapacityCorrelationCreatedByCordSpaceXYCutSphere(CustomShape shape);
    boolean doesSphereTouchAnyCordArea(CustomShape shape);
}
