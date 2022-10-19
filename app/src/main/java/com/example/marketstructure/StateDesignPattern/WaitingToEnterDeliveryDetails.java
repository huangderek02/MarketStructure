package com.example.marketstructure.StateDesignPattern;

public class WaitingToEnterDeliveryDetails extends State {

    public WaitingToEnterDeliveryDetails(OrderStatus status) {
        super(status);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.DeliveryDetailsEntered)) {
            getOrderStatus().setState(new WaitingToSelectPaymentMethod(status));
        }
        if (event.equals(Event.Cancelled)) {
            getOrderStatus().setState(new Idle(status));
        }
        if (event.equals(Event.Timeout)) {
            getOrderStatus().setState(new Idle(status));
        }
    }
}
