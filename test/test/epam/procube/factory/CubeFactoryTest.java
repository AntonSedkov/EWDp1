package test.epam.procube.factory;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.factory.CubeFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CubeFactoryTest {
    CubeFactory cubeFactory = new CubeFactory();

    @Test
    public void testCreateInstance() {
        Cube actual = cubeFactory.createInstance(new String[]{"10", "20", "-50", "100"});
        Cube expected = new Cube();
        expected.setId(1);
        expected.setEdge(10);
        expected.setStartPoint(new Point(20, -50, 100));
        assertEquals(actual, expected);
    }

    @Test
    public void testCreateInstanceNull() {
        Cube actual = cubeFactory.createInstance(null);
        Cube expected = null;
        assertEquals(actual, expected);
    }
}