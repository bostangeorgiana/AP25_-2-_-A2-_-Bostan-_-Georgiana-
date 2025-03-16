public abstract class Aircraft implements Comparable<Aircraft>{
    protected String name;
    protected int tailNumber;
    protected String model;

    public Aircraft(String name, int tailNumber, String model) {
        this.name = name;
        this.tailNumber = tailNumber;
        this.model = model;
    }

    public String getName(){
        return name;
    }
    public int getTailNumber(){
        return tailNumber;
    }
    public String getModel(){
        return model;
    }

    public void setTailNumber(int tailNumber){
        this.tailNumber = tailNumber;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setModel(String model){
        this.model = model;
    }

    @Override
    public String toString(){
        return "Aircraft{name='" + name + "', tailNumber='" + tailNumber + "'}";
    }

    @Override
    public int compareTo(Aircraft other) {
        return name.compareTo(other.name);
    }
}

class Airliner extends Aircraft implements PassengerCapable{
    private int passengerCapacity;

    Airliner(String name, int tailNumber, String model, int passengerCapacity){
        super(name, tailNumber, model);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public void setPassengerCapacity(int passengerCapacity){
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return "Airliner{name='" + name + "', tailNumber='" + tailNumber + "', passengerCapacity=" + passengerCapacity + "}";
    }
}

class Freighter extends Aircraft implements CargoCapable{
    private double maxPayload;

    public Freighter(String name, int tailNumber, String model, double maxPayload){
        super(name, tailNumber, model);
        this.maxPayload = maxPayload;
    }

    @Override
    public double getMaxPayload(){
        return maxPayload;
    }
    @Override
    public void setMaxPayload(double maxPayload){
        this.maxPayload = maxPayload;
    }

    @Override
    public String toString() {
        return "Freighter{name='" + name + "', tailNumber='" + tailNumber + "', maxPayload=" + maxPayload + " kg}";
    }
}

class Drone extends Aircraft implements CargoCapable{

    private double batteryLife;
    private double maxPayload;

    public Drone(String name, int tailNumber, String model, double maxPayload){
        super(name, tailNumber, model);
        this.maxPayload = maxPayload;
    }

    public double getBatteryLife(){
        return batteryLife;
    }
    public void setBatteryLife(double batteryLife){
        this.batteryLife = batteryLife;
    }

    @Override
    public double getMaxPayload(){
        return maxPayload;
    }
    @Override
    public void setMaxPayload(double maxPayload){
        this.maxPayload = maxPayload;
    }

    @Override
    public String toString() {
        return "Drone{name='" + name + "', tailNumber='" + tailNumber + "', batteryLife=" + batteryLife + "h, maxPayload=" + maxPayload + " kg}";
    }
}

interface PassengerCapable {
    int getPassengerCapacity();
    void setPassengerCapacity(int passengerCapacity);
}

interface CargoCapable {
    double getMaxPayload();
    void setMaxPayload(double maxPayload);
}

