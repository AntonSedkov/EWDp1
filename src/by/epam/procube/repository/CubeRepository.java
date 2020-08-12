package by.epam.procube.repository;

import by.epam.procube.entity.Cube;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepository {
    private List<Cube> cubes;
    private static CubeRepository instance;

    private CubeRepository() {
    }

    public static CubeRepository getInstance() {
        if (instance == null) {
            instance = new CubeRepository();
        }
        return instance;
    }

    public List<Cube> getCubes() {
        return Collections.unmodifiableList(cubes);
    }

    public void setCubes(List<Cube> cubes) {
        this.cubes = cubes;
    }

    public List<Cube> sortCubes(Specification spec) {

        return null;
    }

    public List<Cube> query(Specification spec) {
        List<Cube> result = cubes.stream().filter(spec).collect(Collectors.toList());
        return result;
    }


}
