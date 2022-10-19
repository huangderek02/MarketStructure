package com.example.marketstructure.StateDesignPattern;

import com.example.marketstructure.Listing;

public class WaitingToDispatch extends State {

    public WaitingToDispatch(Listing listing) {
        super(listing);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.TextbookDispatchedNotPaid)) {
            getListing().setState(new WaitingToPay(listing));
        }
        if (event.equals(Event.TextbookDispatched)) {
            getListing().setState(new Delivered(listing));
        }
        if (event.equals(Event.Cancelled)) {
            getListing().setState(new Idle(listing));
        }
        if (event.equals(Event.Timeout)) {
            getListing().setState(new Idle(listing));
        }
    }
}
