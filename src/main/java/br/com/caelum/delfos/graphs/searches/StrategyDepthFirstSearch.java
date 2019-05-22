package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.Graph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.Iterator;

public class StrategyDepthFirstSearch<V, E> implements Strategy<V, E> {

    public Iterator<V> getIterator(Graph<V, E> graph, V start) {
        return new DepthFirstIterator<>(graph.getGraphT(), start);
    }
}