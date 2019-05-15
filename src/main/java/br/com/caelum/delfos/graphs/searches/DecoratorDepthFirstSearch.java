package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.Graph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.Iterator;

public class DecoratorDepthFirstSearch<V, E> implements Decorator<V, E> {

    public Iterator<V> getIterator(Graph<V, E> graph, V start) {
        return new DepthFirstIterator<>(graph.getGraphT(), start);
    }
}