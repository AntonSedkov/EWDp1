package by.epam.procube.warehouse;

import by.epam.procube.entity.CountedValuesCube;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShapeWarehouse {
    private Map<Long, CountedValuesCube> countedValuesCube;
    private static ShapeWarehouse instance;

    private ShapeWarehouse() {
    }

    public static ShapeWarehouse getInstance() {
        if (instance == null) {
            instance = new ShapeWarehouse();
        }
        return instance;
    }

    public Map<Long, CountedValuesCube> getSurfaces() {
        return Collections.unmodifiableMap(countedValuesCube);
    }

    public CountedValuesCube getSurfaceElement(Long keyId) {
        CountedValuesCube result = new CountedValuesCube();
        if (countedValuesCube.containsKey(keyId)) {
            result = countedValuesCube.get(keyId);
        }
        return result;
    }

    public void setSurfaceElement(Long id, CountedValuesCube valuesCube) {
        if (countedValuesCube == null) {
            countedValuesCube = new HashMap<>();
        }
        countedValuesCube.put(id, valuesCube);
    }

}