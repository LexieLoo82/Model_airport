import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFlight {

    Flight flight;
    Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.AIRBUSA380, "Emirates");
        flight = new Flight(plane,"DUB91", "Dubai", 200.00);
    }


    @Test
    public void flightHasPlane(){
        assertEquals(PlaneType.AIRBUSA380, flight.getPlaneType());
    }





}
