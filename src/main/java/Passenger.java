public class Passenger {
    private String name;
    private double wallet;

    public Passenger(String name, double wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void buyticket(Flight flight) {
        double payment = flight.getPrice();
        this.wallet -= payment;
    }
}
