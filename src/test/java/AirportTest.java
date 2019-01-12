import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;
    Plane plane;
    Flight flight;
    Passenger passenger;

    @Before
    public void before(){
        airport = new Airport(AirportReferenceType.EDI);
        plane = new Plane(PlaneType.BOEING_DREAMLINER, "British Airways", 202);
        flight = new Flight("ABC12", AirportReferenceType.DND, 1300, 1330);
        passenger = new Passenger("Stanley Tucci", AirportReferenceType.DND);
    }

    @Test
    public void startsWithNoPlanesInHanger(){
        assertEquals(0, airport.getNumberOfPlanesInHangar());
    }

    @Test
    public void hasReference(){
        assertEquals(AirportReferenceType.EDI, airport.getAirportReference());
    }

    @Test
    public void hasLocation(){
        assertEquals("Edinburgh", airport.getAirportLocation());
    }

    @Test
    public void canAddPlaneToHangar(){
        airport.addPlaneToHangar(plane);
        assertEquals(1, airport.getNumberOfPlanesInHangar());
    }

    @Test
    public void startsWithNoFlights(){
        assertEquals(0, airport.getNumberOfFlights());
    }

    @Test
    public void canAddFlights(){
        airport.addFlight(flight);
        airport.addFlight(flight);
        assertEquals(2, airport.getNumberOfFlights());
    }

    @Test
    public void startsWithNoPassengers(){
        assertEquals(0, airport.getNumberOfPassengers());
    }

    @Test
    public void canAddPassengers(){
        airport.addPassenger(passenger);
        assertEquals(1, airport.getNumberOfPassengers());
    }

    @Test
    public void canSellTicket(){
        airport.addPassenger(passenger);
        flight.assignPlane(plane);
        airport.sellTicket(flight, passenger);
        assertEquals(1, flight.getNumberOfPassengers());
    }

    @Test
    public void canRemovePlaneFromHangar(){
        airport.addPlaneToHangar(plane);
        airport.addPlaneToHangar(plane);
        airport.addPlaneToHangar(plane);
        airport.removePlaneFromHangar(plane);
        assertEquals(2, airport.getNumberOfPlanesInHangar());
    }

    @Test
    public void canAssignPlaneToFlight(){
        airport.addPlaneToHangar(plane);
        airport.addPlaneToHangar(plane);
        airport.addPlaneToHangar(plane);
        assertEquals(3, airport.getNumberOfPlanesInHangar());
        flight.addPassenger(passenger);
        airport.assignPlaneToFlight(flight);
        assertEquals(2, airport.getNumberOfPlanesInHangar());
    }

}
