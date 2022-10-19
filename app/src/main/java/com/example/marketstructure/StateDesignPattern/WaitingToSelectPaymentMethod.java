package com.example.marketstructure.StateDesignPattern;

import com.example.marketstructure.Listing;

public class WaitingToSelectPaymentMethod extends State {

    public WaitingToSelectPaymentMethod(Listing listing) {
        super(listing);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.CashPaymentMethodSelected)) {
            getListing().setState(new WaitingToDispatch(listing));
        }
        if (event.equals(Event.CardPaymentMethodSelected)) {
            getListing().setState(new WaitingToPay(listing));
        }
        if (event.equals(Event.Cancelled)) {
            getListing().setState(new Idle(listing));
        }
        if (event.equals(Event.Timeout)) {
            getListing().setState(new Idle(listing));
        }
    }
}
