package itis.giniyatov.Repository;

import itis.giniyatov.Domain.Bus;
import itis.giniyatov.Domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    List<Bus> findAllByNumberOfSeatsGreaterThanEqual(int seats);
    Optional<Bus> findByNumberPlate(String numberPlate);
}


