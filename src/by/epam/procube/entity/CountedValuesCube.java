package by.epam.procube.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class CountedValuesCube {
    private double surface;
    private double volume;
    private double figureDiagonal;
    private double facetDiagonal;
    private List<Point> vertexes;
    private static final double DEFAULT_VALUE = -1;

    public CountedValuesCube() {
        surface = DEFAULT_VALUE;
        volume = DEFAULT_VALUE;
        figureDiagonal = DEFAULT_VALUE;
        facetDiagonal = DEFAULT_VALUE;
        vertexes = new ArrayList<>();
    }

    public CountedValuesCube(double surface, double volume, double figureDiagonal, double facetDiagonal, List<Point> vertexes) {
        this.surface = surface;
        this.volume = volume;
        this.figureDiagonal = figureDiagonal;
        this.facetDiagonal = facetDiagonal;
        this.vertexes = vertexes;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getFigureDiagonal() {
        return figureDiagonal;
    }

    public void setFigureDiagonal(double figureDiagonal) {
        this.figureDiagonal = figureDiagonal;
    }

    public double getFacetDiagonal() {
        return facetDiagonal;
    }

    public void setFacetDiagonal(double facetDiagonal) {
        this.facetDiagonal = facetDiagonal;
    }

    public List<Point> getVertexes() {
        return vertexes;
    }

    public void setVertexes(List<Point> vertexes) {
        this.vertexes = vertexes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountedValuesCube that = (CountedValuesCube) o;
        if (Double.compare(that.surface, surface) != 0) return false;
        if (Double.compare(that.volume, volume) != 0) return false;
        if (Double.compare(that.figureDiagonal, figureDiagonal) != 0) return false;
        if (Double.compare(that.facetDiagonal, facetDiagonal) != 0) return false;
        return vertexes != null ? vertexes.equals(that.vertexes) : that.vertexes == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(surface);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(figureDiagonal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(facetDiagonal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (vertexes != null ? vertexes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CountedValuesCube.class.getSimpleName() + "[", "]")
                .add("surface=" + surface)
                .add("volume=" + volume)
                .add("figureDiagonal=" + figureDiagonal)
                .add("facetDiagonal=" + facetDiagonal)
                .add("vertexes=" + vertexes)
                .toString();
    }

}