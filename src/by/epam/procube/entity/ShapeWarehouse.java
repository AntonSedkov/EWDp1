package by.epam.procube.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShapeWarehouse {
    private Map<Long, CountedValuesCube> countedValuesCube;
    private static ShapeWarehouse instance;

    private ShapeWarehouse() {
        countedValuesCube = new HashMap<>();
    }

    public static ShapeWarehouse getInstance() {
        if (instance == null) {
            instance = new ShapeWarehouse();
        }
        return instance;
    }

    public Map<Long, CountedValuesCube> getAllCubeValues() {
        return Collections.unmodifiableMap(countedValuesCube);
    }

    public CountedValuesCube getCubeValues(Long keyId) {
        CountedValuesCube result = new CountedValuesCube();
        if (countedValuesCube.containsKey(keyId)) {
            result = countedValuesCube.get(keyId);
        }
        return result;
    }

    public void setCubeValues(Long id, CountedValuesCube valuesCube) {
        if (countedValuesCube == null) {
            countedValuesCube = new HashMap<>();
        }
        countedValuesCube.put(id, valuesCube);
    }

}