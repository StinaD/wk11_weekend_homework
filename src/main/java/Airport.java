import java.util.ArrayList;


public class Airport {

    private AirportReferenceType reference;
    private ArrayList<Plane> hangar;
    private ArrayList<Flight> flights;
    private ArrayList<Passenger> departingPassengers;

    public Airport(AirportReferenceType airportReference){
        this.reference = airportReference;
        this.hangar = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.departingPassengers = new ArrayList<>();

    }

    public int getNumberOfPlanesInHangar() {
        return hangar.size();
    }

    public AirportReferenceType getAirportReference(){
        return reference;
    }

    public String getAirportLocation() {
        return reference.getLocation();
    }

    public void addPlaneToHangar(Plane plane) {
        hangar.add(plane);
    }

    public int getNumberOfFlights() {
        return flights.size();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public int getNumberOfPassengers() {
        return departingPassengers.size();
    }

    public void addPassenger(Passenger passenger) {
        departingPassengers.add(passenger);
    }


    public void sellTicket(Flight flight, Passenger passenger){
        if ( (flight.getDestination() == passenger.getDestination()) && (flight.getAssignedPlane().getCapacity() > flight.getNumberOfPassengers()) ) {
            flight.addPassenger(passenger);
        }
    }

    public void removePlaneFromHangar(Plane plane) {
        hangar.remove(plane);
    }

    private PlaneType findSmallestSuitablePlaneType(Flight flight){
        PlaneType suitablePlane = null;
        for (PlaneType plane : PlaneType.values()) {
            if (flight.getNumberOfPassengers() >= plane.getCapacity()) {
                suitablePlane = plane;
            }
        }
        return suitablePlane;
    }

    public void getBackUpPlane(Flight flight){
        int planeCapacityRequired = flight.getNumberOfPassengers();
        Plane backUpPlane = null;
        for (Plane plane : hangar) {
            if (plane.getCapacity() >= planeCapacityRequired){
                backUpPlane = plane;
                break;
            }
        }
        flight.assignPlane(backUpPlane);
    }

    public Plane getSuitablePlaneForFlight(Flight flight){
        for (PlaneType planeType : PlaneType.values() ) {
            if (flight.getNumberOfPassengers() > planeType.getCapacity()){
                continue;
            }
            for (Plane plane : hangar) {
                if (plane.getPlaneType() == planeType) {
                    return plane;
                }
            }
        }
        return null;
    }


    public boolean getPlaneForFlight(Flight flight){
        Plane plane = getSuitablePlaneForFlight(flight);
        if (plane != null){
            flight.assignPlane(plane);
            removePlaneFromHangar(plane);
            return true;
        }
        return false;
    }


    public int countPassengersOnFlights() {
        int totalPassengers = 0;
        for(Flight flight : flights) {
            totalPassengers += flight.getNumberOfPassengers();
        }
        return totalPassengers;
    }
}
