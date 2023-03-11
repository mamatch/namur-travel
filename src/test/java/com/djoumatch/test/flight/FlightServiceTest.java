package com.djoumatch.test.flight;

import com.djoumatch.test.exception.NotFoundException;
import com.djoumatch.test.location.Airport;
import com.djoumatch.test.location.AirportRepository;
import com.djoumatch.test.location.City;
import com.djoumatch.test.location.CityRepository;
import com.djoumatch.test.user.User;
import com.djoumatch.test.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;
    @Mock
    private FlightDTOMapper flightDTOMapper;
    @Mock
    private FlightRequestMapper flightRequestMapper;
    private FlightService flightService;

    @BeforeEach
    void setUp() {
        flightService = new FlightService(flightRepository, flightDTOMapper, flightRequestMapper);
    }

    @Test
    void canGetAllFlights() {
        // when
        flightService.all();

        // then
        verify(flightRepository).findAll();
    }

    @Test
    void canAddFlight() {
        // given
        City city = new City("fgdfgfgf", "Douala");
        Airport airport = new Airport(
                "ggdfgdfgfgdfg",
                "Douala Airport",
                city
        );
        User user = new User(
                "fgdfgdfgfg",
                "Djoumatch",
                "Eteil",
                "+324946705"
        );
        Flight f = new Flight(
                airport,
                airport,
                LocalDate.parse("2023-03-21"),
                LocalDate.parse("2023-03-27"),
                23f,
                15f,
                user
        );
        FlightAddRequest flightAddRequest = new FlightAddRequest(
                airport.getId(),
                airport.getId(),
                LocalDate.parse("2023-03-21"),
                LocalDate.parse("2023-03-27"),
                23f,
                15f,
                user.getNumber()
        );

        // when
        given(flightRequestMapper.apply(any()))
                .willReturn(f);

        flightService.addFlight(flightAddRequest);

        // then
        ArgumentCaptor<Flight> flightArgumentCaptor = ArgumentCaptor.forClass(Flight.class);
        verify(flightRepository).save(flightArgumentCaptor.capture());
        Flight capturedFlight = flightArgumentCaptor.getValue();

        assertThat(capturedFlight).isEqualTo(f);

    }

    @Test
    void shouldDeleteFlight() {
        // given
        String id = "gdgdfgdf";

        given(flightRepository.checksFlightExist(id))
                .willReturn(true);

        // then
        flightService.deleteFlight(id);
        verify(flightRepository).deleteById(id);

    }

    @Test
    void shouldThrowExceptionWhenDeleteFlight() {
        // given
        String id = "gdgdfgdf";

        given(flightRepository.checksFlightExist(id))
                .willReturn(false);

        // then
        assertThatThrownBy(() -> flightService.deleteFlight(id))
                .isInstanceOf(NotFoundException.class);
        verify(flightRepository, never()).deleteById(id);

    }

}