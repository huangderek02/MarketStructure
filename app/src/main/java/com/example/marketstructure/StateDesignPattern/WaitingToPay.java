package com.example.marketstructure.StateDesignPattern;

public class WaitingToPay extends State {
    WaitingToPay(OrderStatus status) {
        super(status);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.TextbookPaidByCard)) {
            getOrderStatus().setState(new WaitingToDispatch(status));
        }
        if (event.equals(Event.TextbookPaidByCash)) {
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
