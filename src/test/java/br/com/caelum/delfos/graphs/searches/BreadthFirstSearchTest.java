package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.DefaultGraph;
import br.com.caelum.delfos.graphs.WeightedGraph;
import br.com.caelum.delfos.graphs.infra.GraphFileReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BreadthFirstSearchTest {

    private GraphFileReader reader;
    private Integer from;
    private Integer to;
    private LinkedList<Integer> path;

    @BeforeEach
    void setUp() {
        reader = new GraphFileReader("data/sample.txt");
        from = 605;
        to = 289;
    }

    @AfterEach
    void tearDown() {
        System.out.println("Founded path in breadth search: " + path);
    }

    @Test
    void shouldTakeThePathOfADefaultGraphWhenTwoVertexAreSet() {
        DefaultGraph graph = reader.readDefaultGraph();
        GraphSearch<Integer> searcher = new BreadthFirstSearch<>(graph);
        path = searcher.findPath(from, to);

        assertNotNull(path);

        Integer first = path.getFirst();
        assertEquals(from, first);

        Integer last = path.getLast();
        assertEquals(to, last);

    }

    @Test
    void shouldTakeThePathOfAWeightedGraphWhenTwoVertexAreSet() {
        WeightedGraph graph = reader.readWeightedGraph();

        GraphSearch<Integer> searcher = new BreadthFirstSearch<>(graph);
        path = searcher.findPath(from, to);

        assertNotNull(path);

        Integer first = path.getFirst();
        assertEquals(from, first);

        Integer last = path.getLast();
        assertEquals(to, last);
    }
}
