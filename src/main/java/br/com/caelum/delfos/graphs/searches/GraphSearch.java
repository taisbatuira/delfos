package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.Graph;
import br.com.caelum.delfos.graphs.exceptions.GraphException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

public interface GraphSearch<V> {

    LinkedList<V> findPath(V from, V to);

    default <E> LinkedList<V> getPath(V from, V to, Graph<V, E> graph, Decorator<V, E> decorator) {
        V start;
        LinkedList<V> path= new LinkedList<>();
        Optional<V> vertex = graph.getVertex(from);

        if(!vertex.isPresent()) {
            throw new GraphException("Vertex not present in graph");
        }

        start = vertex.get();

        Iterator<V> search = decorator.getIterator(graph, start);

        while (search.hasNext()) {
            V v = search.next();
            path.add(v);
            if (v.equals(to)) break;
        }
        return path;
    }
}
