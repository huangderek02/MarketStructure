package com.example.marketstructure.StateDesignPattern;

import android.util.Log;

public class WaitingToSelectListingToView extends State {

    public WaitingToSelectListingToView(OrderStatus status) {
        super(status);
    }

    @Override
     public void handle(Event event) {
        if (event.equals(Event.ListingSelectedToView)) {
            getOrderStatus().setState(new WaitingToSelectListingToBuy(status));
        }
        if (event.equals(Event.Cancelled)) {
            getOrderStatus().setState(new Idle(status));
        }
    }
}
