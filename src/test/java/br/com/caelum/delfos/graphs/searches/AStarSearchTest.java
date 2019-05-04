package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.DefaultGraph;
import br.com.caelum.delfos.graphs.WeightedGraph;
import br.com.caelum.delfos.graphs.infra.GraphFileReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AStarSearchTest {

    private GraphFileReader reader;
    private DefaultSearchTest test;
    private GraphSearch<Integer> searcher;

    @BeforeEach
    void setUp() {
        reader = new GraphFileReader("data/sample.txt");
        test = new DefaultSearchTest();
        test.setUp();
    }

    @AfterEach
    void tearDown() {
        test.tearDown("A*");
    }

    @Test
    void shouldTakeThePathOfADefaultGraphWhenTwoVertexAreSet() {
        DefaultGraph graph = reader.readDefaultGraph();
        searcher = new AStarSearch<>(graph);
        test.shouldTakeThePathOfADefaultGraphWhenTwoVertexAreSet(searcher);
    }

    @Test
    void shouldTakeThePathOfAWeightedGraphWhenTwoVertexAreSet() {
        WeightedGraph graph = reader.readWeightedGraph();
        searcher = new AStarSearch<>(graph);
        test.shouldTakeThePathOfAWeightedGraphWhenTwoVertexAreSet(searcher);
    }
}