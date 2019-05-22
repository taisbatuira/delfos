package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.Graph;

import java.util.Iterator;

public interface Strategy<V, E> {

    Iterator<V> getIterator(Graph<V, E> graph, V start);
}
