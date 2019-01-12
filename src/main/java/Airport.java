import java.util.ArrayList;

public class Airport {

    private AirportReferenceType reference;
    private ArrayList<Plane> hangar;

    public Airport(AirportReferenceType airportReference){
        this.reference = airportReference;
        this.hangar = new ArrayList<>();
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
}
