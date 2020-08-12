package by.epam.procube.warehouse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShapeWarehouse {

    private static final Double DEFAULT_VALUE = -1.0;
    private Map<Integer, Double> surfaces;
    private Map<Integer, Double> volumes;
    private Map<Integer, Double> figureDiagonals;
    private Map<Integer, Double> facetDiagonals;
    private static ShapeWarehouse instance;

    private ShapeWarehouse() {
    }

    public static ShapeWarehouse getInstance() {
        if (instance == null) {
            instance = new ShapeWarehouse();
        }
        return instance;
    }

    public Map<Integer, Double> getSurfaces() {
        return Collections.unmodifiableMap(surfaces);
    }

    public Double getSurfaceElement(Integer keyId) {
        return surfaces.getOrDefault(keyId, DEFAULT_VALUE);
    }

    public void setSurfaceElement(Integer id, Double result) {
        if (surfaces == null) {
            surfaces = new HashMap<>();
        }
        surfaces.put(id, result);
    }

    public Map<Integer, Double> getVolumes() {
        return Collections.unmodifiableMap(volumes);
    }

    public Double getVolumeElement(Integer keyId) {
        return volumes.getOrDefault(keyId, DEFAULT_VALUE);
    }

    public void setVolumeElement(Integer id, Double result) {
        if (volumes == null) {
            volumes = new HashMap<>();
        }
        volumes.put(id, result);
    }

    public Map<Integer, Double> getFigureDiagonals() {
        return Collections.unmodifiableMap(figureDiagonals);
    }

    public Double getFigureDiagonalElement(Integer keyId) {
        return figureDiagonals.getOrDefault(keyId, DEFAULT_VALUE);
    }

    public void setFigureDiagonalElement(Integer id, Double result) {
        if (figureDiagonals == null) {
            figureDiagonals = new HashMap<>();
        }
        figureDiagonals.put(id, result);
    }

    public Map<Integer, Double> getFacetDiagonals() {
        return Collections.unmodifiableMap(facetDiagonals);
    }

    public Double getFacetDiagonalElement(Integer keyId) {
        return facetDiagonals.getOrDefault(keyId, DEFAULT_VALUE);
    }

    public void setFacetDiagonalsElement(Integer id, Double result) {
        if (facetDiagonals == null) {
            facetDiagonals = new HashMap<>();
        }
        facetDiagonals.put(id, result);
    }

}