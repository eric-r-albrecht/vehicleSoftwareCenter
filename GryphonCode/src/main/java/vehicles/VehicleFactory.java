package vehicles;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * This is the factory for creating new vehicle objects, and central error handling for vehicle creation.
 */
public class VehicleFactory {

    /**
     * Storage HashMaps for vehicles including all and by type.
     */
    private static HashMap<Integer, Vehicle> vehicleHashMap;
    private static HashMap<Class, HashMap<Integer, Vehicle>> vehicleByTypeHashMap;

    /**
     * Gets the classes of all arguments passed in with the class.
     * @param args arguments to check.
     * @return Class array of arguments.
     */
    private static Class[] getArguments(Object[] args){
        Class[] argClasses = new Class[args.length];
        for(int i = 0; i < argClasses.length; i++){
            argClasses[i] = args[i].getClass();
        }
        return argClasses;
    }

    /**
     * This method inserts a vehicle into the all vehicle lists.
     * @param vehicle vehicle to insert into storage.
     */
    private static void insertAllVehicles(Vehicle vehicle) {
        Field[] fields = vehicle.getClass().getDeclaredFields();
        vehicleHashMap.put(vehicle.getSerialNumber(), vehicle);
    }

    /**
     * Inserts a vehicle into the typed vehicle lists.
     * @param vehicle vehicle to insert into storage.
     */
    private static void insertByTypeVehicle(Vehicle vehicle) {
        boolean foundHashMap = false;
        for(int i = 0; i < vehicleByTypeHashMap.size(); i++){
            HashMap<Integer, Vehicle> currentVehicleTypeHashMap = vehicleByTypeHashMap.get(vehicle.getClass());
            if( currentVehicleTypeHashMap != null){
                foundHashMap = true;
                currentVehicleTypeHashMap.put(vehicle.getSerialNumber(), vehicle);
            }
        }
        if(!foundHashMap){
            vehicleByTypeHashMap.put(vehicle.getClass(), new HashMap<Integer, Vehicle>());
            vehicleByTypeHashMap.get(vehicle.getClass()).put(vehicle.getSerialNumber(), vehicle);
        }
    }

    /**
     * Creates a vehicle using the class name and the provided arguments, and adds to storage.
     * @param classToMake class of object to make.
     * @param args arguments to put in the class.
     * @return object if created, null if not.
     */
    public static Vehicle createVehicle(Class classToMake, Object[] args){
        if(vehicleHashMap == null){
            vehicleHashMap = new HashMap<Integer, Vehicle>();
            vehicleByTypeHashMap = new HashMap<Class, HashMap<Integer, Vehicle>>();
        }
        Vehicle vehicle;
        Class[] argClasses = getArguments(args);
        try {
            vehicle = (Vehicle) classToMake.getConstructor(argClasses).newInstance(args);
            insertAllVehicles(vehicle);
            insertByTypeVehicle(vehicle);
            return vehicle;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }


}
