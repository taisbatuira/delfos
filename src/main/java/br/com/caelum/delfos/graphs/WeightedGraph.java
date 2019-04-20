package br.com.caelum.delfos.graphs;

import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.Optional;
import java.util.Set;

public class WeightedGraph implements Graph<Integer, DefaultWeightedEdge> {

    private final org.jgrapht.Graph<Integer, DefaultWeightedEdge> graph;


    public WeightedGraph(org.jgrapht.Graph<Integer, DefaultWeightedEdge> graph) {
        this.graph = graph;
    }

    public org.jgrapht.Graph<Integer, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    @Override
    public Set<Integer> getVertexes() {
        return graph.vertexSet();
    }

    @Override
    public org.jgrapht.Graph<Integer, DefaultWeightedEdge> getGraphT() {
        return graph;
    }

    @Override
    public Optional<Integer> getVertex(Integer vertex) {
        return  graph.vertexSet()
                .stream()
                .filter(v -> v.equals(vertex))
                .findAny();
    }
}
