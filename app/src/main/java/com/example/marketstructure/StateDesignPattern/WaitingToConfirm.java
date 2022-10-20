// @author Rhonda Luu (u7127350)
package com.example.marketstructure.StateDesignPattern;

public class WaitingToConfirm extends State {

    public WaitingToConfirm(OrderStatus status) {
        super(status);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.OrderConfirmed)) {
            getOrderStatus().setState(new WaitingToDispatch(status));
        }
        if (event.equals(Event.Cancelled)) {
            getOrderStatus().setState(new Idle(status));
        }
    }
}
