package by.epam.procube.specification.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.specification.Specification;

public class SmallSizeSpecificationImpl implements Specification {
    @Override
    public boolean test(Cube cube) {
        return cube.getEdge() <= SMALL;
    }
}
