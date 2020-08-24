package by.epam.procube.specification.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.specification.Specification;

public class NegativeLayoutSpecificationImpl implements Specification {

    @Override
    public boolean test(Cube cube) {
        Point start = cube.getStartPoint();
        boolean result = start.getPointX() < ZERO_POINT && start.getPointY() < ZERO_POINT && start.getPointZ() < ZERO_POINT;
        return result;
    }

}