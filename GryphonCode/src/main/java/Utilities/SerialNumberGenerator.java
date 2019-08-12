package Utilities;

public class SerialNumberGenerator {

    private static int deviceSerialNumber = 0;
    private static int systemSerialNumber = 0;
    private static int vehicleSerialNumber = 0;

    /**
     * Generates and returns a new serial number for a propulsion device.
     * @return serial number
     */
    public static synchronized int generatePropulsionDeviceSerialNumber(){
        return ++deviceSerialNumber;
    }

    /**
     * Generates and returns a new serial number for a propulsion system.
     * @return serial number
     */
    public static synchronized int generatePropulsionSystemSerialNumber(){
        return ++systemSerialNumber;
    }

    /**
     * Generates and returns a new serial number for a propulsion system.
     * @return serial number
     */
    public static synchronized int generateVehicleSerialNumber(){
        return ++vehicleSerialNumber;
    }

}
