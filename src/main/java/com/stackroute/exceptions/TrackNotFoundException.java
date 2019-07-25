package com.stackroute.exceptions;

public class TrackNotFoundException extends Exception{
    //Display message
    private String message;
    //Default and paramterized constructor
    public TrackNotFoundException() {
    }


    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
