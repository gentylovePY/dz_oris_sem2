package itis.giniyatov.Service;

import itis.giniyatov.Domain.Bus;
import itis.giniyatov.Domain.Route;
import itis.giniyatov.Domain.Trip;
import itis.giniyatov.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public List<Trip> findAllTrips() {
        return tripRepository.findAll();
    }

//    public List<Trip> findTripsByBus(Bus bus) {
//        return tripRepository.findAllByBus(bus);
//    }

    public List<Trip> findTripsByRoute(Route route) {
        return tripRepository.findAllByRoute(route);
    }

    public List<Trip> findTripsBetween(LocalDateTime start, LocalDateTime end) {
        return tripRepository.findAllByDepartureTimeBetween(start, end);
    }
}
