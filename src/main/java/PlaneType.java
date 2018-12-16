public enum PlaneType {
    BOEING747(85),
    AIRBUSA380(200),
    DC10(50),
    JETSTREAM31(19);

    private final int capacity;

    PlaneType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){ return capacity;}
}
