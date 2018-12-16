import java.util.ArrayList;

public class Plane {
    private PlaneType type;
    private String airline;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType type, String airline){
        this.type = type;
        this.airline = airline;
        this.passengers = new ArrayList<>();
    }

    public PlaneType getType() {
        return type;
    }

    public void setType(PlaneType type) {
        this.type = type;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int countPassengers(){
        return passengers.size();
    }

    public int getCapacity() {
        return this.type.getCapacity();
    }


    public void addPassengers(Passenger passenger) {
        if (countPassengers() < getCapacity()){
        passengers.add(passenger);}
    }

    public void offloadAllPassengers() {
        passengers.clear();
    }
}
