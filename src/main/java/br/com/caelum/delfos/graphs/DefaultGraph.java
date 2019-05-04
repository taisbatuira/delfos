package br.com.caelum.delfos.graphs;

import org.jgrapht.graph.DefaultEdge;

import java.util.Optional;
import java.util.Set;

public class DefaultGraph implements Graph<Integer, DefaultEdge> {


    private final org.jgrapht.Graph<Integer, DefaultEdge> graph;

    public DefaultGraph(org.jgrapht.Graph<Integer, DefaultEdge> graph) {
        this.graph = graph;
    }

    @Override
    public Set<Integer> getVertexes() {
        return graph.vertexSet();
    }

    @Override
    public org.jgrapht.Graph<Integer, DefaultEdge> getGraphT() {
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
