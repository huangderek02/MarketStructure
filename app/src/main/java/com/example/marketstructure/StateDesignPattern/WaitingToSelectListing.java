package com.example.marketstructure.StateDesignPattern;

public class WaitingToSelectListing extends State {

    public WaitingToSelectListing(OrderStatus status) {
        super(status);
    }

    public void handle(OrderStatus status) {
        System.out.println("Order status is in WaitingToSelectListing state");
        status.setState(this);
    }
    public String toString(){
        return "WaitingToSelectListing State";
    }

    @Override
    public void handle(Event event) {

        if (event.equals(Event.ListingSelected)) {
            getOrderStatus().setState(new WaitingToSelectDeliveryOption(status));
        }
        if (event.equals(Event.Cancelled)) {
            getOrderStatus().setState(new Idle(status));
        }
        if (event.equals(Event.Timeout)) {
            getOrderStatus().setState(new Idle(status));
        }
    }
}
