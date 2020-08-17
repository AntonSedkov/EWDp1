package by.epam.procube.factory;

import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;

public class CubeFactory extends AbstractShapeFactory<Cube> {
    private static final int QUANTITY_PARAMETERS = 4;

    @Override
    public Cube createInstance(String[] lines) {
        Cube cube = null;
        if (lines != null && lines.length == QUANTITY_PARAMETERS) {
            cube = new Cube(Double.parseDouble(lines[0]),
                    new Point(Double.parseDouble(lines[1]), Double.parseDouble(lines[2]), Double.parseDouble(lines[3])));
        }
        return cube;
    }
}
