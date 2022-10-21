// @author Derek Huang (u7300484)
package com.example.marketstructure.ObserverDesignPattern;

import java.util.*;

/**
 * A location.
 * Tracks listings that are under the fraud seller identified
 * If a user becomes scammed, informs all users that viewed the listing at the same time as the
 * same user within 10 listings
 *
 */
public class SellerSubject implements Subject<User> {
    private final int sellerId;
    private final Set<SellerListings> buyerLogs;
    private int currentListingNumber;

    /**
     * Constructor which sets class values.
     */
    public SellerSubject(int locationId) {
        currentListingNumber = 0; // setting the 'location clock' to zero
        this.sellerId = locationId;
        this.buyerLogs = new HashSet<>();
    }

    /**
     * This method is executed when a new Fraud case has been reported
     * @param scammed A user who has found to be scammed whilst viewing the current lisitng
     */
    public void newFraudReportProcedure(User scammed) {
        notifyObservers(scammed);
    }

    /**
     * Updates the current listing of the seller
     * @param incListingNumber amount by which to increment the tick
     */
    public void incListingNumber(int incListingNumber) {
        currentListingNumber = currentListingNumber + incListingNumber;
    }


    /**
     * Simply adds the user to the list of visitors of the app.
     * @param observer user to be added.
     */
    public void attach(Observer observer) {
        buyerLogs.add(new SellerListings(observer, currentListingNumber));
    }

    /**
     * Removes the buyer log at the current listing which contains the provided observer.
     * eg. simulating when someone logs into the app and then changes their mind and
     * logs out
     * @param observer to remove
     */
    public void detach(Observer observer) {
        SellerListings pointer = null;
        for(SellerListings log: buyerLogs){
            if(log.getObserver().equals(observer)){
                pointer = log;
            }
        }
        buyerLogs.remove(pointer);
    }


    /**
     * Informs all users that visited the location at the same time as the scammed
     * user within 10 ticks
     * @param scammedPerson user that may have visited the location that has now tested positive
     *                      for the scam
     */
    public void notifyObservers(User scammedPerson) {
        int listing = 0;
        int listingstart = 0;
        int listingend = currentListingNumber;

        List<Integer> listings = new ArrayList<>();
        for(SellerListings buyerLog :buyerLogs){

            if (buyerLog.getObserver().equals(scammedPerson)){
                listing = buyerLog.getListingNumber();
                listings.add(listing);
            }
        }
        if(listingend>10){
            listingstart = listingend - 10;
        }

        for(int l:listings){
            for(SellerListings log:buyerLogs){
                if(log.getListingNumber() >= listingstart && log.getListingNumber()<=listingend && log.getListingNumber() == l){
                    log.getObserver().update();
                }
            }
        }
    }

    /**
     * Prints out the user details
     * @return string containing the information of the user
     */
    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + sellerId +
                ", attendanceLogs=" + buyerLogs +
                '}';
    }

}
