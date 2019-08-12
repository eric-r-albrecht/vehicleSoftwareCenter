package Utilities;

import java.lang.reflect.InvocationTargetException;

public class Verification {

    enum ErrorType{
        NONE,
        NULL,
        NEGATIVE,
        NEGATIVE_OR_ZERO,
        POSITIVE,
        POSITIVE_OR_ZERO
    }

    private final static int EMPTY = 0;

    //Compounds for error messages
    private final static String OR = " or ";
    private final static String AND = " and ";

    //Error messages that match up to the ErrorType
    private final static String NO_ERROR = "";
    private final static String NULL = " can't be null!";
    private final static String DEFAULT = " there should be an error message here";
    private final static String ZERO = "can't be zero!";
    private final static String NEGATIVE = " can't be negative!";
    private final static String NEGATIVE_OR_ZERO = NEGATIVE + OR + ZERO;
    private final static String POSITIVE = " can't be positive!";
    private final static String POSITIVE_OR_ZERO = POSITIVE + OR + ZERO;

    /**
     * This method creates the required error messages based on the enum ErrorType
     * @param varName name of variable being checked
     * @param errorType type of error found.
     * @return String containing the error message
     */
    private static void throwErrorMessage(String varName, ErrorType errorType){
        if(errorType == ErrorType.NONE){
            throw new IllegalArgumentException(NO_ERROR);
        } else if(errorType == ErrorType.NULL){
            throw new IllegalArgumentException(varName + NULL);
        } else if(errorType == ErrorType.NEGATIVE){
            throw new IllegalArgumentException(varName + NEGATIVE);
        } else if(errorType == ErrorType.POSITIVE){
            throw new IllegalArgumentException(varName + POSITIVE);
        } else if(errorType == ErrorType.NEGATIVE_OR_ZERO) {
            throw new IllegalArgumentException(varName + NEGATIVE_OR_ZERO);
        } else if(errorType == ErrorType.POSITIVE_OR_ZERO) {
            throw new IllegalArgumentException(varName + POSITIVE_OR_ZERO);
        }
        throw new IllegalArgumentException(DEFAULT);
    }

    /**
     * This method verifies that any object is not null.
     * @param object object to check if null
     * @return
     */
    public static void notNull(Object object, String varName){
        if(object == null || (object.getClass() == String.class && ((String) object).length() == EMPTY )){
            throwErrorMessage(varName, ErrorType.NULL);
        }
    }

    /**
     * This verifies that any number is above 0.
     * @param number number to check
     * @param varName name of variable
     * @return possible error message
     */
    public static void greaterThanZero(Number number, String varName){
        if(number.doubleValue() <= 0) {
            throwErrorMessage(varName, ErrorType.NEGATIVE_OR_ZERO);
        }
    }

    /**
     * This method verifies that the number is less than zero.
     * @param number number to check
     * @param varName name of variable
     * @return error message
     */
    public static void lessThanZero(Number number, String varName){
        if(number.doubleValue() >= 0) {
            throwErrorMessage(varName, ErrorType.POSITIVE_OR_ZERO);
        }
    }

    /**
     * This method verifies that the number is less than or equal to zero.
     * @param number number to check
     * @param varName name of variable
     * @return error message
     */
    public static void lessThanOrEqualToZero(Number number, String varName){
        if(number.doubleValue() > 0){
            throwErrorMessage(varName, ErrorType.POSITIVE);
        }
    }

    /**
     * This method verifies that the number is greater than or equal to zero.
     * @param number
     * @param varName
     */
    public static void greaterThanOrEqualToZero(Number number, String varName){
        if(number.doubleValue() < 0){
            throwErrorMessage(varName, ErrorType.NEGATIVE);
        }
    }

    /**
     * Throw a custom specified exception with the esp
     * @param exceptionClass object class of exception to be thrown.
     * @param message message for exception
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public static void throwCustomException(Class exceptionClass, String message) throws IllegalAccessException, NoSuchMethodException {
        try {
            Exception exception = (Exception) exceptionClass.getConstructor(exceptionClass).newInstance(message);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Exception could not be created!");
        } catch (IllegalAccessException e) {
            throw new IllegalAccessException("Constructor could not be accessed!");
        } catch (InvocationTargetException e) {
            throw new IllegalAccessException("Should really figure out what InvocationTargetException does");
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodException("No constructor exists for the given exception!");
        }
    }
}
