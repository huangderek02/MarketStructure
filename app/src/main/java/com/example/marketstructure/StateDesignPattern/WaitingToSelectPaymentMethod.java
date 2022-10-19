package com.example.marketstructure.StateDesignPattern;

public class WaitingToSelectPaymentMethod extends State {

    public WaitingToSelectPaymentMethod(OrderStatus status) {
        super(status);
    }

    @Override
    public void handle(Event event) {
        System.out.println("Order status is in WaitingToSelectListing state");
        status.setState(this);
    }
    public String toString(){
        return "WaitingToSelectListing State";
    }
}
