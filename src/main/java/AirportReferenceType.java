public enum AirportReferenceType {
    ABZ("Aberdeen"),
    DND("Dundee"),
    EDI("Edinburgh"),
    GLA("Glasgow"),
    INV("Inverness");

    private final String location;

    AirportReferenceType(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }
}
