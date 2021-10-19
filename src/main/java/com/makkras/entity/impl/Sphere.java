package com.makkras.entity.impl;

import com.makkras.entity.factory.GeometricalPointFactory;
import com.makkras.entity.CustomShape;
import com.makkras.entity.factory.impl.PointFactory;
import com.makkras.observer.Observable;
import com.makkras.observer.Observer;
import com.makkras.observer.SphereEvent;

public class Sphere implements CustomShape, Observable {
    private int id;
    private String name;
    private GeometricalPoint center;
    private double radius;
    private Observer observer;
    public Sphere(){
        GeometricalPointFactory factory = new PointFactory();
        center =(GeometricalPoint) factory.createPoint();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeometricalPoint getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenter(double x,double y,double z) {
        center.setXAxis(x);
        center.setYAxis(y);
        center.setZAxis(z);
        notifyObservers();
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sphere sphere = (Sphere) o;

        if (id != sphere.id) return false;
        if (Double.compare(sphere.radius, radius) != 0) return false;
        if (name != null ? !name.equals(sphere.name) : sphere.name != null) return false;
        if (center != null ? !center.equals(sphere.center) : sphere.center != null) return false;
        return observer != null ? observer.equals(sphere.observer) : sphere.observer == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (center != null ? center.hashCode() : 0);
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (observer != null ? observer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sphere{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", center=").append(center.toString());
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void attach(Observer observer) {
        if(observer != null){
            this.observer = observer;
        }
    }

    @Override
    public void detach() {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if(observer!= null){
            SphereEvent event = new SphereEvent(this);
            observer.paramsChanged(event);
        }
    }
}
