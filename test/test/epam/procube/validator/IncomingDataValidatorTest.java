package test.epam.procube.validator;

import by.epam.procube.validator.IncomingDataValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class IncomingDataValidatorTest {

    @Test(dataProvider = "trueIncomingData")
    public void testIsGoodLineForCubeTrue(String line) {
        boolean actual = IncomingDataValidator.isGoodLineForCube(line);
        assertTrue(actual);
    }

    @Test(dataProvider = "falseIncomingData")
    public void testIsGoodLineForCubeFalse(String line) {
        boolean actual = IncomingDataValidator.isGoodLineForCube(line);
        assertFalse(actual);
    }

    @DataProvider(name = "trueIncomingData")
    public Object[][] trueIncomingData() {
        return new Object[][]{
                {"33 66 78 89"},
                {"5.565656   -16.14     27.19      38,20"},
                {"6,99   17.15      28.18      -39.21"},
                {"7 18,16     -29.17      40.22"},
                {"9   -20 -31 -42"},
                {"0.553245465   -20,56756756 -31,532133 -42,6578867"}
        };
    }

    @DataProvider(name = "falseIncomingData")
    public Object[][] falseIncomingData() {
        return new Object[][]{
                {"Hello Java !!!"},
                {"-5.565656   -16.14     27.19      38,20"},
                {"6,99   17.15      28.18"},
                {"7 18,16     -29.17      40.22  -39.21"},
                {"0 20 31 42"},
                {"0.5532ASD45465   -20,56756756 -31,532133 -42,6578867"},
                {"0.5532ASD45465   -Jack -31,532133 -42,6578867"},
                {"0.5532ASD45465   -20,56756756 Hi -42,6578867"},
                {"0.5532ASD45465   -20,56756756 -31,532133 -55Yo"}
        };
    }

}