// @author Rhonda Luu (u7127350)
package com.example.marketstructure.StateDesignPattern;

public class WaitingToSelectPaymentMethod extends State {

    public WaitingToSelectPaymentMethod(OrderStatus status) {
        super(status);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.CardPaymentMethodSelected)) {
            getOrderStatus().setState(new WaitingToPay(status));
        }
        if (event.equals(Event.CashPaymentMethodSelected)) {
            getOrderStatus().setState(new WaitingToConfirm(status));
        }
    }
}
