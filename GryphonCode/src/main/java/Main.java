import vehicles.Car;
import vehicles.Vehicle;

import static vehicles.VehicleFactory.createVehicle;

public class Main {

    public static void main(String[] args){
        String[] carparams = {"Pontiac", "G5", "123456", "XPV499"};
        Vehicle vehicle = createVehicle(Car.class, carparams);
        System.out.println(vehicle.printFullVehicle());
    }
}
