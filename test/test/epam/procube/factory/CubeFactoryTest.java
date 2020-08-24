package test.epam.procube.factory;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.factory.CubeFactory;
import by.epam.procube.util.IdGenerator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CubeFactoryTest {
    CubeFactory cubeFactory = new CubeFactory();
    List<Double> cubeOne;
    List<Double> cubeTwo;
    List<List<Double>> cubesString;
    Cube expectedOne;
    Cube expectedTwo;
    List<Cube> cubes;

    @BeforeMethod
    public void setUp() {
        IdGenerator.setId(0);
        cubeOne = new ArrayList<>();
        cubeOne.add(10.);
        cubeOne.add(20.);
        cubeOne.add(-50.);
        cubeOne.add(100.);
        cubeTwo = new ArrayList<>();
        cubeTwo.add(25.);
        cubeTwo.add(-120.);
        cubeTwo.add(-68.);
        cubeTwo.add(333.);
        cubesString = new ArrayList<>();
        cubesString.add(cubeOne);
        cubesString.add(cubeTwo);
        cubes = new ArrayList<>();
    }

    @Test
    public void testCreateInstance() {
        Cube actual = cubeFactory.createInstance(cubeOne);
        expectedOne = new Cube();
        expectedOne.setId(1);
        expectedOne.setEdge(10);
        expectedOne.setStartPoint(new Point(20, -50, 100));
        assertEquals(actual, expectedOne);
    }

    @Test
    public void testCreateInstanceNull() {
        Cube actual = cubeFactory.createInstance(null);
        Cube expected = null;
        assertEquals(actual, expected);
    }

    @Test
    public void testCreateAllCubes() {
        List<Cube> actual = cubeFactory.createAllCubes(cubesString);
        expectedOne = new Cube();
        expectedOne.setId(1);
        expectedOne.setEdge(10);
        expectedOne.setStartPoint(new Point(20, -50, 100));
        expectedTwo = new Cube();
        expectedTwo.setId(2);
        expectedTwo.setEdge(25);
        expectedTwo.setStartPoint(new Point(-120, -68, 333));
        cubes.add(expectedOne);
        cubes.add(expectedTwo);
        assertEquals(actual, cubes);
    }

}