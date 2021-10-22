package com.makkras.task.entity.impl;

public class GeometricalPoint{
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

        if (Double.compare(that.xAxis, xAxis) != 0) return false;
        if (Double.compare(that.yAxis, yAxis) != 0) return false;
        return Double.compare(that.zAxis, zAxis) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(xAxis);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(yAxis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(zAxis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
