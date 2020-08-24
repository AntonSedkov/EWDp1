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
        CountedValuesCube valuesCube = ShapeWarehouse.getInstance().getCubeValues(id);
        if (valuesCube == null) {
            valuesCube = new CountedValuesCube();
        }
        double surface = CubeServiceImpl.getInstance().calculateSurfaceArea(cube);
        valuesCube.setSurface(surface);
        double volume = CubeServiceImpl.getInstance().calculateVolume(cube);
        valuesCube.setVolume(volume);
        double facetDiagonal = CubeServiceImpl.getInstance().calculateFacetDiagonal(cube);
        valuesCube.setFacetDiagonal(facetDiagonal);
        double figureDiagonal = CubeServiceImpl.getInstance().calculateFigureDiagonal(cube);
        valuesCube.setFigureDiagonal(figureDiagonal);
        ShapeWarehouse.getInstance().setCubeValues(id, valuesCube);
    }

}