package com.stackroute.service;


import com.stackroute.domain.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    public boolean saveTrack(Track track);

    public boolean deleteTrack(int id);

    public List<Track> getAllTracks();

    public Track getTrackById(int id);

    public Track updateTrack(Track track,int id) throws Exception;

}
