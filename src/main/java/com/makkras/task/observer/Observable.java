package com.makkras.task.observer;

public interface Observable {
    void attach(Observer observer);
    void detach();
    void notifyObservers();
}
