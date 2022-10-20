package com.example.marketstructure.StateDesignPattern;

public enum Event {
	SearchForListing, ListingSelectedToView, ListingSelectedToBuy, DeliveryOptionSelected,
	DeliveryDetailsEntered, CardPaymentMethodSelected, CardPaymentDetailsEntered, OrderConfirmed,
	CashPaymentMethodSelected, TextbookPaidByCard, TextbookPaidByCash, TextbookDispatchedPaidByCard,
	TextbookDispatchedNotPaid, Cancelled;
}
