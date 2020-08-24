package by.epam.procube.service.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.entity.Shape;
import by.epam.procube.service.ShapeService;

import java.util.*;

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

    //difference distance - divide cube for two part
    @Override
    public double calculateDividedVolumeProportion(Shape shape, double differenceDistance) {
        double result = 0;
        if (shape instanceof Cube) {
            Cube cube = (Cube) shape;
            double edge = cube.getEdge();
            if (differenceDistance > 0 && differenceDistance < edge) {
                double distanceRemaining = edge - differenceDistance;
                double degreeForVolume = 2;
                double firstVolume = differenceDistance * Math.pow(edge, degreeForVolume);
                double remainingVolume = distanceRemaining * Math.pow(edge, degreeForVolume);
                result = firstVolume / remainingVolume;
            }
        }
        return result;
    }

    //Cube is situated parallel to coordinate plane
    @Override
    public boolean isShapeOnCoordinatePlane(Shape shape) {
        boolean result = false;
        if (shape instanceof Cube) {
            Cube cube = (Cube) shape;
            if (cube.getStartPoint() != null) {
                Point start = cube.getStartPoint();
                double edge = cube.getEdge();
                if (start.getPointX() == Cube.PARALLEL_COORDINATE_PLANE_INDICATOR ||
                        start.getPointY() == Cube.PARALLEL_COORDINATE_PLANE_INDICATOR ||
                        start.getPointZ() == Cube.PARALLEL_COORDINATE_PLANE_INDICATOR ||
                        start.getPointX() + edge == Cube.PARALLEL_COORDINATE_PLANE_INDICATOR ||
                        start.getPointY() + edge == Cube.PARALLEL_COORDINATE_PLANE_INDICATOR ||
                        start.getPointZ() + edge == Cube.PARALLEL_COORDINATE_PLANE_INDICATOR) {
                    result = true;
                }
            }
        }
        return result;
    }

    // Cube has three distances: edge, facet diagonal, figure diagonal; for one point to another - 3 edges, 3 facet diagonals, 1 figure diagonal;
    // for cube - 3*7 = 21 edges, 3*7 = 21 facet diagonals, 1*7 = 7 figure diagonals (without point to itself 1*7 = 0).
    public boolean isCubeShape(List<Point> vertexes) {
        boolean result = false;
        if (vertexes != null && vertexes.size() == Cube.QUANTITY_VERTEXES) {
            int quantityDistancesCube = 3;
            int edges = 21;
            int figureDiagonals = 7;
            Map<Double, Integer> distanceQuantity = new HashMap<>();
            result = true;
            for (int i = 0; result && i < vertexes.size(); i++) {
                for (int j = 0; result && j < vertexes.size() - 1; j++) {
                    if (j == i) {
                        continue;
                    }
                    double distance = countPointsDistance(vertexes.get(i), vertexes.get(j));
                    if (distanceQuantity.size() <= quantityDistancesCube) {
                        if (distanceQuantity.containsKey(distance)) {
                            int quantity = distanceQuantity.get(distance);
                            distanceQuantity.replace(distance, ++quantity);
                        } else {
                            distanceQuantity.put(distance, 1);
                        }
                    } else {
                        result = false;
                    }
                }
            }
            if (distanceQuantity.size() == quantityDistancesCube) {
                result = false;
                if (distanceQuantity.containsValue(edges) &&
                        distanceQuantity.containsValue(figureDiagonals)) {
                    double figureDiagonal = 0;
                    Set<Double> keys = distanceQuantity.keySet();
                    for (Double key : keys) {
                        if (distanceQuantity.get(key) == figureDiagonals) {
                            figureDiagonal = key;
                        }
                    }
                    double precision = 0.00000001;
                    for (Double key : keys) {
                        if (key != 0 && key * Cube.MULTIPLIER_FOR_FIGURE_DIAGONAL - figureDiagonal < precision) {
                            result = true;
                        }
                    }
                }
            }
        }
        return result;
    }

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
        if (cube != null && cube.getStartPoint() != null && cube.getEdge() > 0) {
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
        }
        return vertexes;
    }

    private double countPointsDistance(Point one, Point two) {
        double distance = 0;
        if (one != null && two != null) {
            int degree = 2;
            distance = Math.sqrt(
                    Math.pow(one.getPointX() - two.getPointX(), degree) +
                            Math.pow(one.getPointY() - two.getPointY(), degree) +
                            Math.pow(one.getPointZ() - two.getPointZ(), degree)
            );
        }
        return distance;
    }

}