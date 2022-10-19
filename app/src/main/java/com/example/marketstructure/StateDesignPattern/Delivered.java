package com.example.marketstructure.StateDesignPattern;

import com.example.marketstructure.Listing;

public class Delivered extends State {

    public Delivered(Listing listing) {
        super(listing);
    }

    @Override
    public void handle(Event event) {
    }
}
