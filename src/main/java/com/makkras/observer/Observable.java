package com.makkras.observer;

public interface Observable {
    void attach(Observer observer);
    void detach();
    void notifyObservers();
}
