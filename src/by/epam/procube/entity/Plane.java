package by.epam.procube.entity;

import java.util.Collections;
import java.util.Set;
import java.util.StringJoiner;

public class Plane {

    Set<Point> points;

    public Plane() {
    }

    public Plane(Set<Point> points) {
        this.points = points;
    }

    public Set<Point> getPoints() {
        return Collections.unmodifiableSet(points);
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return points != null ? points.equals(plane.points) : plane.points == null;
    }

    @Override
    public int hashCode() {
        return points != null ? points.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Plane.class.getSimpleName() + "[", "]")
                .add("points=" + points)
                .toString();
    }
}
