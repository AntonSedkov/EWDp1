package by.epam.procube.reader;

import by.epam.procube.exception.CubeException;
import by.epam.procube.validator.IncomingDataValidator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CubeDataReader {
    private static Logger logger = Logger.getLogger(CubeDataReader.class);

    public static List<String> readLinesFile(String pathToFile) throws CubeException {
        try (Stream<String> lineStream = Files.lines(Paths.get(pathToFile))) {
            List<String> lines = lineStream.filter(IncomingDataValidator::isGoodLineForCube).collect(Collectors.toList());
            logger.info("Data has read successfully. Good lines: " + lines.size());
            return lines;
        } catch (IOException e) {
            throw new CubeException("Data has not read. Wrong path: " + pathToFile, e);
        }
    }

}
