package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.Graph;
import org.jgrapht.traverse.BreadthFirstIterator;

import java.util.Iterator;

public class StrategyBreadthFirstIterator<V, E> implements Strategy<V, E> {

    public Iterator<V> getIterator(Graph<V, E> graph, V start) {
        return new BreadthFirstIterator<>(graph.getGraphT(), start);
    }
}
