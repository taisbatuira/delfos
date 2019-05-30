package br.com.caelum.delfos.graphs.visualizations;

import br.com.caelum.delfos.graphs.DefaultGraph;
import br.com.caelum.delfos.graphs.WeightedGraph;
import br.com.caelum.delfos.graphs.infra.GraphFileReader;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PNGVisualizerTest {

    private GraphFileReader reader;
    private DefaultPNGVisualizer test;
    private final String pathDefaultGraph = "data/visualization-default-graph.png";
    private final String pathWeightedGraph = "data/visualization-weighted-graph.png";
    private final String pathToUserPathFromDefaultGraph = "data/visualization-path-user-graph.png";
    private final String pathToUserPathFromWeightedGraph = "data/visualization-path-user-weighted-graph.png";

    @BeforeEach
    void setUp() {
        reader = new GraphFileReader("data/sample.txt");
        test = new DefaultPNGVisualizer();
        test.setUp();
    }

    @Test
    void shouldExportAnImageOfADefaultGraph() {
        DefaultGraph graph = reader.readDefaultGraph();
        Boolean imageExists = test.pathGraph(graph, pathDefaultGraph);
        assertTrue(imageExists);
    }

    @Test
    void shouldExportAnImageOfAWeightedGraph() {
        WeightedGraph graph = reader.readWeightedGraph();
        Boolean imageExists = test.pathGraph(graph, pathWeightedGraph);
        assertTrue(imageExists);
    }

    @Test
    void shouldExportAPathWhenADefaultGraphIsPassed() {
        DefaultGraph graph = reader.readDefaultGraph();
        Boolean imageExists = test.pathToUserPath(graph, pathToUserPathFromDefaultGraph);
        assertTrue(imageExists);
    }

    @Test
    void shouldExportAPathWhenAWeightedGraphIsPassed() {
        WeightedGraph graph = reader.readWeightedGraph();
        Boolean imageExists = test.pathToUserPath(graph,pathToUserPathFromWeightedGraph);
        assertTrue(imageExists);
    }
}