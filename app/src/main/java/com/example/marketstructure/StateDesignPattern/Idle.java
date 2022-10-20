package com.example.marketstructure.StateDesignPattern;

public class Idle extends State {

    public Idle(OrderStatus order) {
        super(order);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.SearchForListing)) {
            getOrderStatus().setState(new WaitingToSelectListingToView(status));
        }
    }
}