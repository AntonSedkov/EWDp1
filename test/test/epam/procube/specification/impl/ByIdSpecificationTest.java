package test.epam.procube.specification.impl;

import by.epam.procube.entity.Cube;
import by.epam.procube.specification.Specification;
import by.epam.procube.specification.impl.ByIdSpecification;
import by.epam.procube.util.IdGenerator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ByIdSpecificationTest {
    Specification specification;
    Cube one;
    Cube two;

    @BeforeMethod
    public void setUp() {
        IdGenerator.setId(0);
        specification = new ByIdSpecification(2);
        one = new Cube();
        two = new Cube();
    }

    @Test
    public void testTestTrue() {
        boolean actual = specification.test(two);
        assertTrue(actual);
    }

    @Test
    public void testTestFalse() {
        boolean actual = specification.test(one);
        assertFalse(actual);
    }

}