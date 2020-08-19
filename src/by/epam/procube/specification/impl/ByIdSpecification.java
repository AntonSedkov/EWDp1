package by.epam.procube.specification.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.specification.Specification;

public class ByIdSpecification implements Specification {
    private long id;

    public ByIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean test(Cube cube) {
        return cube.getId() == id;
    }
}