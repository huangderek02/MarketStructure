package com.example.marketstructure.StateDesignPattern;

import com.example.marketstructure.Listing;

public class WaitingToEnterDeliveryDetails extends State {

    public WaitingToEnterDeliveryDetails(Listing listing) {
        super(listing);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.DeliveryDetailsEntered)) {
            getListing().setState(new WaitingToSelectPaymentMethod(listing));
        }
        if (event.equals(Event.Cancelled)) {
            getListing().setState(new Idle(listing));
        }
        if (event.equals(Event.Timeout)) {
            getListing().setState(new Idle(listing));
        }
    }
}
