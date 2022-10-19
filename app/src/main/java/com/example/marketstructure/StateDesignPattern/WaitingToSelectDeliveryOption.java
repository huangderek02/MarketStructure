package com.example.marketstructure.StateDesignPattern;

import com.example.marketstructure.Listing;

public class WaitingToSelectDeliveryOption extends State {

    public WaitingToSelectDeliveryOption(Listing listing) {
        super(listing);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.DeliveryOptionSelected)) {
            getListing().setState(new WaitingToEnterDeliveryDetails(listing));
        }
        if (event.equals(Event.Cancelled)) {
            getListing().setState(new Idle(listing));
        }
        if (event.equals(Event.Timeout)) {
            getListing().setState(new Idle(listing));
        }
    }
}
