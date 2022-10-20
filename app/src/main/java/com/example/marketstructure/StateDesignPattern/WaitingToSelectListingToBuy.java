package com.example.marketstructure.StateDesignPattern;

public class WaitingToSelectListingToBuy extends State {

    public WaitingToSelectListingToBuy(OrderStatus status) {
        super(status);
    }

    @Override
     public void handle(Event event) {
        if (event.equals(Event.ListingSelectedToBuy)) {
            getOrderStatus().setState(new WaitingToSelectDeliveryOption(status));
        }
        if (event.equals(Event.Cancelled)) {
            getOrderStatus().setState(new Idle(status));
        }
    }
}
