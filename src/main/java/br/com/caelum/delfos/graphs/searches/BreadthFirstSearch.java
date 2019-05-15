package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.Graph;
import java.util.LinkedList;

public class BreadthFirstSearch<V, E> implements GraphSearch<V> {

    private Graph<V, E> graph;

    public BreadthFirstSearch(Graph<V, E> graph) {
        this.graph = graph;
    }

    @Override
    public LinkedList<V> findPath(V from, V to) {
        return getPath(from, to, graph, new DecoratorBreadthFirstIterator<>());
    }
}
