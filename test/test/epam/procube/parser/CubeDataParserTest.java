package test.epam.procube.parser;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.parser.CubeDataParser;
import by.epam.procube.util.IdGenerator;
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
    public void testParseCubes(List<String> incomingData, List<Cube> expected, long startId) {
        IdGenerator.setId(startId);
        List<Cube> actual = cubeParser.parseCubes(incomingData);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForParser")
    public Object[][] dataForParser() {
        Cube one = new Cube(5, new Point(10, 20, 30));
        Cube two = new Cube(55, new Point(-10, -20, -30));
        Cube three = new Cube(5.55, new Point(10.98, 20.45, 30.223));
        Cube four = new Cube(55.55555, new Point(-10.98, 20.45, 30.223));
        Cube five = new Cube(77.574, new Point(10.98, -20.45, 30.223));
        Cube six = new Cube(65, new Point(-10.98, -20.45, -30.223));
        List<Cube> cubesOne = new ArrayList<>();
        cubesOne.add(one);
        cubesOne.add(two);
        cubesOne.add(three);
        List<Cube> cubesTwo = new ArrayList<>();
        cubesTwo.add(four);
        cubesTwo.add(five);
        cubesTwo.add(six);
        List<Cube> cubesFour = new ArrayList<>();
        cubesFour.add(one);
        cubesFour.add(two);
        cubesFour.add(three);
        cubesFour.add(four);
        cubesFour.add(five);
        cubesFour.add(six);
        List<String> stringOne = new ArrayList<>();
        stringOne.add("5 10 20 30");
        stringOne.add("55 -10 -20 -30");
        stringOne.add("5.55 10.98 20.45 30.223");
        List<String> stringTwo = new ArrayList<>();
        stringTwo.add("55.55555     -10.98      20.45       30.223");
        stringTwo.add("77.574      10.98       -20.45      30.223");
        stringTwo.add("65                   -10.98 -20.45     -30.223");
        List<String> stringFour = new ArrayList<>();
        stringFour.add("5 10 20 30");
        stringFour.add("55 -10 -20 -30");
        stringFour.add("5.55 10.98 20.45 30.223");
        stringFour.add("55.55555     -10.98      20.45       30.223");
        stringFour.add("77.574      10.98       -20.45      30.223");
        stringFour.add("65                   -10.98 -20.45     -30.223");
        return new Object[][]{
                {stringOne, cubesOne, 0}, {stringTwo, cubesTwo, 3}, {stringFour, cubesFour, 0}
        };
    }

}