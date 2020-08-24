package by.epam.procube.parser;

import by.epam.procube.validator.IncomingDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CubeDataParser {
    private static Logger logger = LogManager.getLogger(CubeDataParser.class);
    private static final String SPLITTER = "\\s+";

    public List<List<Double>> parseCubes(List<String> data) {
        List<String> goodLines = data.stream().filter(IncomingDataValidator::isGoodLineForCube).collect(Collectors.toList());
        logger.info("Quantity of good cube lines: " + goodLines.size());
        List<List<Double>> cubes = new ArrayList<>();
        for (String line : goodLines) {
            String[] params = line.split(SPLITTER);
            List<Double> doubles = new ArrayList<>();
            for (String number : params) {
                doubles.add(Double.parseDouble(number));
            }
            cubes.add(doubles);
        }
        logger.info("Data has successfully parsed for cubes.");
        return cubes;
    }

}