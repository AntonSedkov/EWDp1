package by.epam.procube.service;

import by.epam.procube.entity.Point;
import by.epam.procube.entity.Shape;

import java.util.Set;

public interface ShapeService {

    double calculateSurfaceArea(Shape shape);

    double calculateVolume(Shape shape);

    double calculateVolumeDivideByPlane(Shape shape, Set<Point> plane);

    boolean isShapeOnCoordinatePlane(Shape shape);

}
