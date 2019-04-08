package br.com.caelum.delfos.graphs;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class GraphDTO {

    private final Graph<Integer, DefaultWeightedEdge> graph;

    public GraphDTO(Graph<Integer, DefaultWeightedEdge> graph) {
        this.graph = graph;
    }

    public Graph<Integer, DefaultWeightedEdge> getGraph() {
        return graph;
    }
}
