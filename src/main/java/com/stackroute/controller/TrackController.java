package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("api/v1")
public class TrackController {

    @Autowired
    TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService= trackService;
    }
            ResponseEntity responseEntity;

    //add handler
    @PostMapping("saveTrack")
    public ResponseEntity<?> saveUser(@RequestBody Track track) {
        
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
        } catch (TrackAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;

    }

    //getting all tracks handler
    @GetMapping("allTracks")
    public ResponseEntity<?> getAllTracks()
    {
       

        responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);

        return responseEntity;
    }

    //delete handler
    @DeleteMapping("/track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable(value="id") int trackId) {
        
        try {
            trackService.deleteTrack(trackId);
            responseEntity = new ResponseEntity("Deleted Successfully",HttpStatus.OK);
        }
        catch (TrackNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

   // update handler
    @PutMapping("/track/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable(value="id")int trackId,@RequestBody Track trackDetails)
    {
        
        try {
            responseEntity = new ResponseEntity(trackService.updateTrack(trackDetails,trackId),HttpStatus.OK);
        } catch(Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


}




