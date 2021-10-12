package com.makkras.entity.impl;

import com.makkras.entity.CustomPoint;

import java.util.Objects;

public class GeometricalPoint implements CustomPoint {
    private double xAxis;
    private double yAxis;
    private double zAxis;

    public GeometricalPoint(){}
    public double getXAxis() {
        return xAxis;
    }

    public void setXAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    public double getYAxis() {
        return yAxis;
    }

    public void setYAxis(double yAxis) {
        this.yAxis = yAxis;
    }

    public double getZAxis() {
        return zAxis;
    }

    public void setZAxis(double zAxis) {
        this.zAxis = zAxis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeometricalPoint that = (GeometricalPoint) o;
        return Double.compare(that.xAxis, xAxis) == 0 && Double.compare(that.yAxis, yAxis) == 0 && Double.compare(that.zAxis, zAxis) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xAxis, yAxis, zAxis);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeometricalPoint{");
        sb.append("xAxis=").append(xAxis);
        sb.append(", yAxis=").append(yAxis);
        sb.append(", zAxis=").append(zAxis);
        sb.append('}');
        return sb.toString();
    }
}
