package com.djoumatch.test.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    @Query("SELECT CASE WHEN count(f) > 0 THEN true ELSE false END FROM Flight f WHERE f.id = :id")
    Boolean checksFlightExist(@Param("id") String id);
}
