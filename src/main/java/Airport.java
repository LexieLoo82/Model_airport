import java.util.ArrayList;

public class Airport {
    private String name;
    private String code;
    private ArrayList<Plane> hangers;
    private double bank;

    public Airport(String name, String code, double bank){
        this.name = name;
        this.code = code;
        this.hangers = new ArrayList<>();
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Plane> getHangers() {
        return hangers;
    }

    public void setHangers(ArrayList<Plane> hangers) {
        this.hangers = hangers;
    }

    public double getBank() {
        return bank;
    }

    public void setBank(double bank) {
        this.bank = bank;
    }


    public int countPlanes() {
       return this.hangers.size();
    }

    public void AddPlaneToHanger(Plane plane) {
        this.hangers.add(plane);
    }


    public Plane findPlaneinHanger(Plane plane) {
        int planeToFind = this.hangers.indexOf(plane);
        return this.hangers.get(planeToFind);
    }

    public Plane removePlaneFromHangerForFlight(Plane plane) {
        findPlaneinHanger(plane);
        this.hangers.remove(plane);
        return plane;
    }

    public Flight createFlight(Plane plane, String flightnumber, String destination, double price) {
       Plane planeforFlight = removePlaneFromHangerForFlight(plane);
        Flight flight = new Flight(planeforFlight, flightnumber, destination, price);
        return flight;
    }


    public void sellTicketForFlight(Flight flight, Passenger passenger) {
        flight.plane.addPassengers(passenger);
        passenger.buyticket(flight);
        this.bank += flight.getPrice();
    }
}
