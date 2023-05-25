package itis.giniyatov.Controller;

import itis.giniyatov.Domain.Passenger;
import itis.giniyatov.Service.PassengerService;
import itis.giniyatov.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private TripService tripService;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.findAllPassengers();
    }


    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<Passenger> getPassengerByName(@PathVariable("firstName") String firstName,
                                                        @PathVariable("lastName") String lastName) {



            return ResponseEntity.notFound().build();

    }
}
