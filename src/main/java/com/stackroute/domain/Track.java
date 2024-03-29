package com.stackroute.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Track {

    @Id
    int id;
    String trackName;
    String trackComments;

    public Track() {
    }

    public Track(int id, String trackName, String trackComments) {
        this.id = id;
        this.trackName = trackName;
        this.trackComments = trackComments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackComments() {
        return trackComments;
    }

    public void setTrackComments(String trackComments) {
        this.trackComments = trackComments;
    }
}