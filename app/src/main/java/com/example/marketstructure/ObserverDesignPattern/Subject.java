// @author Derek Huang (u7300484)
package com.example.marketstructure.ObserverDesignPattern;

public interface Subject<T> {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifyObservers(T classifier);
}
