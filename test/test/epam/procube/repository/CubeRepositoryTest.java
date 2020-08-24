package test.epam.procube.repository;

import by.epam.procube.comparator.CubeComparator;
import by.epam.procube.comparator.impl.CubeComparatorEdge;
import by.epam.procube.comparator.impl.CubeComparatorId;
import by.epam.procube.comparator.impl.CubeComparatorPoint;
import by.epam.procube.entity.Cube;
import by.epam.procube.entity.Point;
import by.epam.procube.repository.CubeRepository;
import by.epam.procube.specification.Specification;
import by.epam.procube.specification.impl.*;
import by.epam.procube.util.IdGenerator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class CubeRepositoryTest {
    CubeRepository cubeRepository = CubeRepository.getInstance();
    List<Cube> cubes;
    Cube one = new Cube(300, new Point(-10, -5, -800));
    Cube two = new Cube(22, new Point(45, -10, 0));
    Cube three = new Cube(99, new Point(-10, -55, -0.22));
    Cube four = new Cube(3, new Point(0.55, 0.12, 9999));
    Cube five = new Cube(600, new Point(0.55, 0.12, 0.77));
    Cube six = new Cube(31, new Point(-0.11, -99, -788));

    @BeforeMethod
    public void setUp() {
        IdGenerator.setId(0);
        cubeRepository.setCubes(new ArrayList<>());
        cubes = new ArrayList<>();
        cubes.add(one);
        cubes.add(two);
        cubes.add(three);
        cubes.add(four);
        cubes.add(five);
        cubes.add(six);
    }

    @Test(dataProvider = "dataQuery")
    public void testQuery(Specification spec, List<Cube> expected) {
        cubeRepository.setCubes(cubes);
        List<Cube> actual = cubeRepository.query(spec);
        assertEquals(actual, expected);
    }

    @Test
    public void testAddCube() {
        cubeRepository.setCubes(cubes);
        boolean actual = cubeRepository.addCube(new Cube(50, new Point(56, -88, -0.2)));
        assertTrue(actual);
    }

    @Test
    public void testAddCubeNull() {
        cubeRepository.setCubes(cubes);
        boolean actual = cubeRepository.addCube(null);
        assertFalse(actual);
    }

    @Test
    public void testRemoveCube() {
        cubeRepository.setCubes(cubes);
        boolean actual = cubeRepository.removeCube(two);
        assertTrue(actual);
    }

    @Test
    public void testRemoveCubeFalse() {
        cubeRepository.setCubes(cubes);
        boolean actual = cubeRepository.removeCube(new Cube(78, new Point(66, 0, 0)));
        assertFalse(actual);
    }

    @Test
    public void testRemoveCubeById() {
        cubeRepository.setCubes(cubes);
        boolean actual = cubeRepository.removeCubeById(2);
        assertTrue(actual);
    }

    @Test
    public void testRemoveCubeByIdFalse() {
        cubeRepository.setCubes(cubes);
        boolean actual = cubeRepository.removeCubeById(0);
        assertFalse(actual);
    }

    @Test(dataProvider = "dataSort")
    public void testSortCubes(CubeComparator comparator, List<Cube> expected) {
        Collections.shuffle(cubes);
        cubeRepository.setCubes(cubes);
        List<Cube> actual = cubeRepository.sortCubes(comparator);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataQuery")
    public Object[][] dataQuery() {
        List<Cube> byIdSpec = new ArrayList<>();
        byIdSpec.add(two);
        List<Cube> bigSizeSpec = new ArrayList<>();
        bigSizeSpec.add(one);
        bigSizeSpec.add(five);
        List<Cube> mediumSizeSpec = new ArrayList<>();
        mediumSizeSpec.add(three);
        mediumSizeSpec.add(six);
        List<Cube> smallSizeSpec = new ArrayList<>();
        smallSizeSpec.add(two);
        smallSizeSpec.add(four);
        List<Cube> negativeLayoutSpec = new ArrayList<>();
        negativeLayoutSpec.add(one);
        negativeLayoutSpec.add(three);
        negativeLayoutSpec.add(six);
        List<Cube> positiveLayoutSpec = new ArrayList<>();
        positiveLayoutSpec.add(four);
        positiveLayoutSpec.add(five);
        return new Object[][]{
                {new ByIdSpecification(2), byIdSpec}, {new BigSizeSpecificationImpl(), bigSizeSpec},
                {new MediumSizeSpecificationImpl(), mediumSizeSpec}, {new SmallSizeSpecificationImpl(), smallSizeSpec},
                {new NegativeLayoutSpecificationImpl(), negativeLayoutSpec}, {new PositiveLayoutSpecificationImpl(), positiveLayoutSpec}
        };
    }

    @DataProvider(name = "dataSort")
    public Object[][] dataSort() {
        List<Cube> idSort = new ArrayList<>();
        idSort.add(one);
        idSort.add(two);
        idSort.add(three);
        idSort.add(four);
        idSort.add(five);
        idSort.add(six);
        List<Cube> edgeSort = new ArrayList<>();
        edgeSort.add(four);
        edgeSort.add(two);
        edgeSort.add(six);
        edgeSort.add(three);
        edgeSort.add(one);
        edgeSort.add(five);
        List<Cube> pointSort = new ArrayList<>();
        pointSort.add(three);
        pointSort.add(one);
        pointSort.add(six);
        pointSort.add(five);
        pointSort.add(four);
        pointSort.add(two);
        return new Object[][]{
                {new CubeComparatorId(), idSort}, {new CubeComparatorEdge(), edgeSort}, {new CubeComparatorPoint(), pointSort}
        };
    }

}