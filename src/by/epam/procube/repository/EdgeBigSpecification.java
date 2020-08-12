package by.epam.procube.repository;

import by.epam.procube.entity.Cube;

public class EdgeBigSpecification implements Specification {

    private int big = 30;

    @Override
    public boolean test(Cube cube) {

        return cube.getEdge() >30;
    }
}
