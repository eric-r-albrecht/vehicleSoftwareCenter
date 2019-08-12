package vehicles;

import vehiclePropulsion.PropulsionSystem;

import static Utilities.Verification.*;

/**
 * Base Class for vehicles constructed.
 */
public abstract class Vehicle {

    /**
     * Vehicle Error Messages
     */
    private static final String VEHICLE_PROPULSION_SYSTEM = "Propulsion System";
    private static final String VEHICLE_MODEL = "Model";
    private static final String VEHICLE_MAKE = " Make";
    private static final String VEHICLE_VIN = " Identification Number";
    private static final String VEHICLE_TYPE_NAME = "Vehicle Type Name";

    /**
     * Vehicle Class Variables
     */
    private PropulsionSystem propulsionSystem;
    private String model;
    private String make;
    private String vehicleIdentification;
    private String vehicleTypeName;

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

}
