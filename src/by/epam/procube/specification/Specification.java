package by.epam.procube.specification;

import by.epam.procube.entity.Cube;

import java.util.function.Predicate;

public interface Specification extends Predicate<Cube> {
    int SMALL = 30;
    int BIG = 100;
    double ZERO_POINT = 0.00;
}