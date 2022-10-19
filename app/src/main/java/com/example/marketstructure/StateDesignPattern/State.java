package com.example.marketstructure.StateDesignPattern;

import com.example.marketstructure.Listing;

public abstract class State {
	
	protected final Listing listing;
	
	public State(Listing listing) {
		this.listing = listing;
	}
	
	public abstract void handle(Event event);

	public Listing getListing() {
		return listing;
	}
}
