package test.epam.procube.util;

import by.epam.procube.util.IdGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdGeneratorTest {

    @BeforeMethod
    public void setUp(){
        IdGenerator.setId(0);
    }

    @Test
    public void testGenerateId() {
        IdGenerator.generateId();
        IdGenerator.generateId();
        long actual = IdGenerator.generateId();
        long expected = 3;
        assertEquals(actual,expected);
    }

    @Test
    public void testGenerateIdOverflow() {
        IdGenerator.setId(1_333_777_999);
        long actual = IdGenerator.generateId();
        long expected = 0;
        assertEquals(actual,expected);
    }

}