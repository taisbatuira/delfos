package br.com.caelum.delfos.graphs.searches;

import java.util.LinkedList;

public interface GraphSearch<V> {

    LinkedList<V> findPath(V from, V to);
}
