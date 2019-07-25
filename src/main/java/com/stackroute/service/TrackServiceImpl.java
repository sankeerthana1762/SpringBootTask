package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository userRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean saveTrack(Track track) {

        userRepository.save(track);
        return true;
    }

    @Override
    public boolean deleteTrack(int id) {
        if (userRepository.existsById(id)) {
            Track track = getTrackById(id);
            userRepository.delete(track);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Track> getAllTracks() {
        return userRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) {
        return getTrackById(id);
    }
    @Override
    public Track updateTrack(Track track,int id)throws Exception {
        Optional<Track> trackOptional = userRepository.findById(id);
        if (!trackOptional.isPresent())
            throw new Exception("track id not found");
        track.setId(id);
        return userRepository.save(track);

    }




}
