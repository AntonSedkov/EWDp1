package by.epam.procube.validator;

public class IncomingDataValidator {
    private static final String CUBE_DATA_REGEXP = "^(([0]{1}[\\.\\,]{1}\\d+)|([1-9]\\d*[\\.\\,]?\\d*))(\\s+([\\-]?\\d+[\\.\\,]?\\d+)){3}$";

    public static boolean isGoodLineForCube(String line) {
        boolean result = line.matches(CUBE_DATA_REGEXP);
        return result;
    }

}