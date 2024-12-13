public class Main {
    public static void main(String[] args) {
        // polymorphism
        Vehicle v = new Truck("toyota");
        v.setVehicleType("Truck ");
        v.setBrand("Toyota");
        v.setModel("Hilux ");
        v.setYear(2021);
        v.displayInfo();
        v.Start();

//        // create objek inherented from vehicle
//       Truck truck = new Truck() ;
//       truck.setVehicleType("Truck");
//       truck.setBrand("Ford ");
//       truck.setModel("F-150");
//       truck.setYear(2023);
//
//       // set truck specified propertiy
//       truck.numWheels = 6;
//
//       // use methods inherited from vehicle
//        truck.Start();
//        truck.accelerate();
//        truck.brake();
//        truck.stop();
//
//        // use Truck- specified method
//        truck.honk();

//        // Set properties inherited from Vehicle
//        Bicycle b = new Bicycle();
//        b.setVehicleType("Truck");
//        b.setBrand("Ford ");
//        b.setModel("F-150");
//        b.setYear(2023);
//
//        // Set Bicycle-specific property
//        b.getNumGears(22);
//
//        // Use Bicycle-specific method
//        b.ringBell();
//
//
//        // Use Vehicle methods (inherited)
//        b.Start();
//        b.stop();
//        b.brake();
//        b.stop();

    }
}