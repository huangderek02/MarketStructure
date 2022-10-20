//@author Rhonda Luu (u7127350)
package com.example.marketstructure.StateDesignPattern;

public class Delivered extends State {

    public Delivered(OrderStatus order) {
        super(order);
    }

    @Override
    public void handle(Event event) {
    }
}
