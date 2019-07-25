package com.stackroute.exceptions;
import java.lang.String;
public class TrackAlreadyExistsException extends Exception{
    //Display message
    private String message;
    //Default and parameterize constructors
    public TrackAlreadyExistsException() {
    }
    public TrackAlreadyExistsException(String message)
    {
        super(message);
        this.message=message;
    }

}
