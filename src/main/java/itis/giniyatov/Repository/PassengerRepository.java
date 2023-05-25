package itis.giniyatov.Repository;

import itis.giniyatov.Domain.Passenger;
import itis.giniyatov.Domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    List<Passenger> findAllByTripsContaining(Trip trip);
    //Optional<Passenger> findByFirstNameAndLastName(String firstName, String lastName);
}
