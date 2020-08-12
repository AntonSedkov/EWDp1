package by.epam.procube.parser;

import by.epam.procube.entity.Cube;
import by.epam.procube.factory.AbstractShapeFactory;
import by.epam.procube.factory.CubeFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class CubeDataParser {
    private static Logger logger = Logger.getLogger(CubeDataParser.class);
    private static final String SPLITTER = " ";

    public List<Cube> parseCubes(List<String> data) {
        List<Cube> cubes = new ArrayList<>();
        for (String line : data) {
            String[] params = line.split(SPLITTER);
            AbstractShapeFactory<Cube> factory = new CubeFactory();
            cubes.add(factory.createInstance(params));
            logger.info("Cubes created successfully");
        }
        return cubes;
    }

}
