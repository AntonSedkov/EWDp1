package test.epam.procube.observer.impl;

import by.epam.procube.entity.CountedValuesCube;
import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.observer.CubeEvent;
import by.epam.procube.observer.impl.CubeObserverEdge;
import by.epam.procube.util.IdGenerator;
import by.epam.procube.warehouse.ShapeWarehouse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class CubeObserverEdgeTest {
    CubeObserverEdge observerEdge;
    CubeEvent cubeEvent;
    CountedValuesCube valuesCube;

    @BeforeMethod
    public void setUp() {
        IdGenerator.setId(0);
        ShapeWarehouse.getInstance().setCountedValuesCube(new HashMap<>());
    }

    @Test
    public void testActionPerformer() {
        observerEdge = new CubeObserverEdge();
        valuesCube = new CountedValuesCube();
        valuesCube.setSurface(600);
        valuesCube.setVolume(1000);
        valuesCube.setFacetDiagonal(14.142135623730951);
        valuesCube.setFigureDiagonal(17.32050807568877);
        cubeEvent = new CubeEvent(new Cube(10, new Point(0, 0, 0)));
        observerEdge.actionPerformer(cubeEvent);
        CountedValuesCube actual = ShapeWarehouse.getInstance().getCubeValues(1l);
        assertEquals(actual, valuesCube);
    }

}