package com.example.marketstructure.StateDesignPattern;

public abstract class State {

    protected final OrderStatus status;

    public State(OrderStatus status) {
        this.status = status;
    }

    public abstract void handle(Event event);

    public OrderStatus getOrderStatus() {
        return status;
    }
}