package com.example.marketstructure.StateDesignPattern;

import com.example.marketstructure.Listing;

public class WaitingToSelectListing extends State {

    public WaitingToSelectListing(Listing listing) {
        super(listing);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.ListingSelected)) {
            getListing().setState(new WaitingToSelectDeliveryOption(listing));
        }
        if (event.equals(Event.Cancelled)) {
            getListing().setState(new Idle(listing));
        }
        if (event.equals(Event.Timeout)) {
            getListing().setState(new Idle(listing));
        }
    }
}
