package itis.giniyatov.Repository;

import itis.giniyatov.Domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findAllByNameContaining(String name);
    List<Route> findAllByStartingPointAndEndPoint(String startingPoint, String endPoint);
}
