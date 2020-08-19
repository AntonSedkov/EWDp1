package test.epam.procube.observer.impl;

import by.epam.procube.entity.CountedValuesCube;
import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.observer.CubeEvent;
import by.epam.procube.observer.impl.CubeObserverPoint;
import by.epam.procube.entity.ShapeWarehouse;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CubeObserverPointTest {

    CubeObserverPoint observerPoint;
    CubeEvent cubeEvent;
    CountedValuesCube valuesCube;

    @Test
    public void testActionPerformer() {
        observerPoint = new CubeObserverPoint();
        valuesCube = new CountedValuesCube();
        List<Point> vertexes = new ArrayList<>();
        vertexes.add(new Point(0, 0, 0));
        vertexes.add(new Point(10, 0, 0));
        vertexes.add(new Point(0, 10, 0));
        vertexes.add(new Point(0, 0, 10));
        vertexes.add(new Point(10, 10, 0));
        vertexes.add(new Point(10, 0, 10));
        vertexes.add(new Point(0, 10, 10));
        vertexes.add(new Point(10, 10, 10));
        valuesCube.setVertexes(vertexes);
        cubeEvent = new CubeEvent(new Cube(10, new Point(0, 0, 0)));
        observerPoint.actionPerformer(cubeEvent);
        CountedValuesCube actual = ShapeWarehouse.getInstance().getCubeValues(1l);
        assertEquals(actual, valuesCube);
    }
}