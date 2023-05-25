package itis.giniyatov.Service;

import itis.giniyatov.Domain.Passenger;
import itis.giniyatov.Domain.Trip;
import itis.giniyatov.Repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }

    public List<Passenger> findPassengersByTrip(Trip trip) {
        return passengerRepository.findAllByTripsContaining(trip);
    }

//    public Optional<Passenger> findPassengerByName(String firstName, String lastName) {
//        return passengerRepository.findByFirstNameAndLastName(firstName, lastName);
//    }
}
