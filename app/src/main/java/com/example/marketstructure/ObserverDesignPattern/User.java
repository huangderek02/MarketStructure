// @author Derek Huang (u7300484)
package com.example.marketstructure.ObserverDesignPattern;

import java.util.Objects;

public class User implements Observer {
    final private int userId;
    private boolean notifiedOfFraud = false;
    private static int userIdSequentialCounter = 0;

    /**
     * Constructor which sets the userId.
     * @param userId of the user (to identify them)
     */
    public User(int userId) {
        this.userId = userId;
    }

    public User() {
        this.userId = generateNewUserId();
    }

    public static int generateNewUserId() {
        userIdSequentialCounter++;
        return userIdSequentialCounter;
    }

    /**
     * @return integer representing user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @return whether the current user is notified of an outbreak
     */
    public boolean isNotifiedOfOutbreak() {
        return notifiedOfFraud;
    }

    /**
     * Updates notification state.
     */
    @Override
    public void update() {
        this.notifiedOfFraud = true;
    }

    /**
     * Prints out the user details
     * @return string containing the information of the user
     */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", notifiedOfOutbreak=" + notifiedOfFraud +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && notifiedOfFraud == user.notifiedOfFraud;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, notifiedOfFraud);
    }
}

