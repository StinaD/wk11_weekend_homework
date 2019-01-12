import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FlightTest {
    Flight flight;
    Plane plane;
    Passenger passenger;


    @Before
    public void before(){
        flight = new Flight("AB123", AirportReferenceType.INV, 1400, 1500);
        plane = new Plane(PlaneType.BOEING_747, "Ryanair", 123);
        passenger = new Passenger("Judy Dench", AirportReferenceType.INV);
    }

    @Test
    public void hasFlightNumber(){
        assertEquals("AB123", flight.getFlightNumber());
    }

    @Test
    public void hasDestination(){
        assertEquals("Inverness", flight.getDestination());
    }

    @Test
    public void hasDepartureTime(){
        assertEquals(1400, flight.getDepartureTime());
    }

    @Test
    public void hasArrivalTime(){
        assertEquals(1500, flight.getArrivalTime());
    }

    @Test
    public void startsWithNoPlaneAssigned(){
        assertNull(flight.getAssignedPlane());
    }

    @Test
    public void canSetPlane(){
        flight.assignPlane(plane);
        assertEquals(123, flight.getAssignedPlane().getUniqueIdentifier());
    }

    @Test
    public void startsWithNoPassengers(){
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    public void canAddPassengers(){
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        assertEquals(2, flight.getNumberOfPassengers());
    }

    @Test
    public void canGetPlane(){
        flight.assignPlane(plane);
        assertEquals(PlaneType.BOEING_747, flight.getPlaneType());
    }

}

