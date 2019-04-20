package br.com.caelum.delfos.graphs.visualizations;

import br.com.caelum.delfos.graphs.DefaultGraph;
import br.com.caelum.delfos.graphs.WeightedGraph;
import br.com.caelum.delfos.graphs.infra.GraphFileReader;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PNGVisualizerTest {

    private GraphFileReader reader;
    private final String pathDefaultGraph = "data/visualization-default-graph.png";
    private final String pathWeightedGraph = "data/visualization-weighted-graph.png";


    @BeforeEach
    void setUp() {
        reader = new GraphFileReader("data/sample-visualization.txt");
    }

    @Test
    void shouldExportAIMageOfADefaultGraph() {
        DefaultGraph graph = reader.readDefaultGraph();

        PNGVisualizer<Integer, DefaultEdge> visualizer = new PNGVisualizer<>();
        boolean imageExists = visualizer.export(graph, pathDefaultGraph);

        assertTrue(imageExists);
    }

    @Test
    void shouldExportAIMageOfAWeightedGraph() {
        WeightedGraph graph = reader.readWeightedGraph();

        PNGVisualizer<Integer, DefaultWeightedEdge> visualizer = new PNGVisualizer<>();
        boolean imageExists = visualizer.export(graph, pathWeightedGraph);

        assertTrue(imageExists);
    }



}