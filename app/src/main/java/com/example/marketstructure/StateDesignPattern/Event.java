package com.example.marketstructure.StateDesignPattern;

public enum Event {
	SearchForListing, ListingSelectedToView, ListingSelectedToBuy, DeliveryOptionSelected,
	DeliveryDetailsEntered, CardPaymentMethodSelected, CardPaymentDetailsEntered, OrderConfirmed,
	CashPaymentMethodSelected, TextbookPaidByCash, TextbookDispatchedPaidByCard,
	TextbookDispatchedNotPaid, Cancelled;
}
