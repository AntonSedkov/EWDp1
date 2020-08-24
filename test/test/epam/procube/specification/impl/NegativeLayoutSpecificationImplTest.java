package test.epam.procube.specification.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.specification.Specification;
import by.epam.procube.specification.impl.NegativeLayoutSpecificationImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NegativeLayoutSpecificationImplTest {
    Specification specification;

    @BeforeMethod
    public void setUp() {
        specification = new NegativeLayoutSpecificationImpl();
    }

    @Test(dataProvider = "specificationNegativeLayoutData", dataProviderClass = SpecificationDataProvider.class)
    public void testTest1(Cube cube, boolean expected) {
        boolean actual = specification.test(cube);
        assertEquals(actual, expected);
    }

}