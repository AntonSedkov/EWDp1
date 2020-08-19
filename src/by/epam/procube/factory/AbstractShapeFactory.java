package by.epam.procube.factory;

import by.epam.procube.entity.Shape;

import java.util.List;

public abstract class AbstractShapeFactory<T extends Shape> {
    public abstract T createInstance(List<String> lines);

    public abstract List<T> createAllCubes(List<List<String>> cubes);
}
