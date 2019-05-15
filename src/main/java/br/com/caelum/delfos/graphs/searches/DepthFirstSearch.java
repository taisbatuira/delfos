package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.Graph;
import java.util.LinkedList;

public class DepthFirstSearch<V, E> implements GraphSearch<V> {

    private final Graph<V, E> graph;

    public DepthFirstSearch(Graph<V, E> graph) {
        this.graph = graph;
    }

    @Override
    public LinkedList<V> findPath(V from, V to) {
        return getPath(from, to, graph, new DecoratorDepthFirstSearch<>());
    }
}
