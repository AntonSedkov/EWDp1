package test.epam.procube.comparator.impl;

import by.epam.procube.comparator.impl.CubeComparatorEdge;
import by.epam.procube.entity.Cube;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CubeComparatorEdgeTest {
    CubeComparatorEdge comparatorEdge;

    @BeforeMethod
    public void setUp() {
        comparatorEdge = new CubeComparatorEdge();
    }

    @Test(dataProvider = "comparatorData", dataProviderClass = ComparatorDataProvider.class)
    public void testCompare(Cube one, Cube two, int expected) {
        int actual = comparatorEdge.compare(one, two);
        assertEquals(actual, expected);
    }

}