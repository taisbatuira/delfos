package br.com.caelum.delfos.graphs.visualizations;

import br.com.caelum.delfos.graphs.DefaultGraph;
import br.com.caelum.delfos.graphs.WeightedGraph;
import br.com.caelum.delfos.graphs.infra.GraphFileReader;
import br.com.caelum.delfos.graphs.searches.AStarSearch;
import br.com.caelum.delfos.graphs.searches.GraphSearch;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PNGVisualizerTest {

    private GraphFileReader reader;
    private final String pathDefaultGraph = "data/visualization-default-graph.png";
    private final String pathWeightedGraph = "data/visualization-weighted-graph.png";
    private final String pathToUserPathFromDefaultGraph = "data/visualization-path-user-graph.png";
    private final String pathToUserPathFromWeightedGraph = "data/visualization-path-user-weighted-graph.png";
    private int from;
    private int to;


    @BeforeEach
    void setUp() {
        reader = new GraphFileReader("data/sample.txt");
        from = 605;
        to = 289;
    }

    @Test
    void shouldExportAnImageOfADefaultGraph() {
        DefaultGraph graph = reader.readDefaultGraph();

        PNGVisualizer<Integer, DefaultEdge> visualizer = new PNGVisualizer<>();
        boolean imageExists = visualizer.export(graph, pathDefaultGraph);

        assertTrue(imageExists);
    }

    @Test
    void shouldExportAnImageOfAWeightedGraph() {
        WeightedGraph graph = reader.readWeightedGraph();

        PNGVisualizer<Integer, DefaultWeightedEdge> visualizer = new PNGVisualizer<>();
        boolean imageExists = visualizer.export(graph, pathWeightedGraph);

        assertTrue(imageExists);
    }

    @Test
    void shouldExportAPathWhenADefaultGraphIsPassed() {
        DefaultGraph graph = reader.readDefaultGraph();

        GraphSearch<Integer> searcher = new AStarSearch<>(graph);
        LinkedList<Integer> path = searcher.findPath(from, to);

        PNGVisualizer<Integer, DefaultEdge> visualizer = new PNGVisualizer<>();
        boolean imageExists = visualizer.exportPath(path, pathToUserPathFromDefaultGraph);

        assertTrue(imageExists);
    }

    @Test
    void shouldExportAPathWhenAWeightedGraphIsPassed() {
        WeightedGraph graph = reader.readWeightedGraph();

        GraphSearch<Integer> searcher = new AStarSearch<>(graph);
        LinkedList<Integer> path = searcher.findPath(from, to);

        PNGVisualizer<Integer, DefaultEdge> visualizer = new PNGVisualizer<>();
        boolean imageExists = visualizer.exportPath(path, pathToUserPathFromWeightedGraph);

        assertTrue(imageExists);
    }




}