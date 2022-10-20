package com.example.marketstructure.ObserverDesignPattern;

import java.util.Objects;

public class BuyerLog {
    final private Observer observer; // observer that visited the location
    final private Integer tickVisited; // tick at which the observer visited the app

    /**
     * Constructor which sets tuple values
     */
    public BuyerLog(Observer observer, int tickVisited) {
        this.observer = observer;
        this.tickVisited = tickVisited;
    }

    /**
     * @return observer object
     */
    public Observer getObserver() {
        return observer;
    }

    /**
     * @return current tick value
     */
    public int getTickVisited() {
        return tickVisited;
    }


    /**
     * Prints out the user details
     * @return string containing the information of the user
     */
    @Override
    public String toString() {
        return "BuyerLog{" +
                "observer=" + observer +
                ", tick=" + tickVisited +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerLog that = (BuyerLog) o;
        return observer.equals(that.observer) && tickVisited.equals(that.tickVisited);
    }

    @Override
    public int hashCode() {
        return Objects.hash(observer, tickVisited);
    }
}
