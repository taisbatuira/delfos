package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.DefaultGraph;
import br.com.caelum.delfos.graphs.WeightedGraph;
import br.com.caelum.delfos.graphs.infra.GraphFileReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AStarSearchTest {

    private GraphFileReader reader;
    private Integer from;
    private Integer to;
    private LinkedList<Integer> path;

    @BeforeEach
    void setUp() {
        reader = new GraphFileReader("data/sample.txt");
        from = 440;
        to = 201;
    }

    @AfterEach
    void tearDown() {
        System.out.println("Found path in A* search: " + path);
    }

    @Test
    void shouldTakeThePathOfADefaultGraphWhenTwoVertexAreSet() {
        DefaultGraph graph = reader.readDefaultGraph();
        GraphSearch<Integer> searcher = new AStarSearch<>(graph);
        path = searcher.findPath(from, to);

        assertNotNull(path);

        Integer first = path.getFirst();
        assertEquals(from, first);

        Integer last = path.getLast();
        assertEquals(to, last);

        System.out.print("Default Graph: ");

    }

    @Test
    void shouldTakeThePathOfAWeightedGraphWhenTwoVertexAreSet() {
        WeightedGraph graph = reader.readWeightedGraph();

        GraphSearch<Integer> searcher = new AStarSearch<>(graph);
        path = searcher.findPath(from, to);

        assertNotNull(path);

        Integer first = path.getFirst();
        assertEquals(from, first);

        Integer last = path.getLast();
        assertEquals(to, last);

        System.out.print("Weighted Graph: ");
    }

}