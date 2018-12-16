import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAirport {

    Airport airport;
    Plane plane, plane1, plane2, plane3, plane4;
    Flight flight;
    Passenger passenger1, passenger2, passenger3;

    @Before
    public void before(){
        airport = new Airport("Prestwick International", "PIK", 250.00);
        plane = new Plane(PlaneType.BOEING747, "British Airways");
        plane1 = new Plane(PlaneType.DC10, "Flybe");
        plane2 = new Plane(PlaneType.JETSTREAM31, "Flybe");
        plane3 = new Plane(PlaneType.AIRBUSA380, "Emirates");
        plane4 = new Plane(PlaneType.DC10, "Flybe");
        passenger1 = new Passenger("alex", 5000);
        passenger2 = new Passenger("angus", 2000);
        passenger3 = new Passenger("abby", 6000);
        }


    @Test
    public void hangersStartEmpty(){
        assertEquals(0, airport.countPlanes());
    }

    @Test
    public void canAddPlaneToHanger(){
        airport.AddPlaneToHanger(plane1);
        airport.AddPlaneToHanger(plane2);
        airport.AddPlaneToHanger(plane3);
        airport.AddPlaneToHanger(plane4);
        assertEquals(4, airport.countPlanes());
    }



    @Test
    public void canFindPlaneinHanger(){
        airport.AddPlaneToHanger(plane1);
        airport.AddPlaneToHanger(plane2);
        airport.AddPlaneToHanger(plane3);
        airport.AddPlaneToHanger(plane4);
        assertEquals(plane4, airport.findPlaneinHanger(plane4));
    }

    @Test
    public void canRemovePlaneForFlight(){
        airport.AddPlaneToHanger(plane1);
        airport.AddPlaneToHanger(plane2);
        airport.AddPlaneToHanger(plane3);
        airport.AddPlaneToHanger(plane4);
        assertEquals(plane4, airport.removePlaneFromHangerForFlight(plane4));
    }

        @Test
    public void canCreateNewFlight(){
        airport.AddPlaneToHanger(plane1);
        airport.AddPlaneToHanger(plane2);
        airport.AddPlaneToHanger(plane3);
        airport.AddPlaneToHanger(plane4);
       flight =  airport.createFlight(plane1,"STH123", "Southend",150);
        assertEquals("Southend", flight.getDestination());
        assertEquals(3, airport.countPlanes());
    }

    @Test
    public void canSellTicketsToFlight(){
        airport.AddPlaneToHanger(plane1);
        airport.AddPlaneToHanger(plane2);
        airport.AddPlaneToHanger(plane3);
        airport.AddPlaneToHanger(plane4);
        flight =  airport.createFlight(plane1,"STH123", "Southend",150);
        airport.sellTicketForFlight(flight, passenger1);
        assertEquals(1, plane1.countPassengers());
        assertEquals(4850, passenger1.getWallet(), 1);
        assertEquals(400, airport.getBank(), 1);
    }


    @Test
    public void airportCantSellTicketsOnFullyBookedFlight(){
        airport.AddPlaneToHanger(plane1);
        flight =  airport.createFlight(plane1,"STH123", "Southend",150);
        for (int i = 0; i < 55; i++) {
            airport.sellTicketForFlight(flight, passenger1);
        }
        assertEquals(50, plane1.countPassengers());
    }





}
