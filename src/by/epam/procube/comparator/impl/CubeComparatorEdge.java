package by.epam.procube.comparator.impl;

import by.epam.procube.comparator.CubeComparator;
import by.epam.procube.entity.Cube;

public class CubeComparatorEdge implements CubeComparator {

    @Override
    public int compare(Cube cubeOne, Cube cubeTwo) {
        return Double.compare(cubeOne.getEdge(), cubeTwo.getEdge());
    }

}