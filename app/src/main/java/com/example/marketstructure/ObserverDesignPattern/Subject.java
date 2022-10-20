package com.example.marketstructure.ObserverDesignPattern;

import java.lang.reflect.Type;

public interface Subject<T> {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifyObservers(T classifier);
}
