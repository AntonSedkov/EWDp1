package by.epam.procube.comparator.impl;

import by.epam.procube.comparator.CubeComparator;
import by.epam.procube.entity.Cube;

public class CubeComparatorPoint implements CubeComparator {

    @Override
    public int compare(Cube cubeOne, Cube cubeTwo) {
        int result = Double.compare(cubeOne.getStartPoint().getPointX(), cubeTwo.getStartPoint().getPointX());
        if (result == 0) {
            result = Double.compare(cubeOne.getStartPoint().getPointY(), cubeTwo.getStartPoint().getPointY());
            if (result == 0) {
                result = Double.compare(cubeOne.getStartPoint().getPointZ(), cubeTwo.getStartPoint().getPointZ());
            }
        }
        return result;
    }

}