package by.epam.procube.creator;

import by.epam.procube.entity.CountedValuesCube;
import by.epam.procube.entity.Cube;
import by.epam.procube.exception.CubeException;
import by.epam.procube.parser.CubeDataParser;
import by.epam.procube.reader.CubeDataReader;
import by.epam.procube.repository.CubeRepository;
import by.epam.procube.service.impl.CubeServiceImpl;
import by.epam.procube.warehouse.ShapeWarehouse;
import org.apache.log4j.Logger;

import java.util.List;

public class CubeDataCreator {
    private static Logger logger = Logger.getLogger(CubeDataCreator.class);

    public CubeDataCreator(String filePath) {
        try {
            List<String> data = CubeDataReader.readLinesFile(filePath);
            CubeDataParser parser = new CubeDataParser();
            List<Cube> cubes = parser.parseCubes(data);
            CubeRepository.getInstance().setCubes(cubes);
            CubeServiceImpl service = new CubeServiceImpl();
            for (Cube cube : cubes) {
                CountedValuesCube valuesCube = new CountedValuesCube();
                valuesCube.setVolume(service.calculateVolume(cube));
                valuesCube.setSurface(service.calculateSurfaceArea(cube));
                valuesCube.setFigureDiagonal(service.calculateFigureDiagonal(cube));
                valuesCube.setFacetDiagonal(service.calculateFacetDiagonal(cube));
                valuesCube.setVertexes(service.calculateVertexPoints(cube));
                ShapeWarehouse.getInstance().setSurfaceElement(cube.getId(), valuesCube);
            }
            logger.info("Data creating complete successfully.");
        } catch (CubeException e) {
            logger.error("Data creating error.", e);
        }
    }

}