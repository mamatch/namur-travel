package com.djoumatch.test.flight;

import com.djoumatch.test.location.Airport;
import com.djoumatch.test.location.AirportService;
import com.djoumatch.test.location.City;
import com.djoumatch.test.user.User;
import com.djoumatch.test.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FlightRequestMapperTest {

    @Mock
    private AirportService airportService;
    @Mock
    private UserService userService;
    private FlightRequestMapper flightRequestMapper;

    @BeforeEach
    void setUp() {
        flightRequestMapper = new FlightRequestMapper(airportService, userService);
    }

    @Test
    void shouldApply() {
        // given
        City city = new City("fgdfgfgf", "Douala");
        Airport airport = new Airport(
                "Douala Airport",
                city
        );
        User user = new User(
                "Djoumatch",
                "Eteil",
                "+324946705"
        );
        FlightAddRequest flightAddRequest = new FlightAddRequest(
                1l,
                1l,
                LocalDate.of(2023, 03, 21),
                LocalDate.of(2023, 03, 27),
                12f,
                5f,
                user.getNumber()
        );

        given(airportService.getAirportById(anyLong()))
                .willReturn(airport);
        given(userService.getUserByNumber(anyString()))
                .willReturn(user);

        // when
        Flight result = flightRequestMapper.apply(flightAddRequest);

        // then
        Flight expected = new Flight(
                airport,
                airport,
                LocalDate.of(2023, 03, 21),
                LocalDate.of(2023, 03, 27),
                12f,
                5f,
                user
        );

        assertThat(result).isEqualToComparingFieldByField(expected);
    }
}