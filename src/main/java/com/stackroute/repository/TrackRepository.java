package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
}
