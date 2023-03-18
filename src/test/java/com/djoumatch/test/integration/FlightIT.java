package com.djoumatch.test.integration;

import com.djoumatch.test.flight.Flight;
import com.djoumatch.test.flight.FlightAddRequest;
import com.djoumatch.test.flight.FlightRepository;
import com.djoumatch.test.location.Airport;
import com.djoumatch.test.location.AirportRepository;
import com.djoumatch.test.location.City;
import com.djoumatch.test.location.CityRepository;
import com.djoumatch.test.user.User;
import com.djoumatch.test.user.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-it.properties")
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlightIT {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FlightRepository flightRepository;
    private City city;
    private Airport airport;
    private User user;

    @BeforeEach
    void setUp() {


    }

    @BeforeAll
    void beforeAll() {
        this.city = new City("Douala");
        cityRepository.save(city);

        this.airport = new Airport(
                "Douala Airport",
                city
        );
        airportRepository.save(airport);
        this.user = new User(
                "Djoumatch",
                "Eteil",
                "+324946705"
        );
        userRepository.save(user);
    }

    @AfterAll
    void afterAll() {
        flightRepository.deleteAll();
        userRepository.deleteAll();
        airportRepository.deleteAll();
        cityRepository.deleteAll();

    }

    @Test
    void canGetAllFlights() throws Exception {
        //given
        //when
        //then
        ResultActions resultActions = mockMvc.perform(get("/api/v1/flights"));
        resultActions.andExpect(status().isOk());
    }

    @Test
    void canAddFlight() throws Exception {
        //given
        FlightAddRequest flightAddRequest = new FlightAddRequest(
                this.airport.getId(),
                this.airport.getId(),
                LocalDate.now(),
                LocalDate.now(),
                15f,
                25f,
                this.user.getNumber()
        );

        // when
        ResultActions resultActions = mockMvc.perform(
                post("/api/v1/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(flightAddRequest))
        );

        // then
        resultActions.andExpect(status().isCreated());
    }

    @Test
    public void canDeleteFlight() throws Exception {
        //given
        Flight flight = new Flight(
                airport,
                airport,
                LocalDate.now(),
                LocalDate.now(),
                15f,
                20f,
                user
        );
        flightRepository.save(flight);

        // when
        ResultActions resultActions = mockMvc.perform(
                delete(String.format("/api/v1/flights/%s", flight.getId()))
        );

        // then
        resultActions.andExpect(status().isOk());

    }
}
