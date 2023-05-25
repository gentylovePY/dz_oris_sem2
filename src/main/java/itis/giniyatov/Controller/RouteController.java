package itis.giniyatov.Controller;

import itis.giniyatov.Domain.Route;
import itis.giniyatov.Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.findAllRoutes();
    }

    @GetMapping("/name/{name}")
    public List<Route> getRoutesByNameContaining(@PathVariable("name") String name) {
        return routeService.findRoutesByNameContaining(name);
    }

    @GetMapping("/{startingPoint}/{endPoint}")
    public List<Route> getRoutesByStartingPointAndEndPoint(@PathVariable("startingPoint") String startingPoint,
                                                           @PathVariable("endPoint") String endPoint) {
        return routeService.findRoutesByStartingPointAndEndPoint(startingPoint, endPoint);
    }
}
