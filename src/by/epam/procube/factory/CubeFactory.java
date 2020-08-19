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
    public Cube createInstance(List<String> lines) {
        Cube cube = null;
        if (lines != null && lines.size() == QUANTITY_PARAMETERS) {
            cube = new Cube(Double.parseDouble(lines.get(0)),
                    new Point(Double.parseDouble(lines.get(1)), Double.parseDouble(lines.get(2)), Double.parseDouble(lines.get(3))));
            cube.attach(new CubeObserverEdge());
            cube.attach(new CubeObserverPoint());
            cube.notifyObservers();
            cube.detachAllObservers();
        }
        return cube;
    }

    @Override
    public List<Cube> createAllCubes(List<List<String>> cubes) {
        List<Cube> cubesList = new ArrayList<>();
        for (List<String> cube : cubes) {
            cubesList.add(createInstance(cube));
        }
        return cubesList;
    }
}
