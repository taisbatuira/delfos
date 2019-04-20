package br.com.caelum.delfos.graphs;

import java.util.Optional;
import java.util.Set;

public interface Graph<V, E> {

    Set<V> getVertexes();

    org.jgrapht.Graph<V, E> getGraphT();

    Optional<V> getVertex(V vertex);
}