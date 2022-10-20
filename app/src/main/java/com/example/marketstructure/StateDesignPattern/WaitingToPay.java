// @author Rhonda Luu (u7127350)
package com.example.marketstructure.StateDesignPattern;

public class WaitingToPay extends State {
    WaitingToPay(OrderStatus status) {
        super(status);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.CardPaymentDetailsEntered)) {
            getOrderStatus().setState(new WaitingToConfirm(status));
        }
        if (event.equals(Event.TextbookPaidByCash)) {
            getOrderStatus().setState(new Delivered(status));
        }
        if (event.equals(Event.Cancelled)) {
            getOrderStatus().setState(new Idle(status));
        }
    }
}
