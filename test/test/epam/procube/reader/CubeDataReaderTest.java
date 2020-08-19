package test.epam.procube.reader;

import by.epam.procube.exception.CubeException;
import by.epam.procube.reader.CubeDataReader;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CubeDataReaderTest {

    @Test
    public void testReadLinesFile() {
        List<String> expected = new ArrayList<>();
        expected.add("10.0 20.0 30.0 40.0");
        expected.add("-10.0 -20.0 -30.0 -40.0");
        expected.add("10.0 -20.0 -30.0 -40.0");
        expected.add("10.0 12.0 22.0 -5.0");
        expected.add("5.55  55.44  66.33   77.22");
        expected.add("Hello Java!!!");
        expected.add("1 11");
        expected.add("");
        expected.add("33 66 78 89 88");
        expected.add("44.et  -ABC 22 15");
        expected.add("5   -16.14     27.19      38.20");
        expected.add("6   17.15      28.18      -39.21");
        expected.add("7   -18.16     29.17      40.22");
        expected.add("8   19      30      41");
        expected.add("9   -20 -31 -42");
        expected.add("10  21  32  -43");
        expected.add("11  -22 -33 44");
        expected.add("12  -23 34  -45");
        expected.add("13  -24 -35 46");
        expected.add("14  25  36  -47");
        expected.add("15  26  -37 48");
        expected.add("");
        expected.add("");
        expected.add("resources\\\\cubes.txt");
        expected.add("./resources/cubes.txt");
        try {
            List<String> actual = CubeDataReader.readLinesFile("./resources/cubes.txt");
            assertEquals(actual, expected);
        } catch (CubeException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CubeException.class)
    public void testReadLinesFileException() throws CubeException {
        List<String> actual = CubeDataReader.readLinesFile("src\\resources\\cubes.txt");
    }
}