package by.epam.procube.service.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.entity.Shape;
import by.epam.procube.service.ShapeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CubeServiceImpl implements ShapeService {
    private static CubeServiceImpl instance;

    private CubeServiceImpl() {
    }

    public static CubeServiceImpl getInstance() {
        if (instance == null) {
            instance = new CubeServiceImpl();
        }
        return instance;
    }

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
    public double calculateVolumeDivideByPlane(Shape shape, Set<Point> plane) {
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

    public List<Point> calculateVertexPoints(Cube cube) {
        List<Point> vertexes = new ArrayList<>();
        Point startPoint = cube.getStartPoint();
        vertexes.add(startPoint);
        double edge = cube.getEdge();
        for (int i = 1; i < Cube.QUANTITY_VERTEXES; i++) {
            Point newPoint = new Point(startPoint);
            switch (i) {
                case 1:
                    newPoint.setPointX(newPoint.getPointX() + edge);
                    vertexes.add(newPoint);
                    break;
                case 2:
                    newPoint.setPointY(newPoint.getPointY() + edge);
                    vertexes.add(newPoint);
                    break;
                case 3:
                    newPoint.setPointZ(newPoint.getPointZ() + edge);
                    vertexes.add(newPoint);
                    break;
                case 4:
                    newPoint.setPointX(newPoint.getPointX() + edge);
                    newPoint.setPointY(newPoint.getPointY() + edge);
                    vertexes.add(newPoint);
                    break;
                case 5:
                    newPoint.setPointX(newPoint.getPointX() + edge);
                    newPoint.setPointZ(newPoint.getPointZ() + edge);
                    vertexes.add(newPoint);
                    break;
                case 6:
                    newPoint.setPointY(newPoint.getPointY() + edge);
                    newPoint.setPointZ(newPoint.getPointZ() + edge);
                    vertexes.add(newPoint);
                    break;
                case 7:
                    newPoint.setPointX(newPoint.getPointX() + edge);
                    newPoint.setPointY(newPoint.getPointY() + edge);
                    newPoint.setPointZ(newPoint.getPointZ() + edge);
                    vertexes.add(newPoint);
                    break;
            }
        }
        return vertexes;
    }

}