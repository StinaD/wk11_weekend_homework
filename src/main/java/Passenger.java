public class Passenger {
    private String name;
    private AirportReferenceType destination;


    public Passenger(String fullName, AirportReferenceType destination){
        this.name = fullName;
        this.destination = destination;
    }

    public String getName(){
        return name;
    }


    public String getDestination(){
        return this.destination.getLocation();
    }
}
