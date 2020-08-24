package by.epam.procube.factory;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.observer.impl.CubeObserverEdge;
import by.epam.procube.observer.impl.CubeObserverPoint;

import java.util.ArrayList;
import java.util.List;

public class CubeFactory extends AbstractShapeFactory<Cube> {
    private static final int QUANTITY_PARAMETERS = 4;

    @Override
    public Cube createInstance(List<Double> lines) {
        Cube cube = null;
        if (lines != null && lines.size() == QUANTITY_PARAMETERS) {
            cube = new Cube(lines.get(0),
                    new Point(lines.get(1), lines.get(2), lines.get(3)));
            CubeObserverEdge observerEdge = new CubeObserverEdge();
            CubeObserverPoint observerPoint = new CubeObserverPoint();
            cube.attach(observerEdge);
            cube.attach(observerPoint);
            cube.notifyObservers();
        }
        return cube;
    }

    @Override
    public List<Cube> createAllCubes(List<List<Double>> cubes) {
        List<Cube> cubesList = new ArrayList<>();
        for (List<Double> cube : cubes) {
            cubesList.add(createInstance(cube));
        }
        return cubesList;
    }

}