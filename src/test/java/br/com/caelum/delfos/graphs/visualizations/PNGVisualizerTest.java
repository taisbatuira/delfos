package br.com.caelum.delfos.graphs.visualizations;

import br.com.caelum.delfos.graphs.DefaultGraph;
import br.com.caelum.delfos.graphs.WeightedGraph;
import br.com.caelum.delfos.graphs.infra.GraphFileReader;
import br.com.caelum.delfos.graphs.infra.GraphFileReaderFactory;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PNGVisualizerTest {

    private DefaultPNGVisualizer test;
    private final String pathDefaultGraph = "data/visualization-default-graph.png";
    private final String pathWeightedGraph = "data/visualization-weighted-graph.png";
    private final String pathToUserPathFromDefaultGraph = "data/visualization-path-user-graph.png";
    private final String pathToUserPathFromWeightedGraph = "data/visualization-path-user-weighted-graph.png";

    @BeforeEach
    void setUp() {
        test = new DefaultPNGVisualizer();
        test.setUp();
    }

    @Test
    void shouldExportAnImageOfADefaultGraph() {
        DefaultGraph graph = test.getReader().readDefaultGraph();
        Boolean imageExists = test.pathGraph(graph, pathDefaultGraph);
        assertTrue(imageExists);
    }

    @Test
    void shouldExportAnImageOfAWeightedGraph() {
        WeightedGraph graph = test.getReader().readWeightedGraph();
        Boolean imageExists = test.pathGraph(graph, pathWeightedGraph);
        assertTrue(imageExists);
    }

    @Test
    void shouldExportAPathWhenADefaultGraphIsPassed() {
        DefaultGraph graph = test.getReader().readDefaultGraph();
        Boolean imageExists = test.pathToUserPath(graph, pathToUserPathFromDefaultGraph);
        assertTrue(imageExists);
    }

    @Test
    void shouldExportAPathWhenAWeightedGraphIsPassed() {
        WeightedGraph graph = test.getReader().readWeightedGraph();
        Boolean imageExists = test.pathToUserPath(graph,pathToUserPathFromWeightedGraph);
        assertTrue(imageExists);
    }
}