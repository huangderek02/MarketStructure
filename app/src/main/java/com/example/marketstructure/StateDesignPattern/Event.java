// @author Rhonda Luu (u7127350)
package com.example.marketstructure.StateDesignPattern;

public enum Event {
	SearchForListing, ListingSelectedToView, ListingSelectedToBuy, DeliveryOptionSelected,
	DeliveryDetailsEntered, CardPaymentMethodSelected, CardPaymentDetailsEntered, OrderConfirmed,
	CashPaymentMethodSelected, TextbookPaidByCash, TextbookDispatchedPaidByCard,
	TextbookDispatchedNotPaid, Cancelled;
}
