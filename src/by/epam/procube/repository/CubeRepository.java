package by.epam.procube.repository;

import by.epam.procube.comparator.CubeComparator;
import by.epam.procube.entity.Cube;
import by.epam.procube.specification.Specification;

import java.util.ArrayList;
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

    public List<Cube> query(Specification spec) {
        List<Cube> result = cubes.stream().filter(spec).collect(Collectors.toList());
        return result;
    }

    public boolean addCube(Cube cube) {
        boolean result = false;
        if (cube != null) {
            cubes.add(cube);
            result = true;
        }
        return result;
    }

    public boolean removeCube(Cube cube) {
        boolean result = false;
        if (cubes.contains(cube)) {
            cubes.remove(cube);
            result = true;
        }
        return result;
    }

    public boolean removeCubeById(long cubeId) {
        boolean result = false;
        for (Cube cube : cubes) {
            if (cube.getId() == cubeId) {
                cubes.remove(cube);
                result = true;
            }
        }
        return result;
    }

    public List<Cube> sortCubes(CubeComparator comparator) {
        List<Cube> result = new ArrayList<>(cubes);
        result = result.stream().sorted(comparator).collect(Collectors.toList());
        return result;
    }

}