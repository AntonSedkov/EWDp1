package by.epam.procube.entity;

import by.epam.procube.util.IdGenerator;

import java.util.StringJoiner;

public class Shape {

    private long shapeId;

    public Shape() {
        shapeId = IdGenerator.generateId();
    }

    public Shape(long shapeId) {
        this.shapeId = shapeId;
    }

    public long getId() {
        return shapeId;
    }

    public void setId(long shapeId) {
        this.shapeId = shapeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return shapeId == shape.shapeId;
    }

    @Override
    public int hashCode() {
        return (int) (shapeId ^ (shapeId >>> 32));
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Shape.class.getSimpleName() + "[", "]")
                .add("shapeId=" + shapeId)
                .toString();
    }
}