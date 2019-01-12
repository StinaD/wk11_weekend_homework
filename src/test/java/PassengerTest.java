import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
    Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Emily Blunt", AirportReferenceType.INV);
//        TODO give passenger flight number
    }

    @Test
    public void canGetName(){
        assertEquals("Emily Blunt", passenger.getName());
    }

    @Test
    public void canGetDestination(){
        assertEquals("Inverness", passenger.getDestination());
    }


}
