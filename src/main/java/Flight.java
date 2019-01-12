import java.lang.reflect.Array;
import java.util.ArrayList;

public class Flight {
    private String flightNumber;
    private AirportReferenceType destination;
    private int departureTime;
    private int arrivalTime;
    private Plane assignedPlane;
    private ArrayList<Passenger> passengers;

    public Flight(String flightNumber, AirportReferenceType destination, int departureTime, int arrivalTime){
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.assignedPlane = null;
        this.passengers = new ArrayList<>();
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination.getLocation();
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public Plane getAssignedPlane() {
        return assignedPlane;
    }

    public void assignPlane(Plane plane) {
        this.assignedPlane = plane;
    }

    public int getNumberOfPassengers() {
        return passengers.size();
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public PlaneType getPlaneType() {
        PlaneType assignedPlaneType = null;
        if (assignedPlane != null) {
            assignedPlaneType = assignedPlane.getPlaneType();
        }
        return assignedPlaneType;
    }
}
