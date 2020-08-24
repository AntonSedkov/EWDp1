package by.epam.procube.entity;

import by.epam.procube.observer.CubeEvent;
import by.epam.procube.observer.Observable;
import by.epam.procube.observer.Observer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Cube extends Shape implements Observable {
    public static final int MULTIPLIER_FOR_SURFACE_AREA = 6;
    public static final int DEGREE_FOR_SURFACE_AREA = 2;
    public static final int DEGREE_FOR_VOLUME = 3;
    public static final double MULTIPLIER_FOR_FIGURE_DIAGONAL = Math.sqrt(3);
    public static final double MULTIPLIER_FOR_FACET_DIAGONAL = Math.sqrt(2);
    public static final int QUANTITY_VERTEXES = 8;
    public static final double PARALLEL_COORDINATE_PLANE_INDICATOR = 0.0;

    private double edge;
    private Point startPoint;
    private List<Observer> observers = new ArrayList<>();
    private static Logger logger = LogManager.getLogger(Cube.class);

    public Cube() {
        super();
        logger.info("Empty Cube was created.");
    }

    public Cube(double edge, Point startPoint) {
        super();
        this.edge = edge;
        this.startPoint = startPoint;
        logger.info("Cube was fully created.");
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
        notifyObservers();
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        if (!super.equals(o)) return false;
        if (Double.compare(cube.edge, edge) != 0) return false;
        return startPoint != null ? startPoint.equals(cube.startPoint) : cube.startPoint == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(edge);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (startPoint != null ? startPoint.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cube.class.getSimpleName() + "[", "]")
                .add("id=" + getId())
                .add("edge=" + edge)
                .add("start Point=" + startPoint)
                .toString();
    }

    public boolean equalCubes(Cube cube) {
        if (this == cube) return true;
        if (cube == null) return false;
        if (Double.compare(cube.edge, edge) != 0) return false;
        return startPoint != null ? startPoint.equals(cube.startPoint) : cube.startPoint == null;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.actionPerformer(new CubeEvent(this)));
    }

}