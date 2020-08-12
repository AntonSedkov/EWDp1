package by.epam.procube.entity;

import java.util.StringJoiner;

public class Cube extends Shape {

    public static final int MULTIPLIER_FOR_SURFACE_AREA = 6;
    public static final int DEGREE_FOR_SURFACE_AREA = 2;
    public static final int DEGREE_FOR_VOLUME = 3;
    public static final double MULTIPLIER_FOR_FIGURE_DIAGONAL = Math.sqrt(3);
    public static final double MULTIPLIER_FOR_FACET_DIAGONAL = Math.sqrt(2);
    private static final int QUANTITY_VERTEXES = 8;// TODO: 10.08.2020

    private double edge;
    private Point start;

    public Cube() {
    }

    public Cube(double edge, Point start) {
        this.edge = edge;
        this.start = start;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        if (Double.compare(cube.edge, edge) != 0) return false;
        return start != null ? start.equals(cube.start) : cube.start == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(edge);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (start != null ? start.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cube.class.getSimpleName() + "[", "]")
                .add("edge=" + edge)
                .add("start Point=" + start)
                .toString();
    }

}