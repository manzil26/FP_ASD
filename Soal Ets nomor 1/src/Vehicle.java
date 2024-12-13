public class Vehicle {
    private String vehicleType;
    private String brand;
    private String model;
    private int year;

    //Constructor
    public Vehicle(String vehicleType, String brand, String model, int year){
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // add metode getter or setter
    // if getter is return
    public String getVehicleType(){
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand){ this.brand = brand; }

    public String getModel(){ return  model; }
    public void setModel (String model){
        this.model = model;
    }

    public  int getYear(){ return year; }
    public void setYear(int year){ this.year = year; }





    public  void Start(){
        System.out.println("The" + vehicleType + " is Starting ");

    }

    public void stop() {
        System.out.println("The " + vehicleType + " is stopping ");
    }

    public void accelerate(){
        System.out.println(" The " + vehicleType + " is accelerate ");

    }

    public void brake(){
        System.out.println("The " + vehicleType + " is brake ");

    }

    public void  displayInfo(){
        System.out.println("Vehicle Type :" + vehicleType);
        System.out.println("Brand: " + brand );
        System.out.println("Model: " + model);
        System.out.println("Year: " + year );

    }



}
