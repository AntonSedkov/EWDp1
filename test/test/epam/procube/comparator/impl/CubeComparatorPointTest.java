package test.epam.procube.comparator.impl;

import by.epam.procube.comparator.impl.CubeComparatorPoint;
import by.epam.procube.entity.Cube;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CubeComparatorPointTest {
    CubeComparatorPoint comparatorPoint;

    @BeforeMethod
    public void setUp() {
        comparatorPoint = new CubeComparatorPoint();
    }

    @Test(dataProvider = "comparatorData", dataProviderClass = ComparatorDataProvider.class)
    public void testCompare(Cube one, Cube two, int expected) {
        int actual = comparatorPoint.compare(one, two);
        assertEquals(actual, expected);
    }

}