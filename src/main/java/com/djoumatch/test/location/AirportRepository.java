package com.djoumatch.test.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, String> {
    @Query("SELECT a FROM Airport a WHERE a.id = :id")
    Optional<Airport> findById(@Param("id") String id);
}
