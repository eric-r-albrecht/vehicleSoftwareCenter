package vehicles;

import vehiclePropulsion.PropulsionSystem;

import static Utilities.SerialNumberGenerator.generateVehicleSerialNumber;
import static Utilities.Verification.*;

/**
 * Base Class for vehicles constructed.
 */
public abstract class Vehicle {

    /**
     * Vehicle Error Messages
     */
    private static final String VEHICLE = "Vehicle";
    private static final String VEHICLE_PRINTOUT_INITIAL_LINE = "Vehicle Info\n------------\n";
    private static final String VEHICLE_PROPULSION_SYSTEM = "Propulsion System";
    private static final String VEHICLE_MODEL = "Model";
    private static final String VEHICLE_MAKE = "Make";
    private static final String VEHICLE_VIN = "Identification Number";
    private static final String VEHICLE_SERIAL_NUMBER = "Serial Number";
    private static final String VEHICLE_TYPE_NAME = "Type Name";
    protected static final String SPACE = " ";
    protected static final String COLON_SPACE = ": ";
    protected static final String NEWLINE = "\n";

    /**
     * Vehicle Class Variables
     */
    private PropulsionSystem propulsionSystem;
    private String model;
    private String make;
    private String vehicleIdentification;
    private String vehicleTypeName;
    protected int serialNumber;

    /**
     * Default constructor for a vehicle, defining propulsion system
     * @param propulsionSystem propulsion system for vehicle
     */
    public Vehicle(PropulsionSystem propulsionSystem, String model, String make, String vehicleIdentification, String vehicleTypeName) {
        notNull(vehicleTypeName, VEHICLE_TYPE_NAME);
        notNull(propulsionSystem, vehicleTypeName + VEHICLE_PROPULSION_SYSTEM);
        notNull(model, vehicleTypeName + VEHICLE_MODEL);
        notNull(make, vehicleTypeName + VEHICLE_MAKE);
        notNull(vehicleIdentification, vehicleTypeName + VEHICLE_VIN);
        this.vehicleTypeName = vehicleTypeName;
        this.propulsionSystem = propulsionSystem;
        this.model = model;
        this.vehicleIdentification = vehicleIdentification;
        this.make = make;
        this.serialNumber = generateVehicleSerialNumber();
    }

    /**
     * Get the vehicle model.
     * @return vehicle model.
     */
    public String getVehicleModel(){
        return model;
    }

    /**
     * Get the vehicle make.
     * @return vehicle make.
     */
    public String getVehicleMake(){
        return make;
    }

    /**
     * Get the vehicle identification number.
     * @return vehicle identification number.
     */
    public String getVehicleVin(){
        return vehicleIdentification;
    }

    /**
     * Get the vehicle type name.
     * @return vehicle type name.
     */
    public String getVehicleTypeName(){
        return vehicleTypeName;
    }

    /**
     * Get the vehicle propulsion system.
     * @return vehicle propulsion system.
     */
    public PropulsionSystem getPropulsionSystem(){
        return propulsionSystem;
    }

    /**
     * Get the serial number of the vehicle.
     * @return serial number.
     */
    public int getSerialNumber(){
        return serialNumber;
    }

    /**
     * Print out all the vehicle information that is common.
     * @return common vehicle printout
     */
    public String printVehicle(){
        String printout = VEHICLE_PRINTOUT_INITIAL_LINE;
        printout += VEHICLE + SPACE + VEHICLE_TYPE_NAME + COLON_SPACE + vehicleTypeName + NEWLINE;
        printout += VEHICLE + SPACE + VEHICLE_SERIAL_NUMBER + COLON_SPACE + serialNumber + NEWLINE;
        printout += VEHICLE + SPACE + VEHICLE_VIN + COLON_SPACE + vehicleIdentification + NEWLINE;
        printout += VEHICLE + SPACE + VEHICLE_MAKE + COLON_SPACE + make + NEWLINE;
        printout += VEHICLE + SPACE + VEHICLE_MODEL + COLON_SPACE + model + NEWLINE;
        printout += VEHICLE + SPACE + VEHICLE_PROPULSION_SYSTEM + COLON_SPACE + propulsionSystem.getSerialNumber() + NEWLINE;
        return printout;
    }

    /**
     * This prints out the rest of the unique car information.
     * @return all car information.
     */
    public abstract String printFullVehicle();

}
