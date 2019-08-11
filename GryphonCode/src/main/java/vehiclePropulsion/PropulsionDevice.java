package vehiclePropulsion;

import static Utilities.SerialNumberGenerator.*;
import static Utilities.Verification.*;

/**
 * This class represents devices used in the propulsion system, based on the enum DeviceType.
 */
public class PropulsionDevice {

    enum DeviceType
    {
        Rotor,
        Wheels
    }

    /**
     * Error Message Names for the Central Error Handling
     */
    private final static String PROPULSION_DEVICE_TYPE = "Propulsion Device Type";
    private final static String PROPULSION_DEVICE_QUANTITY = "Propulsion Device Quantity";
    private final static String PROPULSION_DEVICE_NAME = "Propulsion Device Name";
    private final static String PROPULSION_DEVICE_START_TIME = "Propulsion Device Start Time";

    /**
     * Basic Propulsion Device Characteristics
     */
    private DeviceType deviceType;
    private int deviceQuantity;
    private String name;
    private int serialNumber;
    private long startTime;

    /**
     * This creates a Propulsion Device that starts it registration time at creation.
     * @param deviceType type of device being used, based on enum.
     * @param deviceQuantity number of device being used.
     * @param name name of the device
     */
    public PropulsionDevice(DeviceType deviceType, int deviceQuantity, String name){
        genericConstruction(deviceType, deviceQuantity, name);
        this.startTime = System.currentTimeMillis();
    }

    /**
     * Creates a Propulsion Device that starts registration time at a specified time.
     * @param deviceType type of device being used, based on enum.
     * @param deviceQuantity number of device being used.
     * @param name name of the device
     * @param startTime starting time of the device
     */
    public PropulsionDevice(DeviceType deviceType, int deviceQuantity, String name, long startTime){
        genericConstruction(deviceType, deviceQuantity, name);
        greaterThanZero(startTime, PROPULSION_DEVICE_START_TIME);
        this.startTime = startTime;
    }

    /**
     * This is a generic construction method for the constructors.
     * @param deviceType type of device being used, based on enum.
     * @param deviceQuantity number of device being used.
     * @param name name of the device.
     */
    public void genericConstruction(DeviceType deviceType, int deviceQuantity, String name){
        notNull(deviceType, PROPULSION_DEVICE_TYPE);
        greaterThanOrEqualToZero(deviceQuantity, PROPULSION_DEVICE_QUANTITY);
        notNull(name, PROPULSION_DEVICE_NAME);
        this.deviceQuantity = deviceQuantity;
        this.deviceType = deviceType;
        this.name = name;
        this.serialNumber = generatePropulsionDeviceSerialNumber();
    }

    /**
     * Gets the device type
     * @return device type
     */
    public DeviceType getDeviceType(){
        return deviceType;
    }

    /**
     * Gets the quantity of the propulsion device.
     * @return quantity of propulsion devices.
     */
    public int getDeviceQuantity(){
        return deviceQuantity;
    }

    /**
     * Gets the serial number of the device.
     * @return serial number of device.
     */
    public int getSerialNumber(){
        return serialNumber;
    }

    /**
     * Gets the name of the device.
     * @return name of device.
     */
    public String getDeviceName(){
        return name;
    }

    /**
     * This gets the start time of the device.
     * @return start time of the device.
     */
    public long getStartTime(){
        return startTime;
    }

    /**
     * This gets how long the device has been in operation.
     * @return operational time based on starting time.
     */
    public long getOperationTime(){
        return System.currentTimeMillis() - startTime;
    }
}
