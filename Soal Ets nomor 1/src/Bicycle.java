public class Bicycle extends Vehicle {
    private int numGears;

    public Bicycle(String brand, String model, int year, int numGears){
        super("Bicycle", brand, model, year);
        this.numGears = numGears;

    }

    public int getNumGears(int numGears){
        return numGears;
    }

    public void setNumGears(){
        this.numGears = numGears;
    }
    public void ringBell(){
        System.out.println("This " + getVehicleType() + " is ringing its bell ");
    }
}
