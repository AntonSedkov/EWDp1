package test.epam.procube.service;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.service.impl.CubeServiceImpl;
import by.epam.procube.util.IdGenerator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CubeServiceImplTest {
    CubeServiceImpl service = CubeServiceImpl.getInstance();
    Cube cubeOne;
    Cube cubeTwo;

    @BeforeMethod
    public void setUp() {
        IdGenerator.setId(0);
        cubeOne = new Cube(10, new Point(10, 20, -10));
    }

    @Test
    public void testCalculateSurfaceArea() {
        double actual = service.calculateSurfaceArea(cubeOne);
        double expected = 600;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateSurfaceAreaNull() {
        double actual = service.calculateSurfaceArea(null);
        double expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateVolume() {
        double actual = service.calculateVolume(cubeOne);
        double expected = 1000;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateVolumeNull() {
        double actual = service.calculateVolume(null);
        double expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateDividedVolumeProportion() {
        double actual = service.calculateDividedVolumeProportion(cubeOne, 2);
        double expected = 0.25;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateDividedVolumeProportionNull() {
        double actual = service.calculateDividedVolumeProportion(null, 2);
        double expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testIsShapeOnCoordinatePlane() {
        boolean actual = service.isShapeOnCoordinatePlane(cubeOne);
        assertTrue(actual);
    }

    @Test
    public void testIsShapeOnCoordinatePlaneFalse() {
        cubeTwo = new Cube(155, new Point(-15, 0.55, 99));
        boolean actual = service.isShapeOnCoordinatePlane(cubeTwo);
        assertFalse(actual);
    }

    @Test
    public void testIsShapeOnCoordinatePlaneNull() {
        boolean actual = service.isShapeOnCoordinatePlane(null);
        assertFalse(actual);
    }

    @Test
    public void testIsCubeShape() {
        List<Point> vertexes = new ArrayList<>();
        vertexes.add(new Point(0, 0, 0));
        vertexes.add(new Point(10, 0, 0));
        vertexes.add(new Point(0, 10, 0));
        vertexes.add(new Point(0, 0, 10));
        vertexes.add(new Point(10, 10, 0));
        vertexes.add(new Point(10, 0, 10));
        vertexes.add(new Point(0, 10, 10));
        vertexes.add(new Point(10, 10, 10));
        boolean actual = service.isCubeShape(vertexes);
        assertTrue(actual);
    }

    @Test
    public void testIsCubeShapeFalse() {
        List<Point> vertexes = new ArrayList<>();
        vertexes.add(new Point(0, 0, 0));
        vertexes.add(new Point(100, 0, 0));
        vertexes.add(new Point(0, 103, 0));
        vertexes.add(new Point(0, 0, -10));
        vertexes.add(new Point(-10, 10, 0));
        vertexes.add(new Point(10, 0, 150));
        vertexes.add(new Point(0, -10, 10));
        vertexes.add(new Point(10, 150, 10));
        boolean actual = service.isCubeShape(vertexes);
        assertFalse(actual);
    }

    @Test
    public void testIsCubeShapeFalseTwo() {
        List<Point> vertexes = new ArrayList<>();
        vertexes.add(new Point(0, 0, 0));
        vertexes.add(new Point(10, 0, 0));
        vertexes.add(new Point(0, 10, 0));
        boolean actual = service.isCubeShape(vertexes);
        assertFalse(actual);
    }

    @Test
    public void testIsCubeShapeNull() {
        boolean actual = service.isCubeShape(null);
        assertFalse(actual);
    }

    @Test
    public void testCalculateFigureDiagonal() {
        double actual = service.calculateFigureDiagonal(cubeOne);
        double expected = 10 * Math.sqrt(3);
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateFigureDiagonalNull() {
        double actual = service.calculateFigureDiagonal(null);
        double expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateFacetDiagonal() {
        double actual = service.calculateFacetDiagonal(cubeOne);
        double expected = 10 * Math.sqrt(2);
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateFacetDiagonalNull() {
        double actual = service.calculateFacetDiagonal(null);
        double expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateVertexPoints() {
        List<Point> expected = new ArrayList<>();
        expected.add(new Point(10, 20, -10));
        expected.add(new Point(20, 20, -10));
        expected.add(new Point(10, 30, -10));
        expected.add(new Point(10, 20, 0));
        expected.add(new Point(20, 30, -10));
        expected.add(new Point(20, 20, 0));
        expected.add(new Point(10, 30, 0));
        expected.add(new Point(20, 30, 0));
        List<Point> actual = service.calculateVertexPoints(cubeOne);
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateVertexPointsNull() {
        List<Point> expected = new ArrayList<>();
        List<Point> actual = service.calculateVertexPoints(null);
        assertEquals(actual, expected);
    }

}