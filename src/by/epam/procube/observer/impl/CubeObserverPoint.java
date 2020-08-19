package by.epam.procube.observer.impl;

import by.epam.procube.entity.CountedValuesCube;
import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.observer.CubeEvent;
import by.epam.procube.observer.Observer;
import by.epam.procube.service.impl.CubeServiceImpl;
import by.epam.procube.entity.ShapeWarehouse;

import java.util.List;

public class CubeObserverPoint implements Observer<CubeEvent> {
    @Override
    public void actionPerformer(CubeEvent cubeEvent) {
        Cube cube = cubeEvent.getSource();
        long id = cube.getId();
        CountedValuesCube valuesCube = ShapeWarehouse.getInstance().getCubeValues(id);
        if (valuesCube == null) {
            valuesCube = new CountedValuesCube();
        }
        List<Point> vertexes = CubeServiceImpl.getInstance().calculateVertexPoints(cube);
        valuesCube.setVertexes(vertexes);
        ShapeWarehouse.getInstance().setCubeValues(id, valuesCube);
    }
}
