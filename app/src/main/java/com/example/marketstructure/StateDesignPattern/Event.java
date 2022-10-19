package com.example.marketstructure.StateDesignPattern;

public enum Event {
	SearchForListing, ListingSelected, DeliveryOptionSelected, DeliveryDetailsEntered,
	CardPaymentMethodSelected, CashPaymentMethodSelected, TextbookPaidByCard, TextbookPaidByCash,
	TextbookDispatched, TextbookDispatchedNotPaid, Cancelled, Timeout;
}
