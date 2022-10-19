package com.example.marketstructure.StateDesignPattern;

public class WaitingToDispatch extends State {

    public WaitingToDispatch(OrderStatus status) {
        super(status);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.TextbookDispatchedNotPaid)) {
            getOrderStatus().setState(new WaitingToPay(status));
        }
        if (event.equals(Event.TextbookDispatched)) {
            getOrderStatus().setState(new Delivered(status));
        }
        if (event.equals(Event.Cancelled)) {
            getOrderStatus().setState(new Idle(status));
        }
        if (event.equals(Event.Timeout)) {
            getOrderStatus().setState(new Idle(status));
        }
    }
}
