package by.epam.procube.service.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.entity.Shape;
import by.epam.procube.service.ShapeService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
        Point[] vertexes = new Point[Cube.QUANTITY_VERTEXES];
        vertexes[0] = cube.getStartPoint();
        double edge = cube.getEdge();
        for (int i = 1; i < vertexes.length; i++) {
            Point pointNew = vertexes[0];
            switch (i) {
                case 1:
                    pointNew.setPointX(pointNew.getPointX() + edge);
                    vertexes[i] = pointNew;
                    break;
                case 2:
                    pointNew.setPointY(pointNew.getPointY() + edge);
                    vertexes[i] = pointNew;
                    break;
                case 3:
                    pointNew.setPointZ(pointNew.getPointZ() + edge);
                    vertexes[i] = pointNew;
                    break;
                case 4:
                    pointNew.setPointX(pointNew.getPointX() + edge);
                    pointNew.setPointY(pointNew.getPointY() + edge);
                    vertexes[i] = pointNew;
                    break;
                case 5:
                    pointNew.setPointX(pointNew.getPointX() + edge);
                    pointNew.setPointZ(pointNew.getPointZ() + edge);
                    vertexes[i] = pointNew;
                    break;
                case 6:
                    pointNew.setPointY(pointNew.getPointY() + edge);
                    pointNew.setPointZ(pointNew.getPointZ() + edge);
                    vertexes[i] = pointNew;
                    break;
                case 7:
                    pointNew.setPointX(pointNew.getPointX() + edge);
                    pointNew.setPointY(pointNew.getPointY() + edge);
                    pointNew.setPointZ(pointNew.getPointZ() + edge);
                    vertexes[i] = pointNew;
                    break;
            }
        }
        return Arrays.asList(vertexes);
    }

}