package by.epam.procube.factory;

import by.epam.procube.entity.Shape;

import java.util.List;

public abstract class AbstractShapeFactory<T extends Shape> {

    public abstract T createInstance(List<Double> lines);

    public abstract List<T> createAllCubes(List<List<Double>> cubes);

}