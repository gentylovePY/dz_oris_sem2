package itis.giniyatov.Domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "passenger_trip",
            joinColumns = { @JoinColumn(name = "trip_id") },
            inverseJoinColumns = { @JoinColumn(name = "passenger_id") }
    )
    private Set<Passenger> passengers = new HashSet<>();

    public Trip() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Trip(Long id, String destination, Set<Passenger> passengers) {
        this.id = id;
        this.destination = destination;
        this.passengers = passengers;
    }
}