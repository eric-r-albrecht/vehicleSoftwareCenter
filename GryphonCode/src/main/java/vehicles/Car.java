package vehicles;

import vehiclePropulsion.PropulsionDevice;
import vehiclePropulsion.PropulsionSystem;

import static Utilities.Verification.*;

/**
 * Car definition for Vehicles
 */
public class Car extends Vehicle {

    /**
     * Car Error Messages
     */
    private static final String CAR = "Car";
    private static final String CAR_LICENSE_PLATE = "Car License Plate";


    /**
     * Vehicle Constructor Parameters
     */
    private static final String CAR_PROPULSION_DEVICE_NAME = "Typical Car Base";
    private static final int CAR_PROPULSION_DEVICE_QUANTITY = 4;

    /**
     * Car Class Variables
     */
    private String licensePlate;

    /**
     * Car Constructor using vehicle inherited constructor.
     * @param make make of the car
     * @param model model of the car
     * @param licensePlate license plate of the car
     */
    public Car(String make, String model, String vehicleIdentification, String licensePlate){
        super(new PropulsionSystem(new PropulsionDevice(PropulsionDevice.DeviceType.Wheels, CAR_PROPULSION_DEVICE_QUANTITY, CAR_PROPULSION_DEVICE_NAME)), model, make, vehicleIdentification, CAR);
        notNull(licensePlate, CAR_LICENSE_PLATE);
        this.licensePlate = licensePlate;
    }

    /**
     * get license plate of the car.
     * @return license plate.
     */
    public String getLicensePlate(){
        return licensePlate;
    }

    /**
     * Print out the full vehicle.
     * @return full vehicle printout.
     */
    public String printFullVehicle() {
        String printout = printVehicle();
        printout += CAR_LICENSE_PLATE + COLON_SPACE + licensePlate + NEWLINE;
        return printout;
    }
}
