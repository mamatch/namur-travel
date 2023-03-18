package com.djoumatch.test.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    /**
     * Check that a flight exists
     *
     * @param id The id of the flight
     * @return True if exists, else False
     */
    @Query("SELECT CASE WHEN count(f) > 0 THEN true ELSE false END FROM Flight f WHERE f.id = :id")
    Boolean checksFlightExist(@Param("id") Long id);

    /**
     * Checks if a fligh can be booked based on the weight reserved
     *
     * @param weight The weight the user wants to reserve
     * @param id     The id of the flight
     * @return true if possible else false
     */
    @Query("SELECT CASE WHEN f.weightAvailable > :weight THEN true ELSE false END FROM Flight f WHERE f.id = :id")
    Boolean checksFlightCanBeReserved(@Param("weight") Float weight, @Param("id") Long id);
}
