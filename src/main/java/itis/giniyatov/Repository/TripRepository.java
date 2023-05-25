package itis.giniyatov.Repository;

import itis.giniyatov.Domain.Bus;
import itis.giniyatov.Domain.Route;
import itis.giniyatov.Domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    //List<Trip> findAllByBus(Bus bus);
    List<Trip> findAllByRoute(Route route);
    List<Trip> findAllByDepartureTimeBetween(LocalDateTime start, LocalDateTime end);
}
