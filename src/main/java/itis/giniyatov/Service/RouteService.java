package itis.giniyatov.Service;

import itis.giniyatov.Domain.Route;
import itis.giniyatov.Repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public List<Route> findAllRoutes() {
        return routeRepository.findAll();
    }

    public List<Route> findRoutesByNameContaining(String name) {
        return routeRepository.findAllByNameContaining(name);
    }

    public List<Route> findRoutesByStartingPointAndEndPoint(String startingPoint, String endPoint) {
        return routeRepository.findAllByStartingPointAndEndPoint(startingPoint, endPoint);
    }
}
