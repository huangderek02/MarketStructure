package com.example.marketstructure.StateDesignPattern;

import com.example.marketstructure.Listing;

public class WaitingToDispense extends State {
    WaitingToDispense(Listing listing) {
        super(listing);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.ItemDispensed)) {
            getListing().setState(new ReadyToCollect(listing));
        }
    }
}
