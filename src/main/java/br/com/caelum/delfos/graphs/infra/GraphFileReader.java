package br.com.caelum.delfos.graphs.infra;


import br.com.caelum.delfos.graphs.GraphDTO;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GraphFileReader {

    private final Path path;

    public GraphFileReader(String path) {
        this.path = Paths.get(path);
    }

    public GraphDTO read() throws IOException {
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter("(\\s)?](\n)?");

        Graph<Integer, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        while(scanner.hasNext()) {
            String line = scanner.next();

            String[] destinations = line.replaceAll("(\\[\\s*|\\[\\d)|(\\n?])", "")
                    .replaceAll("(\\s+)|(\\n\\s?)", " ")
                    .replaceAll("\\s{2,}", " ")
                    .split(" ");

            Integer to = Integer.parseInt(destinations[0]);
            graph.addVertex(to);
            for(int i = 1; i < destinations.length; i++) {
                Integer from = Integer.parseInt(destinations[i]);
                graph.addVertex(from);
                graph.addEdge(to, from);
            }
        }

        return new GraphDTO(graph);
    }
}
