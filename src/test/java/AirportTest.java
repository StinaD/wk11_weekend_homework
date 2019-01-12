import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;
    Plane plane;
    Flight flight1;
    Flight flight2;
    Passenger passenger1;
    Passenger passenger2;

    @Before
    public void before(){
        airport = new Airport(AirportReferenceType.EDI);
        plane = new Plane(PlaneType.BOEING_DREAMLINER, "British Airways", 202);
        flight1 = new Flight("ABC12", AirportReferenceType.DND, 1300, 1330);
        flight2 = new Flight("XYZ999", AirportReferenceType.INV, 1600, 1730);
        passenger1 = new Passenger("Stanley Tucci", AirportReferenceType.DND);
        passenger2 = new Passenger("Meryl Streep", AirportReferenceType.INV);
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
        airport.addFlight(flight1);
        airport.addFlight(flight1);
        assertEquals(2, airport.getNumberOfFlights());
    }

    @Test
    public void startsWithNoPassengers(){
        assertEquals(0, airport.getNumberOfPassengers());
    }

    @Test
    public void canAddPassengers(){
        airport.addPassenger(passenger1);
        assertEquals(1, airport.getNumberOfPassengers());
    }

    @Test
    public void canSellTicket(){
        airport.addPassenger(passenger1);
        flight1.assignPlane(plane);
        airport.sellTicket(flight1, passenger1);
        assertEquals(1, flight1.getNumberOfPassengers());
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
        flight1.addPassenger(passenger1);
        airport.assignPlaneToFlight(flight1);
        assertEquals(2, airport.getNumberOfPlanesInHangar());
    }

    @Test
    public void canCountNumberOfPassengersOnFlights(){
        airport.addFlight(flight1);
        airport.addFlight(flight2);
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger1);
        flight2.addPassenger(passenger2);
        flight2.addPassenger(passenger2);
        assertEquals(4, airport.countPassengersOnFlights());
    }

}
