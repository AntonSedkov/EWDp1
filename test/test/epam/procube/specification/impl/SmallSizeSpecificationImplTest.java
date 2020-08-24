package test.epam.procube.specification.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.specification.Specification;
import by.epam.procube.specification.impl.SmallSizeSpecificationImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SmallSizeSpecificationImplTest {
    Specification specification;

    @BeforeMethod
    public void setUp() {
        specification = new SmallSizeSpecificationImpl();
    }

    @Test(dataProvider = "specificationSmallSizeData", dataProviderClass = SpecificationDataProvider.class)
    public void testTest1(Cube cube, boolean expected) {
        boolean actual = specification.test(cube);
        assertEquals(actual, expected);
    }

}