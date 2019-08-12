package vehiclePropulsion;

import static Utilities.SerialNumberGenerator.generatePropulsionSystemSerialNumber;
import static Utilities.Verification.*;

/**
 * This represents the device and characteristics used to propel the vehicle.
 */
public class PropulsionSystem {

    /**
     * Propulsion System Characteristics
     */
    private PropulsionDevice propulsionDevice;
    private long startTime;
    private int serialNumber;

    /**
     * Propulsion System Error Messages
     */
    private final static String PROPULSION_DEVICE = "Propulsion Device";
    private final static String PROPULSION_SYSTEM_START_TIME = "Propulsion System Start Time";

    /**
     * Creates new Propulsion System based on unique propulsion device.
     * @param propulsionDevice propulsion device for the propulsion system.
     */
    public PropulsionSystem(PropulsionDevice propulsionDevice){
        genericConstructor(propulsionDevice);
        this.startTime = 0;
    }

    /**
     * Creates a propulsion system with a start time in the past.
     * @param propulsionDevice device used to propel the system.
     * @param startTime starting time of the system.
     */
    public PropulsionSystem(PropulsionDevice propulsionDevice, int startTime){
        greaterThanZero(startTime, PROPULSION_SYSTEM_START_TIME);
        this.startTime = startTime;
        genericConstructor(propulsionDevice);
    }

    /**
     * Generically constructs any Propulsion System.
     * @param propulsionDevice Device used to propel the system.
     */
    public void genericConstructor(PropulsionDevice propulsionDevice){
        notNull(propulsionDevice, PROPULSION_DEVICE);
        this.propulsionDevice = propulsionDevice;
        this.serialNumber = generatePropulsionSystemSerialNumber();
    }

    /**
     * Get the serial number of the propulsion system.
     * @return serial number
     */
    public int getSerialNumber(){
        return serialNumber;
    }

    /**
     * This method gets the device object.
     * @return propulsion device object.
     */
    public PropulsionDevice getPropulsionDevice(){
        return propulsionDevice;
    }

    /**
     * Gets the device's time in operation.
     * @return time in operation to current time.
     */
    public long getTimeInOperation(){
        return System.currentTimeMillis() - startTime;
    }
}
