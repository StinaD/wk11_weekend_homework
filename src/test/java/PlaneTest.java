import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING_747, "Easyjet", 101);
    }

    @Test
    public void startsWithNoPassengers(){
        assertEquals(0, plane.getNumberOfPassengers());
    }

    @Test
    public void hasPlaneType(){
        assertEquals(PlaneType.BOEING_747, plane.getPlaneType());
    }

    @Test
    public void hasAirline(){
        assertEquals("Easyjet", plane.getAirline());
    }

    @Test
    public void hasUniqueIdentifier(){
        assertEquals(101, plane.getUniqueIdentifier());
    }
}
