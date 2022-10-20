// @author Rhonda Luu (u7127350)
package com.example.marketstructure.StateDesignPattern;

public class WaitingToSelectDeliveryOption extends State {

    public WaitingToSelectDeliveryOption(OrderStatus order) {
        super(order);
    }

    @Override
    public void handle(Event event) {
        if (event.equals(Event.DeliveryOptionSelected)) {
            getOrderStatus().setState(new WaitingToEnterDeliveryDetails(status));
        }
        if (event.equals(Event.Cancelled)) {
            getOrderStatus().setState(new Idle(status));
        }
    }
}
