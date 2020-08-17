package by.epam.procube.observer.impl;

import by.epam.procube.entity.CountedValuesCube;
import by.epam.procube.entity.Cube;
import by.epam.procube.observer.CubeEvent;
import by.epam.procube.observer.Observer;
import by.epam.procube.service.impl.CubeServiceImpl;
import by.epam.procube.warehouse.ShapeWarehouse;

public class CubeObserverEdge implements Observer<CubeEvent> {

    @Override
    public void actionPerformer(CubeEvent cubeEvent) {
        Cube cube = cubeEvent.getSource();
        long id = cube.getId();
        CountedValuesCube valuesCube = ShapeWarehouse.getInstance().getSurfaceElement(id);
        CubeServiceImpl service = new CubeServiceImpl();
        valuesCube.setSurface(service.calculateSurfaceArea(cube));
        valuesCube.setVolume(service.calculateVolume(cube));
        valuesCube.setFacetDiagonal(service.calculateFacetDiagonal(cube));
        valuesCube.setFigureDiagonal(service.calculateFigureDiagonal(cube));
        ShapeWarehouse.getInstance().setSurfaceElement(id, valuesCube);
    }
}