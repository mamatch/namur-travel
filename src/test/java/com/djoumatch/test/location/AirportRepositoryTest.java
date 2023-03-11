package com.djoumatch.test.location;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class AirportRepositoryTest {

    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CityRepository cityRepository;

    @AfterEach
    void tearDown() {
        airportRepository.deleteAll();
        cityRepository.deleteAll();
    }

    @Test
    void itShouldFindById() {
        // given
        City city = new City("Douala");
        cityRepository.save(city);

        Airport airport = new Airport(
                "Douala Airport",
                city
        );
        airportRepository.save(airport);

        // when
        Airport result = airportRepository.findById(airport.getId()).get();

        // then
        assertThat(result).isSameAs(airport);


    }
}