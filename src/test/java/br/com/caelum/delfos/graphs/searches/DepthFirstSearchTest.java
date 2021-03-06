package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.DefaultGraph;
import br.com.caelum.delfos.graphs.WeightedGraph;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepthFirstSearchTest {

    private DefaultSearchTest test;
    private GraphSearch<Integer> searcher;

    @BeforeEach
    void setUp() {
        test = new DefaultSearchTest();
        test.setUp();
    }

    @AfterEach
    void tearDown() {
        test.tearDown("depth");
    }

    @Test
    void shouldTakeThePathOfADefaultGraphWhenTwoVertexAreSet() {
        DefaultGraph graph = test.getReader().readDefaultGraph();
        searcher = new DepthFirstSearch<>(graph);
        test.shouldTakeThePathOfADefaultGraphWhenTwoVertexAreSet(searcher);
    }

    @Test
    void shouldTakeThePathOfAWeightedGraphWhenTwoVertexAreSet() {
        WeightedGraph graph = test.getReader().readWeightedGraph();
        searcher = new DepthFirstSearch<>(graph);
        test.shouldTakeThePathOfAWeightedGraphWhenTwoVertexAreSet(searcher);
    }
}