package br.com.caelum.delfos.graphs.converters;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.List;

public class ListToGraphT<V> {

    public Graph<V, DefaultEdge> convert(List<V> path) {
        Graph<V, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

        for(int i = 0; i < path.size() - 1; i++) {
            V from = path.get(i);
            V to = path.get(i + 1);
            graph.addVertex(from);
            graph.addVertex(to);
            graph.addEdge(from, to);
        }

        return graph;
    }
}
