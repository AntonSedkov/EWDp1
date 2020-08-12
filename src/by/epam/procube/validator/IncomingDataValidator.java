package by.epam.procube.validator;

public class IncomingDataValidator {

    private static final int QUANTITY_ELEMENTS_CUBE = 4;
    private static final String  CUBE_DATA_REGEXP = String.format("^-*(?=\\d+.\\d+ ){%d}",QUANTITY_ELEMENTS_CUBE);

    public static boolean isGoodLineForCube(String line){
        boolean result = line.matches(CUBE_DATA_REGEXP);
        return result;
    }

}