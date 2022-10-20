// @author Derek Huang (u7300484)
package com.example.marketstructure.ObserverDesignPattern;

import java.util.Objects;

public class SellerListings {
    final private Observer observer; // seller that has been identified as fraud
    final private Integer listingNumber; // listing number of identified fraud seller

    /**
     * Constructor which sets tuple values
     */
    public SellerListings(Observer observer, int tickVisited) {
        this.observer = observer;
        this.listingNumber = tickVisited;
    }

    /**
     * @return observer object
     */
    public Observer getObserver() {
        return observer;
    }

    /**
     * @return current listng number
     */
    public int getListingNumber() {
        return listingNumber;
    }


    /**
     * Prints out the seller details
     * @return string containing the information of the user
     */
    @Override
    public String toString() {
        return "SellerListings{" +
                "observer=" + observer +
                ", listing=" + listingNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerListings that = (SellerListings) o;
        return observer.equals(that.observer) && listingNumber.equals(that.listingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(observer, listingNumber);
    }
}
