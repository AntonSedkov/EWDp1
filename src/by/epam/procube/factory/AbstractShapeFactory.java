package by.epam.procube.factory;

import by.epam.procube.entity.Shape;

public abstract class AbstractShapeFactory<T extends Shape> {
    public abstract T createInstance(String [] lines);
}
