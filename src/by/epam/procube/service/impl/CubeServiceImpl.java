package by.epam.procube.service.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Plane;
import by.epam.procube.entity.Shape;
import by.epam.procube.service.ShapeService;

public class CubeServiceImpl implements ShapeService {

    @Override
    public double calculateSurfaceArea(Shape shape) {
        double result = 0;
        if (shape instanceof Cube) {
            Cube cube = (Cube) shape;
            result = Cube.MULTIPLIER_FOR_SURFACE_AREA * Math.pow(cube.getEdge(), Cube.DEGREE_FOR_SURFACE_AREA);
        }
        return result;
    }

    @Override
    public double calculateVolume(Shape shape) {
        double result = 0;
        if (shape instanceof Cube) {
            Cube cube = (Cube) shape;
            result = Math.pow(cube.getEdge(), Cube.DEGREE_FOR_VOLUME);
        }
        return result;
    }

    @Override
    public double calculateVolumeDivideByPlane(Shape shape, Plane plane) {
        return 0;
    }// TODO: 10.08.2020  

    @Override
    public boolean isShapeOnCoordinatePlane(Shape shape) {
        return false;
    }// TODO: 10.08.2020  

    public double calculateFigureDiagonal(Cube cube) {
        double result = 0;
        if (cube != null) {
            result = cube.getEdge() * Cube.MULTIPLIER_FOR_FIGURE_DIAGONAL;
        }
        return result;
    }

    public double calculateFacetDiagonal(Cube cube) {
        double result = 0;
        if (cube != null) {
            result = cube.getEdge() * Cube.MULTIPLIER_FOR_FACET_DIAGONAL;
        }
        return result;
    }

}