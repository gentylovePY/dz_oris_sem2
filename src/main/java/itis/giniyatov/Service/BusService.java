package itis.giniyatov.Service;

import itis.giniyatov.Domain.Bus;
import itis.giniyatov.Domain.Passenger;
import itis.giniyatov.Domain.Route;
import itis.giniyatov.Domain.Trip;
import itis.giniyatov.Repository.BusRepository;
import itis.giniyatov.Repository.PassengerRepository;
import itis.giniyatov.Repository.RouteRepository;
import itis.giniyatov.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public List<Bus> findAllBuses() {
        return busRepository.findAll();
    }

    public List<Bus> findBusesWithSeatsGreaterThan(int seats) {
        return busRepository.findAllByNumberOfSeatsGreaterThanEqual(seats);
    }

    public Optional<Bus> findBusByNumberPlate(String numberPlate) {
        return busRepository.findByNumberPlate(numberPlate);
    }
}

