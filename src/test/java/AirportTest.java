import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;

    @Before
    public void before(){
        airport = new Airport(AirportReferenceType.EDI);
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

}
