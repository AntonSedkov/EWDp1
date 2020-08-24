package by.epam.procube.comparator.impl;

import by.epam.procube.comparator.CubeComparator;
import by.epam.procube.entity.Cube;

public class CubeComparatorId implements CubeComparator {

    @Override
    public int compare(Cube cubeOne, Cube cubeTwo) {
        return Long.compare(cubeOne.getId(), cubeTwo.getId());
    }

}