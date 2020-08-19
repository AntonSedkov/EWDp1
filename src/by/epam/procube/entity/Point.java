package by.epam.procube.entity;

import java.util.StringJoiner;

public class Point {
    private double pointX;
    private double pointY;
    private double pointZ;

    public Point() {
    }

    public Point(Point point) {
        pointX = point.getPointX();
        pointY = point.getPointY();
        pointZ = point.getPointZ();
    }

    public Point(double pointX, double pointY, double pointZ) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.pointZ = pointZ;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double getPointZ() {
        return pointZ;
    }

    public void setPointZ(double pointZ) {
        this.pointZ = pointZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        if (Double.compare(point.pointX, pointX) != 0) return false;
        if (Double.compare(point.pointY, pointY) != 0) return false;
        return Double.compare(point.pointZ, pointZ) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(pointX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pointY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pointZ);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                .add("pointX=" + pointX)
                .add("pointY=" + pointY)
                .add("pointZ=" + pointZ)
                .toString();
    }
}
