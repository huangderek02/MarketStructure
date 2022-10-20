package com.example.marketstructure.StateDesignPattern;

public class OrderStatus {

    private State state = new Idle(this);

    public State getState() {

        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
