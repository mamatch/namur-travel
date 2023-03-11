package com.djoumatch.test.flight;

import com.djoumatch.test.location.Airport;
import com.djoumatch.test.location.AirportRepository;
import com.djoumatch.test.location.City;
import com.djoumatch.test.location.CityRepository;
import com.djoumatch.test.user.User;
import com.djoumatch.test.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FlightRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FlightRepository flightRepository;


    @AfterEach
    void tearDown() {
        flightRepository.deleteAll();
        userRepository.deleteAll();
        airportRepository.deleteAll();
        cityRepository.deleteAll();
    }

    @Test
    void checksFlightShouldExist() {
        // given
        City city = new City("Douala");
        cityRepository.save(city);

        Airport airport = new Airport(
                "Douala Airport",
                city
        );
        airportRepository.save(airport);
        User user = new User(
                "Djoumatch",
                "Eteil",
                "+324946705"
        );
        userRepository.save(user);
        Flight flight = new Flight(
                airport,
                airport,
                LocalDate.parse("2023-03-21"),
                LocalDate.parse("2023-03-27"),
                23f,
                15f,
                user
        );
        flightRepository.save(flight);

        // when
        Boolean result = flightRepository.checksFlightExist(flight.getId());

        // then
        assertThat(result).isTrue();
    }
}