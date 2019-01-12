import java.util.ArrayList;

public class Plane {
    private PlaneType planeType;
    private String airline;
    private int uniqueIdentifier;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType planeType, String airline, int uniqueIdentifier){
        this.planeType = planeType;
        this.airline = airline;
        this.uniqueIdentifier = uniqueIdentifier;
        this.passengers = new ArrayList<>();
    }

    public int getNumberOfPassengers(){
        return passengers.size();
    }


    public PlaneType getPlaneType() {
        return planeType;
    }


    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline){
        this.airline = airline;
    }


    public int getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(int uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    
}
