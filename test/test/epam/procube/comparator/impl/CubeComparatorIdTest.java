package test.epam.procube.comparator.impl;

import by.epam.procube.comparator.impl.CubeComparatorId;
import by.epam.procube.entity.Cube;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CubeComparatorIdTest {
    CubeComparatorId comparatorId;

    @BeforeMethod
    public void setUp() {
        comparatorId = new CubeComparatorId();
    }

    @Test(dataProvider = "comparatorData", dataProviderClass = ComparatorDataProvider.class)
    public void testCompare(Cube one, Cube two, int expected) {
        int actual = comparatorId.compare(one, two);
        assertEquals(actual, expected);
    }

}