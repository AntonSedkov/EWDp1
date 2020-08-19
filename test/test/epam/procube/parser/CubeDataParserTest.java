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
    public void testParseCubes(List<String> incomingData, List<List<String>> expected) {
        List<List<String>> actual = cubeParser.parseCubes(incomingData);
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
        List<String> stringOne = new ArrayList<>();
        stringOne.add("5");
        stringOne.add("10");
        stringOne.add("20");
        stringOne.add("30");
        List<String> stringTwo = new ArrayList<>();
        stringTwo.add("77.574");
        stringTwo.add("10.98");
        stringTwo.add("-20.45");
        stringTwo.add("30.223");
        List<List<String>> cubesOne = new ArrayList<>();
        cubesOne.add(stringOne);
        cubesOne.add(stringTwo);
        List<List<String>> cubesTwo = new ArrayList<>();
        cubesTwo.add(stringTwo);
        cubesTwo.add(stringOne);
        return new Object[][]{
                {stringsOne, cubesOne}, {stringsTwo, cubesTwo}
        };
    }

}