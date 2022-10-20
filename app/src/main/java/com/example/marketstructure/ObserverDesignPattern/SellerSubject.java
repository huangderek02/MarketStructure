package com.example.marketstructure.ObserverDesignPattern;

import java.util.*;

/**
 * A location.
 * Tracks users who have been to the location.
 * If a user becomes scammed, informs all users that viewed the listing at the same time as the
 * same user within 10 listings
 *
 */
public class SellerSubject implements Subject<User> {
    private final int sellerId;
    private final Set<BuyerLog> buyerLogs;
    private int currentLocationTick;

    /**
     * Constructor which sets class values.
     */
    public SellerSubject(int locationId) {
        currentLocationTick = 0; // setting the 'location clock' to zero
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
     * @param incQuantity amount by which to increment the tick
     */
    public void incLocationTick(int incQuantity) {
        // TODO: write this method so that it increments the current location tick (currentLocationTick)
        // YOUR CODE STARTS HERE
        currentLocationTick = currentLocationTick + incQuantity;
        // YOUR CODE ENDS HERE
    }


    /**
     * Simply adds the user to the list of visitors of the app.
     * @param observer user to be added.
     */
    public void attach(Observer observer) {
        buyerLogs.add(new BuyerLog(observer,currentLocationTick));
    }

    /**
     * Removes the buyer log at the current listing which contains the provided observer.
     * eg. simulating when someone logs into the app and then changes their mind and
     * logs out
     * @param observer to remove
     */
    public void detach(Observer observer) {
        // TODO: write this method so that it removes the attendance log at the current tick which contains the provided observer.
        // YOUR CODE STARTS HERE
//        attendanceLogs.removeIf(log -> log.getObserver().equals(observer));
        BuyerLog pointer = null;
        for(BuyerLog log: buyerLogs){
            if(log.getObserver().equals(observer)){
                pointer = log;
            }
        }
        buyerLogs.remove(pointer);

        // YOUR CODE ENDS HERE
    }


    /**
     * Informs all users that visited the location at the same time as the scammed
     * user within 10 ticks
     * @param scammedPerson user that may have visited the location that has now tested positive
     *                      for the scam
     */
    public void notifyObservers(User scammedPerson) {
        /*
        TODO: write this method so that it notifies all users that visited the location at the same time as the infected user within 10 listings
        Hint: all observers already have an 'update()' method.
         */
        // YOUR CODE STARTS HERE

        int listing = 0;
        int listingstart = 0;
        int listingend = currentLocationTick;

        List<Integer> listings = new ArrayList<>();
        for(BuyerLog buyerLog :buyerLogs){

            if (buyerLog.getObserver().equals(scammedPerson)){
                listing = buyerLog.getListingsVisited();
                listings.add(listing);
            }
        }
        if(listingend>10){
            listingstart = listingend - 10;
        }

        for(int l:listings){
            for(BuyerLog log:buyerLogs){
                if(log.getListingsVisited() >= listingstart && log.getListingsVisited()<=listingend && log.getListingsVisited() == l){
                    log.getObserver().update();
                }
            }
            //
        }


        //YOUR CODE ENDS HERE
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
