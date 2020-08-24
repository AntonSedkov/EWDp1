package test.epam.procube.parser;

import by.epam.procube.parser.CubeDataParser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CubeDataParserTest {
    CubeDataParser cubeParser;

    @BeforeMethod
    public void setUp() {
        cubeParser = new CubeDataParser();
    }

    @Test(dataProvider = "dataForParser")
    public void testParseCubes(List<String> incomingData, List<List<Double>> expected) {
        List<List<Double>> actual = cubeParser.parseCubes(incomingData);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForParser")
    public Object[][] dataForParser() {
        List<String> stringsOne = new ArrayList<>();
        stringsOne.add("5 10 20 30");
        stringsOne.add("123 3243 32434 0944 3242 243");
        stringsOne.add("-2222     99 88 564");
        stringsOne.add("33 ew33 w333 009");
        stringsOne.add("77.574          10.98  -20.45     30.223");
        List<String> stringsTwo = new ArrayList<>();
        stringsTwo.add("Hello Java!!!");
        stringsTwo.add("   ");
        stringsTwo.add("77.574          10.98  -20.45     30.223");
        stringsTwo.add("11     77ek ");
        stringsTwo.add("5 10 20 30");
        List<Double> doubleOne = new ArrayList<>();
        doubleOne.add(5.);
        doubleOne.add(10.);
        doubleOne.add(20.);
        doubleOne.add(30.);
        List<Double> doubleTwo = new ArrayList<>();
        doubleTwo.add(77.574);
        doubleTwo.add(10.98);
        doubleTwo.add(-20.45);
        doubleTwo.add(30.223);
        List<List<Double>> cubesOne = new ArrayList<>();
        cubesOne.add(doubleOne);
        cubesOne.add(doubleTwo);
        List<List<Double>> cubesTwo = new ArrayList<>();
        cubesTwo.add(doubleTwo);
        cubesTwo.add(doubleOne);
        return new Object[][]{
                {stringsOne, cubesOne}, {stringsTwo, cubesTwo}
        };
    }

}