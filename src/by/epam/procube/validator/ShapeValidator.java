package by.epam.procube.validator;

import by.epam.procube.entity.Point;

import java.util.Set;

public class ShapeValidator {

    private static final double INACCURACY = 0.00001;

    public static boolean isPlane(Point a, Point b, Point c) {
        boolean result = a.equals(b) || a.equals(c) || b.equals(c);
        if (a.getPointX() == b.getPointX() && a.getPointX() == c.getPointX()) {
            result = (((c.getPointZ() - a.getPointZ()) / (b.getPointZ() - a.getPointZ())) -
                    ((c.getPointY() - a.getPointY()) / (b.getPointY() - a.getPointY()))) < INACCURACY;
        }
        if (a.getPointY() == b.getPointY() && a.getPointY() == c.getPointY()) {
            result = (((c.getPointZ() - a.getPointZ()) / (b.getPointZ() - a.getPointZ())) -
                    ((c.getPointX() - a.getPointX()) / (b.getPointX() - a.getPointX()))) < INACCURACY;
        }
        if (a.getPointZ() == b.getPointZ() && a.getPointZ() == c.getPointZ()) {
            result = (((c.getPointX() - a.getPointX()) / (b.getPointX() - a.getPointX())) -
                    ((c.getPointY() - a.getPointY()) / (b.getPointY() - a.getPointY()))) < INACCURACY;
        }
        return !result;
    }


    public static boolean isCube(Set<Point> vertexes) {

        return false;
    }

}
