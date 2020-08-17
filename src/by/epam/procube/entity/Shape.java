package by.epam.procube.entity;

import by.epam.procube.util.IdGenerator;

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

}