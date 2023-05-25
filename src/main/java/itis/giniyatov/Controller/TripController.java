package itis.giniyatov.Controller;

import itis.giniyatov.Domain.Bus;
import itis.giniyatov.Domain.Trip;
import itis.giniyatov.Service.BusService;
import itis.giniyatov.Service.RouteService;
import itis.giniyatov.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trips")
public class TripController {
    @Autowired
    private TripService tripService;
    @Autowired
    private BusService busService;
    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.findAllTrips();
    }

    @GetMapping("/bus/{numberPlate}")
    public ResponseEntity<List<Trip>> getTripsByBusNumberPlate(@PathVariable("numberPlate") String numberPlate) {
        Optional<Bus> optionalBus = busService.findBusByNumberPlate(numberPlate);


            return ResponseEntity.notFound().build();

    }


    @GetMapping("/time")
    public List<Trip> getTripsBetween(@RequestParam("start") String start, @RequestParam("end") String end) {
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);

        return tripService.findTripsBetween(startTime, endTime);
    }
}
