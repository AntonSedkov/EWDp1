package by.epam.procube.service;

import by.epam.procube.entity.Plane;
import by.epam.procube.entity.Shape;

public interface ShapeService {

    double calculateSurfaceArea(Shape shape);
    double calculateVolume(Shape shape);
    double calculateVolumeDivideByPlane(Shape shape, Plane plane);
    boolean isShapeOnCoordinatePlane(Shape shape);

}
