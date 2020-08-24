package test.epam.procube.comparator.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import org.testng.annotations.DataProvider;

public class ComparatorDataProvider {

    @DataProvider(name = "comparatorData")
    public static Object[][] createData() {
        Cube one = new Cube(5, new Point(-10, -20, -30));
        Cube two = new Cube(10, new Point(0, 0, 0));
        Cube three = new Cube(15, new Point(100, 200, 300));
        return new Object[][]{
                {one, two, -1}, {three, two, 1}, {one, one, 0}
        };
    }

}