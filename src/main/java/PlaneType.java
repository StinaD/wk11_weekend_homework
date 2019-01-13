public enum PlaneType {
    BOEING_747(3),
    BOEING_DREAMLINER(4),
    AIRBUS_A300(5);

    private int capacity;


    PlaneType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity;
    }


}
