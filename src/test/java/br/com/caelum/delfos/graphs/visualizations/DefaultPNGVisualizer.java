package br.com.caelum.delfos.graphs.visualizations;

import br.com.caelum.delfos.graphs.Graph;
import br.com.caelum.delfos.graphs.infra.GraphFileReader;
import br.com.caelum.delfos.graphs.infra.GraphFileReaderFactory;
import br.com.caelum.delfos.graphs.infra.StringsFile;
import br.com.caelum.delfos.graphs.searches.AStarSearch;
import br.com.caelum.delfos.graphs.searches.GraphSearch;
import org.jgrapht.graph.DefaultEdge;

import java.util.LinkedList;

public class DefaultPNGVisualizer {

    private GraphFileReader reader;
    private int from;
    private int to;

    void setUp() {
        reader = GraphFileReaderFactory.from(StringsFile.DEFAULT_DATA_FILE);
        from = 605;
        to = 289;
    }

    <V> Boolean pathGraph(Graph<Integer, V> graph, String caminho) {
        PNGVisualizer<Integer, V> visualizer = new PNGVisualizer<>();
        return visualizer.export(graph, caminho);
    }

    <V> Boolean pathToUserPath(Graph<Integer, V> graph, String caminho) {
        GraphSearch<Integer> searcher = new AStarSearch<>(graph);
        LinkedList<Integer> path = searcher.findPath(from, to);

        PNGVisualizer<Integer, DefaultEdge> visualizer = new PNGVisualizer<>();
        return visualizer.exportPath(path, caminho);
    }

    public GraphFileReader getReader() {
        return reader;
    }
}
