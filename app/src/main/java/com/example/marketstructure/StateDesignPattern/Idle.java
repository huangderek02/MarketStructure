package com.example.marketstructure.StateDesignPattern;

import com.example.marketstructure.Listing;

public class Idle extends State {

    public Idle(Listing listing) {
        super(listing);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.AnyButton)) {
            getListing().setState(new WaitingToSelect(listing));
        }
    }
}
