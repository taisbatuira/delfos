package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.Graph;
import org.jgrapht.traverse.BreadthFirstIterator;

import java.util.Iterator;

public class DecoratorBreadthFirstIterator<V, E> implements Decorator<V, E> {

    public Iterator<V> getIterator(Graph<V, E> graph, V start) {
        return new BreadthFirstIterator<>(graph.getGraphT(), start);
    }
}
