package co.develhope.Exercise_SpringBoot_CustomQueries_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;
    @GetMapping("/provisioning")
    public List<Flight> provisioningFlights() {
        List<Flight> flights = new ArrayList<>();
        List<String> descriptions = Arrays.asList("Business Trip", "Vacation", "Family Visit", "Conference", "Holiday");
        List<String> airports = Arrays.asList("JFK", "LAX", "ORD", "ATL", "LHR", "CDG", "FRA", "DXB", "HND", "PEK");
        Random random = new Random();
        for(int i = 0; i < 50; i++) {
            Flight flight = new Flight(descriptions.get(random.nextInt(descriptions.size())),
                    airports.get(random.nextInt(airports.size())),
                    airports.get(random.nextInt(airports.size())));

            flights.add(flight);
        }

        return flightRepository.saveAllAndFlush(flights);
    }

    @GetMapping("/retrieveAll")
    public List<Flight> retrieveAllFlights() {
        return flightRepository.findAll();
    }

    @GetMapping("/findByStatus")
    public List<Flight> retrieveByStatus(String status){
        return flightRepository.findByStatus(FlightStatus.toString(status));
    }
}