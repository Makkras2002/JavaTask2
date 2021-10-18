package com.makkras.entity.impl;

import com.makkras.entity.factory.GeometricalPointFactory;
import com.makkras.entity.CustomShape;
import com.makkras.entity.factory.impl.PointFactory;
import com.makkras.observer.Observable;
import com.makkras.observer.Observer;
import com.makkras.observer.SphereEvent;

import java.util.Objects;

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
        return Double.compare(sphere.radius, radius) == 0 && Objects.equals(center, sphere.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
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
