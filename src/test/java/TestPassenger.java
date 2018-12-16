import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPassenger {
    Passenger passenger;
    Flight flight;
    Plane plane;

    @Before
    public void before(){
        passenger = new Passenger("steve", 300.00);
        plane = new Plane(PlaneType.JETSTREAM31, "flybe");
        flight = new Flight(plane, "AB12", "Manchester", 150);
    }

    @Test
    public void canGetName(){
        assertEquals("steve", passenger.getName());
    }

    @Test
    public void canBuyTicketForFlight(){
        passenger.buyticket(flight);
        assertEquals(150.00, passenger.getWallet(), 1);
    }


}
