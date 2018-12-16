import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlane {

    Plane plane;
    Passenger passenger;

    @Before
    public void before(){
        plane = new Plane(PlaneType.AIRBUSA380, "Emirates");
        passenger = new Passenger("steve", 300.00);
    }

    @Test
    public void planeShouldStartEmpty(){
        assertEquals(0, plane.countPassengers());
    }

    @Test
    public void canGetPlaneCapacity(){
        assertEquals(200, plane.getCapacity());
    }

    @Test
    public void canAddPassengersToPlane(){
        plane.addPassengers(passenger);
        assertEquals(1, plane.countPassengers());
    }

    @Test
    public void canOffloadAllPassengers(){
        plane.addPassengers(passenger);
        plane.offloadAllPassengers();
        assertEquals(0, plane.countPassengers());
    }

    @Test
    public void cantAddPastCapacity(){
        for (int i = 0; i < 250; i++) {
            plane.addPassengers(passenger);
        }
        assertEquals(200, plane.countPassengers());
    }


}
