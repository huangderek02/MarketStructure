package com.example.marketstructure.StateDesignPattern;

import com.example.marketstructure.Listing;

public class ReadyToCollect extends State {
    ReadyToCollect(Listing listing) {
        super(listing);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.Timeout)) {
            getListing().setState(new Idle(listing));
        }
    }
}
