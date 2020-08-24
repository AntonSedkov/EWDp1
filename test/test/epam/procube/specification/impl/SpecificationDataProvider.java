package test.epam.procube.specification.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import org.testng.annotations.DataProvider;

public class SpecificationDataProvider {
    private static Cube one = new Cube(1, new Point(100, -200, 300));
    private static Cube two = new Cube(29, new Point(-0.07, -0.009, -0.00045));
    private static Cube three = new Cube(31, new Point(1000, 10000, 100000));
    private static Cube four = new Cube(99, new Point(0, 0, 0));
    private static Cube five = new Cube(101, new Point(0.07, 0.009, 0.00045));
    private static Cube six = new Cube(500, new Point(-10, -20, -30));

    @DataProvider(name = "specificationSmallSizeData")
    public static Object[][] createSmallSizeData() {
        return new Object[][]{
                {one, true}, {six, false}, {four, false}, {five, false}, {two, true}, {three, false}
        };
    }

    @DataProvider(name = "specificationMediumSizeData")
    public static Object[][] createMediumSizeData() {
        return new Object[][]{
                {five, false}, {two, false}, {one, false}, {three, true}, {six, false}, {four, true}
        };
    }

    @DataProvider(name = "specificationBigSizeData")
    public static Object[][] createBigSizeData() {
        return new Object[][]{
                {four, false}, {one, false}, {six, true}, {three, false}, {five, true}, {two, false}
        };
    }

    @DataProvider(name = "specificationNegativeLayoutData")
    public static Object[][] createNegativeLayoutData() {
        return new Object[][]{
                {one, false}, {two, true}, {three, false}, {four, false}, {five, false}, {six, true}
        };
    }

    @DataProvider(name = "specificationPositiveLayoutData")
    public static Object[][] createPositiveLayoutData() {
        return new Object[][]{
                {one, false}, {two, false}, {three, true}, {four, false}, {five, true}, {six, false}
        };
    }

}