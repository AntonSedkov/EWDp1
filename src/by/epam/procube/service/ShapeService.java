package by.epam.procube.service;

import by.epam.procube.entity.Shape;

public interface ShapeService {

    double calculateSurfaceArea(Shape shape);

    double calculateVolume(Shape shape);

    double calculateDividedVolumeProportion(Shape shape, double differenceDistance);

    boolean isShapeOnCoordinatePlane(Shape shape);

}