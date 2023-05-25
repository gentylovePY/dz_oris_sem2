package itis.giniyatov.Controller;

import itis.giniyatov.Domain.Bus;
import itis.giniyatov.Domain.Passenger;
import itis.giniyatov.Domain.Route;
import itis.giniyatov.Domain.Trip;
import itis.giniyatov.Service.BusService;
import itis.giniyatov.Service.PassengerService;
import itis.giniyatov.Service.RouteService;
import itis.giniyatov.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buses")
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.findAllBuses();
    }

    @GetMapping("/{numberPlate}")
    public ResponseEntity<Bus> getBusByNumberPlate(@PathVariable("numberPlate") String numberPlate) {
        Optional<Bus> optionalBus = busService.findBusByNumberPlate(numberPlate);

        if (optionalBus.isPresent()) {
            return ResponseEntity.ok(optionalBus.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/seats/{seats}")
    public List<Bus> getBusesWithSeatsGreaterThan(@PathVariable("seats") int seats) {
        return busService.findBusesWithSeatsGreaterThan(seats);
    }
}

