package com.stackroute.service;


import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;


import java.util.List;
import java.util.Optional;

public interface TrackService {

    public boolean saveTrack(Track track)throws TrackAlreadyExistsException;

    public boolean deleteTrack(int id)throws TrackNotFoundException;

    public List<Track> getAllTracks();

    public Track getTrackById(int id);

    public Track updateTrack(Track track,int id) throws Exception;





}
