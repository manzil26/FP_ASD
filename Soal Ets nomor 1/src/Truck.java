
// extends to acess attribute in vehicle class
// inherent
public class Truck extends Vehicle{
    public int numWheels;

    public Truck(String brand, String model, int year, int numWheels){
        super("Truck", brand, model, year);
        this.numWheels = numWheels;

    }

    public void honk(){
        System.out.println("The " + getVehicleType() + "is honk " );

    }


}
